package java8.methodquote;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用情况
 */
public class MethodRefTest {

    /**
     * 情况一： 对象 :: 实例方法（非静态方法）
     * Consumer 中的 void accept(T t)
     * PrintStream 中的 void println(T t) 传入的值的类型，返回值的类型 与 accept 方法一样
     */
    @Test
    void test() {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("北京你好");

        PrintStream out = System.out;
        // 方法引用
        Consumer<String> consumer1 = out::println;
        consumer1.accept("Beijing");
    }

    /**
     * 北京你好
     * Beijing
     * <p>
     * Process finished with exit code 0
     */

    @Test
    void test1() {
        Employee jack = new Employee(1, "jack", 20, 1000);
        Supplier<String> supplier = () -> jack.getName();
        System.out.println(supplier.get());
        // jack

        // 方法引用
        // jack 对象中的 getName 方法，需要的参数与返回的类型  和 函数式接口 Supplier 中 唯一抽象方法 String get(); 一致，所以这里可以使用方法引用
        Supplier<String> supplier1 = jack::getName;
        System.out.println(supplier1.get());
        // jack
    }

    /**
     * 情况二： 类::静态方法
     * Comparator 中的 int compare(T t1, T t2)
     * Integer 中的 int compare(int t1, int t2)
     */

    @Test
    void test3() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator.compare(12, 21));
        // -1

        // 方法引用
        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println(comparator1.compare(12, 2));
        // 1
    }

    /**
     * Function<T, R> 中的 R apply(T t)
     * Math 中的 Long round(Double d)
     */
    @Test
    void test4() {
        Function<Double, Long> func = o1 -> Math.round(o1);
        System.out.println(func.apply(12.3));
        // 12

        // 方法引用 Math 中的 Long round(Double d) 方法与 此时 Function 接口中的 apply 抽象方法的 形参列表 和 返回类型 一致。
        Function<Double, Long> func1 = Math::round;
        System.out.println(func1.apply(12.6));
        // 13
    }

    /**
     * 情况三： 类::实例方法（非静态方法） 有难度
     * Comparator<T> 接口中的 int compare(T t1, T t2)
     * <p>
     * 上面的 compare 方法有两个参数，第一个参数是作为 调用者出现的。这种情况下，也存在方法引用
     * 这种情况下，不是拿具体对象写的，是拿 类 写的
     * String 中的 int t1.compareTo(t2)
     */
    @Test
    void test5() {
        Comparator<String> comparator = (t1, t2) -> t1.compareTo(t2);
        System.out.println(comparator.compare("abc", "abcd"));
        // -1

        Comparator<String> comparator1 = String::compareTo;
        System.out.println(comparator1.compare("abc", "abcd"));
        // -1
    }

    /**
     * BiPredicate<T, U> 中的 boolean test(T t1, U u1)
     * <p>
     * 上面的 test 方法有两个参数，第一个参数是作为 调用者出现的。这种情况下，也存在方法引用
     * 这种情况下，不是拿具体对象写的，是拿 类 写的
     * String 中的 boolean t1.equals(t2)
     */
    @Test
    void test6() {
        BiPredicate<String, String> predicate = (s1, s2) -> s1.equals(s2);
        System.out.println(predicate.test("abc", "abc"));
        // true

        BiPredicate<String, String> predicate1 = String::equals;
        System.out.println(predicate1.test("abc", "abd"));
        // false
    }

    /**
     * Function<T, R> 中的 R apply(T t1)
     * 上面方法中唯一一个参数，就做为了下面方法的调用者
     *
     * Employee 中的 String getName()
     */
    @Test
    void test7() {
        Employee jack = new Employee(1, "jack", 20, 1000);
        Function<Employee, String> func = e -> e.getName();
        System.out.println(func.apply(jack));
        // jack

        Function<Employee, String> func1 = Employee::getName;
        System.out.println(func1.apply(jack));
        // jack
    }
}
