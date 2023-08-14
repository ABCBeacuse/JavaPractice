package basic.practise.codeblock_;

public class Detail3 {
    public static void main(String[] args) {
        Child1 child1 = new Child1(); //(1) Father1 的普通代码块被调用 (2) Father1 的构造函数被调用 (3) Child1 的普通代码块被执行 (4) Child1 的构造函数被调用
    }
}

class Father1 {

    {
        System.out.println("Father1 的普通代码块被调用");
    }

    public Father1() {
        // (1) 隐藏了 super();
        // (2) 隐藏了普通代码块的执行;
        System.out.println("Father1 的构造函数被调用");
    }
}

class Child1 extends Father1{

    {
        System.out.println("Child1 的普通代码块被执行");
    }

    public Child1() {
        // (1) 隐藏了 super();
        // (2) 隐藏了普通代码块的执行;
        System.out.println("Child1 的构造函数被调用");
    }

}
