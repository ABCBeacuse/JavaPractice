package basic.practise.arraylist;

public class LinkedListSimulate {
    public static void main(String[] args) {
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node hsp = new Node("hsp");

        Node first = jack;
        Node last = hsp;

        jack.next = tom;
        tom.next = hsp;
        tom.pre = jack;
        hsp.pre = tom;

        // 从头遍历
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }

        System.out.println("========");

        // 从尾遍历
        while (true) {
            if (last == null) {
                break;
            }
            System.out.println(last);
            last = last.pre;
        }

        // 添加，插入中间链表，放到 tom 后面
        Node smith = new Node("smith");
        smith.next = tom.next;
        tom.next.pre = smith;
        tom.next = smith;
        smith.pre = tom;

        System.out.println("========");
        last = hsp;
        // 从尾遍历
        while (true) {
            if (last == null) {
                break;
            }
            System.out.println(last);
            last = last.pre;
        }

        System.out.println("========");
        first = jack;
        // 从头遍历
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }
    }
}

class Node {
    Object item;
    Node pre;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}
