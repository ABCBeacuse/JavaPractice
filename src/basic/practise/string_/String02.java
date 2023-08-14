package basic.practise.string_;

public class String02 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "jack";
        Person p2 = new Person();
        p2.name = "jack";

        System.out.println(p1.name == p2.name); // true
        System.out.println(p1.name.equals(p2.name)); // true
        System.out.println(p1.name == "jack"); // true ("jack" 是一个常量，它就是常量池中的 "jack", 即就是常量池中的地址)

        String s1 = new String("bcde");
        String s2 = new String("bcde");
        System.out.println(s1 == s2); // false
    }
}

class Person {
    public String name;
}
