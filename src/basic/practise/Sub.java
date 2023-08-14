package basic.practise;

/**
 * 子类
 */
public class Sub extends Base {

    public Sub() {
        System.out.println("Sub()....");
    }

    public Sub(String name, int age) {
        // 1. 要调用父类的无参构造器，如下写一个 super() 或者什么都不写，默认就是调用 super()
        // super(); //父类的无参构造器
        // 2. 要调用父类的 Base(String name) 构造器
        // super("hsp");
        // 3. 要调用父类的 Base(String name, int age) 构造器
//        super("king", 20);
    }

    public void sayOk() {
        callTest400();
    }
}
