package basic.practise.wrapper;

public class Integer03 {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); // False ，因为是两个不同的对象

        // 主要看范围 -128 ~ 127 ，如果在这个范围，就是直接返回，不 new
        Integer m = 1; // 底层 Integer.valueOf(1) -> 阅读源码
        Integer n = 1; // 底层 Integer.valueOf(1)
        System.out.println(m == n); // True

        // 因为 128 不在范围 -127 ~ 128，所以会 new Integer(128)
        Integer x = 128; // 底层 Integer.valueOf(128)
        Integer y = 128; // 底层 Integer.valueOf(128)
        System.out.println(x == y); // False
    }
}
