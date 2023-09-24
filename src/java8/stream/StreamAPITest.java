package java8.stream;

import java8.methodquote.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest {

    /**
     * 1 - 筛选与切片
     */
    @Test
    void test1() {
        List<Employee> employees = Employee.getEmployees();
        Stream<Employee> stream = employees.stream();
        // filter(Predicate p) —— 接收 Lambda，从流中排除某些元素
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        /**
         *  上方的 stream 已经使用终止操作，所以不能重新回到中间过程。如果需要再次使用，则需要重新创建 stream
         *  java.lang.IllegalStateException: stream has already been operated upon or closed
         *
         *  limit(n) —— 截断流，使其元素不超过给定数量
         *  stream.limit(10);
         *  java.lang.IllegalStateException: stream has already been operated upon or closed
         */
        System.out.println("************************");
        // 需要重新创建
        employees.stream().limit(2).forEach(System.out::println);

        System.out.println("************************");
        // skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流
        employees.stream().skip(30).forEach(System.out::println);

        // distinct() —— 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
    }
    /**
     * Employee{id=1002, name='马云', age=12, salary=9876}
     * Employee{id=1004, name='雷军', age=26, salary=7657}
     * Employee{id=1006, name='比尔盖茨', age=42, salary=9500}
     * ************************
     * Employee{id=1001, name='马化腾', age=94, salary=6000}
     * Employee{id=1002, name='马云', age=12, salary=9876}
     * ************************
     *
     * Process finished with exit code 0
     */

    /**
     * 2 - 映射
     */
    @Test
    void test2() {
        // map(Function f) —— 接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(e -> e.toUpperCase()).forEach(System.out::println);

        System.out.println("*************************");
        // 练习：获取员工姓名长度大于 3 的员工的姓名
        List<Employee> employees = Employee.getEmployees();
        // <? super Employee> 代表啥意思
        employees.stream().map(Employee::getName).filter(n -> n.length() > 3).forEach(System.out::println);
    }

    /**
     * AA
     * BB
     * CC
     * DD
     * *************************
     * 李彦宏aa
     * 比尔盖茨
     */

    @Test
    void test3() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest::fromStringToStream);
        // 相当于 Stream 流中嵌套着 Stream 流，双层
        // 下方的 s 也代表着一个 Stream<Character>
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        /**
         * a
         * a
         * b
         * b
         * c
         * c
         * d
         * d
         */
        System.out.println("*******************");
        // 如果使用 flatMap() 方法，flat 扁平化，flatMap 会把 Stream<Stream<Character>> 中的 Stream<Character> 拆开，变成没有嵌套的 Stream<Character>
        Stream<Character> stream = list.stream().flatMap(StreamAPITest::fromStringToStream);
        stream.forEach(System.out::println);
        /**
         * a
         * a
         * b
         * b
         * c
         * c
         * d
         * d
         */
    }

    // 将字符串中的多个字符构成的集合转换为对应的 Stream 的实例
    private static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
}
