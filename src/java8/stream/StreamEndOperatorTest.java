package java8.stream;

import java8.methodquote.Employee;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Stream API 终止操作练习
 */
public class StreamEndOperatorTest {

    /**
     * 1. 匹配 与 查找
     */
    @Test
    void test() {
        List<Employee> employees = Employee.getEmployees();

        // allMatch(Predicate p)：检查是否匹配所有元素 （检查是否所有的员工的年龄都大于 18）
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);
        // false

        // anyMatch(Predicate p)：检查是否至少匹配一个元素
        // 因为 allMatch(Predicate p) 是终止操作，所以 上方的 stream 流不能重复使用
        boolean b1 = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(b1);
        // false

        // noneMatch(Predicate p)：检查是否没有匹配的元素
        boolean b2 = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(b2);
        // false

        // findFirst：返回第一个元素，
        Optional<Employee> employee = employees.stream().findFirst();
        // Optional 在下一节，这里可以看做是一个容器
        System.out.println(employee);
        // Optional[Employee{id=1001, name='马化腾', age=94, salary=6000}]

        // findAny：返回当前流中的任意元素
        Optional<Employee> employee1 = employees.stream().findAny();
        System.out.println(employee1);

        // count：返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getAge() > 18).count();
        System.out.println(count);
        // 5

        // max(Comparator c) —— 返回流中的最大值
        Optional<Integer> maxSalary = employees.stream().map(e -> e.getSalary()).max(Integer::compare);
        System.out.println(maxSalary);
        // Optional[9876]

        // min(Comparator c) —— 返回流中的最小值
        // 返回最低工资的员工
        Optional<Employee> minSalaryEmployee = employees.stream().min((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(minSalaryEmployee);
        // Optional[Employee{id=1003, name='刘强东', age=33, salary=3000}]

        // forEach(Consumer c) —— 内部迭代
    }

    /**
     * 2. 归约
     */
    @Test
    void test2() {
        // reduce(T identity, BinaryOperator b) —— 可以将流中的元素反复结合起来，得到一个值。并返回。
        // T identity 为一个初始值
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        /**
         *     public static int sum(int a, int b) {
         *         return a + b;
         *     }
         */
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        // 55

        // reduce(BinaryOperator b) —— 可以将流中元素反复结合起来，得到一个值。返回一个 Optional<T>
        List<Employee> employees = Employee.getEmployees();
        Optional<Integer> sumSalary = employees.stream().map(Employee::getSalary).reduce(Integer::sum);
        System.out.println(sumSalary);
        // Optional[41588]
    }

    /**
     * 3. 收集
     */
    @Test
    void test3() {
        List<Employee> employees = Employee.getEmployees();
        // 查找工资大于 6000 的员工，结果返回一个 List 或 Set
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);

        System.out.println("**************");
        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);
    }
    /**
     * Employee{id=1002, name='马云', age=12, salary=9876}
     * Employee{id=1004, name='雷军', age=26, salary=7657}
     * Employee{id=1006, name='比尔盖茨', age=42, salary=9500}
     * **************
     * Employee{id=1004, name='雷军', age=26, salary=7657}
     * Employee{id=1006, name='比尔盖茨', age=42, salary=9500}
     * Employee{id=1002, name='马云', age=12, salary=9876}
     *
     * Process finished with exit code 0
     */
}
