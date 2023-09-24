package regexp;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp10 {
    public static void main(String[] args) {
        // 匹配汉字
        String content = "韩顺平教育";
        // 中文的 Unicode 编码
        String regExp = "^[\u0391-\uffe5]+$";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }
    }

    @Test
    void test2() {
        // 邮政编码
        // 要求 是 1-9 开头的一个六位数
        String content = "123890";
        // 中文的 Unicode 编码
        String regExp = "^[1-9]\\d{5}$";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }
    }

    @Test
    void test3() {
        // QQ 号码
        // 要求 是 1-9 开头的一个(5位数-10位数)
        String content = "1305198449";
        // 中文的 Unicode 编码
        String regExp = "^[1-9]\\d{4,9}$";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }
    }

    @Test
    void test4() {
        // 手机 号码
        // 要求 必须以13, 14, 15, 18 开头的 11 位数，比如
        String content = "15588889999";
        // 中文的 Unicode 编码
        String regExp = "^1(?:3|4|5|8)\\d{9}$";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }
    }

    @Test
    void test5() {
        // 手机 号码
        // 要求 必须以13, 14, 15, 18 开头的 11 位数，比如
        String content = "15588889999";
        // 中文的 Unicode 编码
        String regExp = "^1(?:3|4|5|8)\\d{9}$";
        boolean result = Pattern.matches(regExp, content);
        if (result) {
            System.out.println("完全匹配，满足正则的规则");
        }
    }

    @Test
    void test6() {
        // 手机 号码
        // 要求 必须以13, 14, 15, 18 开头的 11 位数，比如
        String content = "hello hanshunping hello ";
        // 中文的 Unicode 编码
        String regExp = "hello";
        boolean result = Pattern.matches(regExp, content);
        if (result) {
            System.out.println("完全匹配，满足正则的规则");
        } else {
            // 因为这里匹配的是开头的 hello 和 结尾的 hello，并不是匹配的整个字符串，所以并不是完全匹配
            System.out.println("没有完全匹配");
        }
    }
}
