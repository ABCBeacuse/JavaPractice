package basic.practise.string_;

public class String01 {
    public static void main(String[] args) {
        String a = "jack";
        String b = new String("jack");

        System.out.println(a == b.intern()); // 比较的是地址 true
        System.out.println(b == b.intern()); // false (左边是指向堆中的对象地址，右边是常量池中的地址)
    }
}
