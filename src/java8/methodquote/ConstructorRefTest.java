package java8.methodquote;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器引用的使用情况
 */
public class ConstructorRefTest {
    /**
     * 构造器引用
     * Supplier 中的 get()
     * Employee 的空参构造器：    public Employee() {}
     * <p>
     * 空参构造器也是 什么都不传，然后返回一个 Employee 对象
     */
    @Test
    void test() {
        Supplier<Employee> supplier = () -> new Employee();
        System.out.println(supplier.get());
        // Employee{id=null, name='null', age=null, salary=null}

        Supplier<Employee> supplier1 = Employee::new;
        System.out.println(supplier1.get());
        // Employee{id=null, name='null', age=null, salary=null}
    }

    /**
     * Function<T, R> 中的 R apply(T t)
     * 接收一个 T 类型的参数，返回一个 R 类型的对象
     * <p>
     * 与 Employee 中 public Employee(Integer id) {this.id = id;} 一样
     */
    @Test
    void test1() {
        Function<Integer, Employee> func = id -> new Employee(id);
        System.out.println(func.apply(1001));
        // Employee{id=1001, name='null', age=null, salary=null}

        // 会自动匹配 Employee 的一个构造器函数，该构造器函数接收一个 Integer 类型的参数
        Function<Integer, Employee> func1 = Employee::new;
        System.out.println(func1.apply(1002));
        // Employee{id=1002, name='null', age=null, salary=null}
    }

    /**
     * BiFunction<T, U, R> 中的 R apply(T t, U u);
     * 接收一个 T 类型的参数和一个 U 类型的参数，返回一个 R 类型的对象
     * <p>
     * 与 Employee 中 public Employee(Integer id, String name) {this.id = id;this.name = name;} 一样
     */
    @Test
    void test2() {
        BiFunction<Integer, String, Employee> bFunc = (id, name) -> new Employee(id, name);
        System.out.println(bFunc.apply(1002, "abc"));
        // Employee{id=1002, name='abc', age=null, salary=null}

        BiFunction<Integer, String, Employee> bFunc1 = Employee::new;
        System.out.println(bFunc1.apply(1003, "rose"));
        // Employee{id=1003, name='rose', age=null, salary=null}
    }

    /**
     * 数组引用
     * Function<T, U> 中的 U apply(T t);
     *
     * 可以将 new U[t] 类型看做是一个构造器
     */
    @Test
    void test3() {
        Function<Integer, String[]> func = length -> new String[length];
        String[] strs = func.apply(5);
        System.out.println(Arrays.toString(strs));
        // [null, null, null, null, null]

        Function<Integer, String[]> func1 = String[]::new;
        String[] apply = func1.apply(10);
        System.out.println(Arrays.toString(apply));
        // [null, null, null, null, null, null, null, null, null, null]
    }
}
