package java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda 表达式的使用举例
 */
public class LambdaTest {

    @Test
    void test() {
        // runnable 是一个实现了 Runnable 接口的匿名类对象
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("原始写法：Hello，你好");
            }
        };
        runnable.run();
        // 因为 Runnable 接口中只有 run 一个方法, 所以可以使用 lambda 表达式简写
        Runnable runnable1 = () -> System.out.println("lambda 写法：你好, lambda");
        runnable1.run();

        // comparator 是一个实现了 Comparator 接口的匿名类对象
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println("原始写法：" + comparator.compare(12, 21));
        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println("lambda 写法：" + comparator1.compare(23, 12));

        // 方法引用
        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println("方法引用：" + comparator2.compare(12, 21));
    }

    @Test
    void test2() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("你好");

        // 修改为 lambda 表达式
        Consumer<String> consumer1 = (s) -> {
            System.out.println(s);
        };
        consumer1.accept("你好，我是 lambda 写法");

        // 修改为 lambda 表达式
        Consumer<String> consumer2 = s -> {
            System.out.println(s);
        };
        consumer2.accept("你好，我是 lambda 写法");
    }

    @Test
    void test3() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(comparator.compare(12, 10));

        // lambda 表达式简化
        Comparator<Integer> comparator1 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1, o2);
        };
        System.out.println(comparator1.compare(100, 101));
    }

    @Test
    void test4() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(comparator.compare(12, 10));

        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator1.compare(100, 98));

        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("你好");
    }
}
