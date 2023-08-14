package basic.practise.set_;

import java.util.HashMap;
import java.util.Properties;

public class MapSource_ {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        for (int i = 1; i <= 12; i++) {
            map.put(new A(i), i);
        }
    }
}

class A {
    private int num;

    public A(int num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        return 200;
    }
}
