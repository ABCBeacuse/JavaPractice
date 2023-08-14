package basic.practise.poly;

public class PolyDetail3 {
    public static void main(String[] args) {
        AA aa = new AA();
        System.out.println(aa instanceof AA);
        System.out.println(aa instanceof BB);
    }
}

class AA {}

class BB extends AA {}
