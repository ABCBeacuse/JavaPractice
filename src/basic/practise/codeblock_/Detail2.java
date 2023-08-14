package basic.practise.codeblock_;

public class Detail2 {
    public static void main(String[] args) {
        Child child = new Child(); // (1) Child 静态代码块 (2) getVal() 被调用... (3) Child 普通代码块 (4) getN2() 被调用... (5) Child 无参构造器执行
    }
}

class Child {

    // 普通代码块
    {
        System.out.println("Child 普通代码块");
    }

    // 静态代码块
    static {
        System.out.println("Child 静态代码块");
    }

    // 静态属性的初始化
    public static int n1 = getVal();

    // 普通属性的初始化
    public int n2 = getN2();

    private int getN2() {
        System.out.println("getN2() 被调用...");
        return 200;
    }

    private static int getVal() {
        System.out.println("getVal() 被调用...");
        return 100;
    }

    public Child() {
        System.out.println("Child 无参构造器执行");
    }
}
