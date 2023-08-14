package basic.practise.interface_;

public class InterfacePolyPass {
    public static void main(String[] args) {
        new C_().px();
    }
}

interface IH {
   int a = 0; // public static final int a = 0;
}

class B_ {
    int a = 1;
}

class C_ extends B implements IH {
    public void px() {
        // System.out.println(a); // Reference to 'a' is ambiguous, both 'IA.a' and 'IH.a' match
        // 可以明确的指定 a
        // 访问接口的 a 就使用 IH.a
        // 访问父类的 a 就使用 super.a
        System.out.println(IH.a + "" + super.a);
    }
}