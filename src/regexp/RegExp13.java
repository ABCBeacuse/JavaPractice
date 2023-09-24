package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp13 {
    public static void main(String[] args) {
        String content = "我.....我要学.....学学学..学编程java!";
        // 清除.
        content = Pattern.compile("[.]").matcher(content).replaceAll("");

        // 清除重复字
        Matcher matcher = Pattern.compile("(.)\\1+").matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
        content = matcher.replaceAll("$1");
        System.out.println(content);
    }
}

/*
    我我
    学学学学学
    我要学编程java!
 */
