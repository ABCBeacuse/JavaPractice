package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Matcher 类的常用方法
 */
public class MatcherMethod {
    public static void main(String[] args) {
        String content = "hello edu jack hspedutom hello smith hello hspedu hspedu";
        String regExp = "hello";

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("==================");
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            System.out.println("找到 " + content.substring(matcher.start(), matcher.end()));
        }

        // 整体匹配方法，常用于，去校验某个字符串是否满足某个规则
        System.out.println("整体匹配" + matcher.matches());

        // 完成 content 中的 hspedu 替换成 韩顺平教育
        regExp = "hspedu";
        Pattern pattern1 = Pattern.compile(regExp);
        Matcher matcher1 = pattern1.matcher(content);
        String result = matcher1.replaceAll("韩顺平教育");
        System.out.println(result);
        System.out.println(content);
    }
}

/*
    ==================
    0
    5
    找到hello
    ==================
    25
    30
    找到hello
    ==================
    37
    42
    找到hello
    整体匹配false
    hello edu jack 韩顺平教育tom hello smith hello 韩顺平教育 韩顺平教育
 */
