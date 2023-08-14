package basic.practise.wrapper;

public class Integer04 {
    public static void main(String[] args) {
        Integer i = new Integer(127);
        // == 号 有一边是基本数据类型，判断的就是值是否相等
        System.out.println(127 == i); // True

        Integer j = new Integer(128);
        System.out.println(128 == j); // True
    }
}
