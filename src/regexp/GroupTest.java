package regexp;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupTest {

    @Test
    void test() {
        String content = "hello韩顺平教育 jack韩顺平老师 韩顺平同学hello";
        // 找到 韩顺平教育 韩顺平老师 韩顺平同学
        // String regExp = "韩顺平教育|韩顺平老师|韩顺平同学";
        // 上面的写法可以等价非捕获分组，注意：不能 matcher.group(1)，因为这个分组是非捕获的，不会被 group 存储
        String regExp = "韩顺平(?:教育|老师|同学)";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

    @Test
    void test1() {
        String content = "hello韩顺平教育 jack韩顺平老师 韩顺平同学hello";
        // 找到 韩顺平 这个关键字，但是要求只是查找 韩顺平教育 和 韩顺平老师 中包含的韩顺平
        Pattern pattern = Pattern.compile("韩顺平(?=教育|老师)");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
    /**
     * 韩顺平 （韩顺平教育 中的 韩顺平）
     * 韩顺平 （韩顺平老师 中的 韩顺平）
     */


    @Test
    void test2() {
        String content = "hello韩顺平教育 jack韩顺平老师 韩顺平同学hello";
        // 找到 韩顺平 这个关键字，但是要求只是查找 不是 韩顺平教育 和 韩顺平老师 中包含的韩顺平
        // 下面也是非捕获分组，不能使用 matcher.group(1)，会报错
        Pattern pattern = Pattern.compile("韩顺平(?!教育|老师)");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
    /**
     * 韩顺平 (韩顺平同学 中的 韩顺平)
     */


    @Test
    void test3() {
        String content = "hello111111 ok";
        // 默认是贪婪匹配
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
        // 111111
    }

    @Test
    void test4() {
        String content = "hello111111 ok";
        // 非贪婪匹配
        Pattern pattern = Pattern.compile("\\d+?");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
        /*
            1
            1
            1
            1
            1
            1
         */
    }
}
