package basic.practise.interface_;

public class Interface01 {
    public static void main(String[] args) {
        B b = new B();

        System.out.println(IA.a);
        System.out.println(B.a);
        System.out.println(b.a);
    }
}

interface IA {
    int a = 10;
}
class B implements IA {

}
