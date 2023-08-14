package basic.practise.final_;

public class Final01 {
    public static void main(String[] args) {

    }
}

class B {
    public int addOne(final int x) {
        // x++; // Cannot assign a value to final variable 'x'
        return x + 1;
    }
}
