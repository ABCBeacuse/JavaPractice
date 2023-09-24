package java8.stream;

import java8.methodquote.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 获取 stream 流的三种方式
 */
public class getStream {

    /**
     * 通过集合 Collection 接口
     */
    @Test
    void test() {
        List<Employee> employees = Employee.getEmployees();

        // default Stream<E> stream() ： 返回一个顺序流
        // 顺序流 读取的 集合内容顺序 和 集合添加顺序一致
        Stream<Employee> stream = employees.stream();

        // default Stream<E> parallelStream() ： 返回一个并行流
        // 并行流 读取的 集合内容顺序 和 集合添加顺序不一定一致
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    /**
     * 通过数组
     */
    @Test
    void test1() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        /**
         *   public static <T> Stream<T> stream(T[] array) {
         *       // 返回一个流
         *       return stream(array, 0, array.length);
         *   }
         */
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "rose", 23, 1000);
        Employee e2 = new Employee(1002, "jack", 24, 2000);
        Employee[] employees = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(employees);
    }

    /**
     * 可以调用 Stream 类静态方法 of(), 通过显示值创建一个流。它可以接收任意数量的参数。
     * <p>
     * public static<T> Stream<T> of(T... values)：返回一个流
     */
    @Test
    void test2() {
        Employee e1 = new Employee(1001, "rose", 23, 1000);
        Employee e2 = new Employee(1002, "jack", 24, 2000);
        Stream<Employee> e11 = Stream.of(e1, e2);
    }

    // 创建 Stream 方式四：创建无限流
    @Test
    void test3() {
        // 迭代
        // public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f) {}
        // 传入的是基本类型，会被包装为 包装类型 int -> Integer
        /**
         * @FunctionalInterface
         * public interface UnaryOperator<T> extends Function<T, T> {
         */
        // 创建 Stream 流，该 Stream 为 无限流，该 Stream 操作的容器 会不停的生成数字
        Stream<Integer> iterate = Stream.iterate(0, t -> t + 2);
        // 中间操作
        iterate = iterate.limit(10);
        // 终止操作
        // iterate.forEach(e -> System.out.println(e));
        // 需要传递一个 Consumer 接口的 实例
        iterate.forEach(System.out::println);
    }

    /**
     * 0
     * 2
     * 4
     * 6
     * 8
     * 10
     * 12
     * 14
     * 16
     * 18
     */

    // 创建 Stream 方式四：创建无限流
    @Test
    void test4() {
        // 需要填入一个 Supplier 接口的 实例，Supplier 接口中抽象方法：接收零参数，返回一个对象  T get();
        /**
         *     public static<T> Stream<T> generate(Supplier<T> s) {
         */
        // 类::静态方法
        // 创建无限流
        Stream<Double> stream = Stream.generate(Math::random);
        // 中间操作
        stream = stream.limit(10);
        // 终止操作(需要 Consumer 接口)
        stream.forEach(System.out::println);
    }
    /**
     * 0.20855287710352777
     * 0.3041949052924129
     * 0.175181653335582
     * 0.9452326834109477
     * 0.42225749314439665
     * 0.4300485006372461
     * 0.8458754288212932
     * 0.32350253119572525
     * 0.5603971460049179
     * 0.2541744006217779
     *
     * Process finished with exit code 0
     */
}
