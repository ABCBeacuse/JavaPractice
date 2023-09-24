package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String content = "hanshunping s7789 nn1189han";
        /**
         * 下面就是非命名分组
         * 1. matcher.group(0) 得到匹配到的字符串
         * 2. matcher.group(1) 得到匹配到的字符串的第 1 个分组内容
         * 3. matcher.group(2) 得到匹配到的字符串的第 2 个分组内容
         */
        Pattern pattern = Pattern.compile("(\\d\\d)(\\d)(\\d)");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }
    }
    /*
        7789
        77
        8
        9
        1189
        11
        8
        9
    */

    /**
     * 命名分组 (?<name>RegExp)
     * <p>
     * 用于 name 的字符串不能包含任何标点符号，并且不能以数字开头
     */
    @org.junit.jupiter.api.Test
    void test() {
        String content = "hanshunping s7789 nn1189han";
        Pattern pattern = Pattern.compile("(?<g1>\\d\\d)(?<g2>\\d\\d)");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("通过分组名称来取: " + matcher.group("g1"));
            System.out.println("通过分组编号来取： " + matcher.group(2));
        }
    }
}
