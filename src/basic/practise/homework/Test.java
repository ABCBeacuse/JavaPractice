package basic.practise.homework;

public class Test {
    public static void main(String[] args) {
        A.B b = new A("jack").new B();
        b.show();
    }
}

class A {
    private String name;

    public A(String name) {
        this.name = name;
    }

    class B {
        private final String name = "B的常量";

        public void show() {
            System.out.println("B 中的 name= " + name + " 外部类 A 的 name = " + A.this.name);
        }
    }
}
