package basic.practise.set_;

public class HashSetStructure {
    public static void main(String[] args) {
        Node[] table = new Node[16];
        Node john = new Node("john", null);
        table[2] = john;

        Node jack = new Node("jack", null);
        // 将 jack 这个结点挂载到 john 这个结点上。
        john.next = jack;
        Node rose = new Node("Rose", null);
        // 将 rose 这个结点挂载到 jack 这个结点上。
        jack.next = rose;

        System.out.println(table);
    }
}

class Node {
    private Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}
