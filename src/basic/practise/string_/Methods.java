package basic.practise.string_;

public class Methods {
    public static void main(String[] args) {
        String str = null; // ok

        StringBuffer buffer = new StringBuffer(); // ok
        buffer.append(str);// ok，查看源码发现不会报错
        System.out.println(buffer); // 实际调用 buffer.toString() 方法，输出 “null”
        System.out.println(buffer.length()); // 4

        // 下面的构造器会抛出 空指针异常 NLP
        StringBuffer stringBuffer = new StringBuffer(str); // 这里查看源码，发现会去调用 str.length() 即 null.length()，所以会出现 NLP
        System.out.println(stringBuffer);
    }
}
