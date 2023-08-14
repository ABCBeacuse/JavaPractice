package basic.practise.static_;

public class Child {

    private String name;

    public static int count = 0;

    public Child(String name) {
        this.name = name;
    }

    public void join() {
        System.out.println(name + "加入了游戏");
    }
}

class D {

    private int n1 = 5;
    public static int n2 = 10;

    public void say() {
        System.out.println("说话");
    }

    public static void hi() {
        System.out.println("你好");
    }

    public static void hello() {
        System.out.println(n2);
        System.out.println(D.n2);
        hi();
        D.hi();
    }

    public void ok() {
        System.out.println("静态成员 " + n2 + "非静态成员" + n1);
        // 调用非静态方法
        say();
        //调用静态方法
        hi();
    }
}
