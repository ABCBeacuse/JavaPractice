package basic.practise.innerclass;

public class AnonymousClassDetail {
    public static void main(String[] args) {
        Base base = new Base();
        base.m1();
        System.out.println("base对象的hashcode= " + base);
    }
}

class Base {
    private int m1 = 10;

    public Base() {

    }

    public Base(int m1) {
        this.m1 = m1;
    }

    {

    }

    public void m1() {

        // 第一种调用匿名内部类的方法的方式
        A a = new A("jack") {

            private int m1 = 100;

            @Override
            public void test() {
                System.out.println("m1= " + m1 + " this.m1 = " + this.m1 + " 外部类的 m1 =" + Base.this.m1);
                System.out.println("Base.this 的 hashicode= " + Base.this); // 与对象 base 的 hashcode 相同，说明是同一个对象
                System.out.println("匿名内部类 A 中 this 的 hashcode= " + this); // 与对象 a 的 hashcode 相同，说明是同一个对象
            }
        };
        a.test();
        System.out.println("a的hashcode " + a);
    }
}

class A {
    private String name;

    public A(String name) {
        this.name = name;
    }

    public void test() {

    }

    public String getName() {
        return name;
    }
}
