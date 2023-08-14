package basic.practise.arraylist;

import java.util.ArrayList;
import java.util.Vector;

public class ArrayListSource {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(8);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        list.add(100);
        list.add(200);
    }
}
