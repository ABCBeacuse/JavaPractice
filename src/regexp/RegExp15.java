package regexp;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp15 {
    /**
     * 验证电子邮件格式是否合法
     * <p>
     * 规则：
     * 1. 只能有一个 @
     * 2. @前面是用户名，可以是 a-z A-Z 0-9 _ - 字符
     * 3. @后面是域名，并且域名只能是英文字母，比如 sohu.com 或者 tsinghua.org.cn
     * 4. 写出对应的正则表达式，验证输入的字符串是否满足规则
     *
     * @param args
     */
    public static void main(String[] args) {
        String email = "1305198449@tsinghua.org.cn";
        // 注意：. 写在 [] 中代表 . 本身；写在其他位置 . 代表匹配除了 \n 外的任意字符
        // String 的 matches 是整体匹配，如果匹配的结果和原字符串不一致，则 matches 方法返回 false
        boolean matches = email.matches("^[\\w-]+@([a-zA-Z]+\\.)+c(?:om|n)$");
        /**
         *     public boolean matches(String regex) {
         *         return Pattern.matches(regex, this);
         *     }
         *
         *     public static boolean matches(String regex, CharSequence input) {
         *         Pattern p = Pattern.compile(regex);
         *         Matcher m = p.matcher(input);
         *         return m.matches();
         *     }
         *
         *     public boolean matches() {
         *         return match(from, ENDANCHOR);
         *     }
         *
         */
        System.out.println("匹配结果：" + matches);
    }

    /**
     * 要求验证是不是整数或者小数
     * <p>
     * 提示：需要考虑正数和负数
     * 比如：123 -345 34.89 -87.9 -0.01 0.45
     * <p>
     * 思路：
     * 1. 先写出简单的正则表达式
     * 2. 再逐步的完善[ 根据各种情况来完善 ]
     */
    @Test
    void test() {
        String number = "-0.12";
        boolean res = number.matches("^[+-]?([1-9]\\d*|0)(\\.\\d+)?$");
        if (res) {
            System.out.println("匹配成功，是整数或者小数");
        } else {
            System.out.println("匹配失败");
        }
    }

    /**
     * a) 要求得到协议是什么？        http
     * b) 域名是什么?               www.sohu.com
     * c) 端口是什么?               8080
     * d) 文件名是什么?             index.htm
     */
    @Test
    void test1() {
        String content = "https://www.sohu.com:8080/abc/index.htm";
        //String content = "https://bcdh.yuque.com/staff-wpxfif/resource?";
        Matcher matcher = Pattern.compile("^(https?)://([a-z.]+)(:(\\d{4,5}))?/([\\w-]+/)*(.+)$").matcher(content);
        while (matcher.find()) {
            System.out.println("协议：" + matcher.group(1));
            System.out.println("域名：" + matcher.group(2));
            System.out.println("端口：" + matcher.group(4));
            System.out.println("文件名：" + matcher.group(6));
        }
    }
    /**
     * 协议：https
     * 域名：www.sohu.com
     * 端口：8080
     * 文件名：index.htm
     */
}
