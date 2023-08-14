package basic.practise.interface_;

public class InnerClass {  // 外部其他类
}

class Outer { // 外部类
    // 属性
    private int n1 = 100;

    // 普通代码块
    {
        System.out.println("代码块...");
    }

    // 构造器
    public Outer(int n1) {
        this.n1 = n1;
    }

    // 方法
    public void m1() {
        System.out.println("m1()");
    }

    // 内部类，在 Outer 类的内部
    class Inner {

    }
}
