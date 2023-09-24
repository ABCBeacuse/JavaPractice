package java8.stream;

import java8.methodquote.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Stream API 的中间操作：排序
 */
public class StreamSortTest {

    /**
     * 自然排序
     */
    @Test
    void test() {
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        // 此时 sorted() 方法底层默认使用的是 Integer.compare() 方法，因为 Integer 实现了 comparator 接口的 compare 方法
        list.stream().sorted().forEach(System.out::println);
        List<Employee> employees = Employee.getEmployees();
        // java8.methodquote.Employee cannot be cast to java.lang.Comparable
        // 抛异常：原因 Employee 没有实现 Comparator 接口
        // employees.stream().sorted().forEach(System.out::println);
        /**
         * Comparator 接口
         *
         * int compare(T o1, T o2);
         */
        employees.stream().sorted((e1, e2) -> {
            // 先根据年龄从小到大排序，如果年龄相同，则按照工资从小到大
            int compare = Integer.compare(e1.getAge(), e2.getAge());
            if (compare != 0) {
                return compare;
            }
            return Integer.compare(e1.getSalary(), e2.getSalary());
            // 如果需要 salary 从大到小，则 return -Integer.compare(e1.getSalary(), e2.getSalary());
        }).forEach(System.out::println);
    }

    /**
     * -98
     * 0
     * 7
     * 12
     * 34
     * 43
     * 65
     * 87
     * Employee{id=1002, name='马云', age=12, salary=9876}
     * Employee{id=1004, name='雷军', age=26, salary=7657}
     * Employee{id=1003, name='刘强东', age=33, salary=3000}
     * Employee{id=1006, name='比尔盖茨', age=42, salary=9500}
     * Employee{id=1005, name='李彦宏aa', age=65, salary=5555}
     * Employee{id=1001, name='马化腾', age=94, salary=6000}
     *
     * Process finished with exit code 0
     */
}
