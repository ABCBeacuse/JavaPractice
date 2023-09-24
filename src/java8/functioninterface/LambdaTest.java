package java8.functioninterface;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaTest {

    @Test
    void test() {
        happyTime(1000.2, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("买一瓶矿泉水花费：" + aDouble);
            }
        });

        // 使用 lambda 表达式来简化
        happyTime(120.2, money -> System.out.println("消费：" + money));
    }

    private void happyTime(Double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }


    @Test
    void test2() {
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        List<String> filterStrings = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStrings);

        // 使用 lambda 表达式来写
        List<String> strings = filterString(list, s -> s.contains("京"));
        System.out.println(strings);
    }
    /*
        [北京, 南京, 东京, 西京, 普京]
        [北京, 南京, 东京, 西京, 普京]
     */

    // 根据给定的规则，过滤集合中的字符串。此规则由 Predicate 的方法决定
    private List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                arrayList.add(s);
            }
        }
        return arrayList;
    }
}
