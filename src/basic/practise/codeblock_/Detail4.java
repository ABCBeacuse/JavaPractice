package basic.practise.codeblock_;

public class Detail4 {
    public static void main(String[] args) {
        new B02();  // (1) getVal01 (2) A02 的一个静态代码块... (3) getVal03 (4) B02 的一个静态代码块... (5) A02 的第一个普通代码块 (6) getVal02 (7) A02的构造器
                    // (8) getVal04 (9) B02 的第一个普通代码块... (10) B02的构造器
    }
}

class A02 {
    private static int h1 = getVal01();

    static {
        System.out.println("A02 的一个静态代码块...");
    }

    {
        System.out.println("A02 的第一个普通代码块");
    }

    public int n3 = getVal02();

    private static int getVal01() {
        System.out.println("getVal01");
        return 10;
    }

    private int getVal02() {
        System.out.println("getVal02");
        return 10;
    }

    public A02() {
        System.out.println("A02的构造器");
    }
}

class B02 extends A02 {

    private static int n3 = getVal03();

    static {
        System.out.println("B02 的一个静态代码块...");
    }

    public int n5 = getVal04();

    {
        System.out.println("B02 的第一个普通代码块...");
    }

    private static int getVal03() {
        System.out.println("getVal03");
        return 10;
    }

    private int getVal04() {
        System.out.println("getVal04");
        return 10;
    }

    public B02() {
        System.out.println("B02的构造器");
    }
}