package basic.practise.string_;

public class String03 {
    public static void main(String[] args) {
        String a = "hello";
        String b = "abc";

        // 1. 创建一个 StringBuilder sb = new StringBuilder()，能容纳 16 个字符默认
        // 2. 使用 sb.append("hello")，向 sb 这个 StringBuilder 中添加 "hello" 5个字符
        // 3. 使用 sb.append("abc")，向 sb 这个 StringBuilder 中添加 "abc" 3个字符
        // 4. 使用 sb.toString() 方法，return 一个 new String(value) 新的字符串对象
        // tip: value 为 char[] 数组，16 字符长度，count 为 8
        /**
         *     public String toString() {
         *         // Create a copy, don't share the array
         *         return new String(value, 0, count);
         *     }
         */
        String c = a + b;
        String d = "helloabc";
        System.out.println(c == d); // false
        String e = "hello" + "abc";
        System.out.println(d == e); // true
    }
}
