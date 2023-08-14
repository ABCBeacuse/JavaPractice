package basic.practise.arraylist;

import java.util.LinkedList;

public class LinkedListSource {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);

        list.set(0, "jack");
        list.get(2);
        list.getFirst();
        System.out.println(list);
    }
}
