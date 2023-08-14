package basic.practise.wrapper;

public class Test {
    public static void main(String[] args) {
        Double d = 100d; // ok ，自动装箱，底层调用 Double.valueOf(100d);
        Float f = 1.5f; // ok ，自动装箱，底层调用 Float.valueOf(1.5f);

        // 三元运算符 是一个整体，会提升精度
        Object obj1 = true ? new Integer(1) : new Double(2.0d);
        System.out.println(obj1); // 1.0

        // if-else 并不是一个整体，不会提升精度
        Object obj2;
        if(true) {
            obj2 = new Integer(1);
        }else {
            obj2 = new Double(2.0);
        }
        System.out.println(obj2); // 1
    }
}
