package basic.practise.annotation;

public class deprecated {
    public static void main(String[] args) {
        A a = new A();

        System.out.println(a.n1);

        a.hi();
    }
}

@Deprecated
class A {

    @Deprecated
    public int n1 = 10;

    @Deprecated
    public void hi() {
        System.out.println("hi...");
    }
}

