package basic.practise.wrapper;

public class StringAndInteger {
    public static void main(String[] args) {
        // Intger --> String
        // 自动装箱 int -> Integer
        Integer n1 = 100; // 底层是 Integer.valueOf(100)

        // 方式一 (以 n1 为基础，创建一个新的 String 对象，并赋值给 str)
        String str = n1 + "";
        // 方式二 (使用 Integer 包装类自带的 toString() 方法)
        String str2 = n1.toString();
        // 方式三 ()
        // String.valueOf(int i) ，这里包含了自动拆箱，自动拆箱底层是 intValue() 方法;
        String str3 = String.valueOf(n1);

        // String --> Integer
        String str4 = "12345";
        Integer integer = Integer.valueOf(str4);
        Integer integer1 = Integer.parseInt(str4); // parseInt() 返回的是 int, 自动装箱，底层是 Integer.valueOf()
        Integer integer2 = new Integer(str4); // 构造器形成
    }
}
