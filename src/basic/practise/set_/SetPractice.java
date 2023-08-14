package basic.practise.set_;

import java.util.HashSet;
import java.util.Set;

public class SetPractice {
    public static void main(String[] args) {
        // 这里使用向上转型
        Set set = new HashSet();

        // "lucy" 在方法区的常量池中，两个 "lucy" 地址一样，属于同一个对象
        set.add("lucy"); // true
        set.add("lucy"); // false

        // 添加的是两个不同的对象，所以都会添加成功
        set.add(new Dog("tom")); // true
        set.add(new Dog("tom")); // true

        // 非常经典的面试题，需要看源码，做分析，查看 add 究竟是怎么加入的。
        set.add(new String("hsp")); // true
        set.add(new String("hsp")); // false

        System.out.println(set);
    }
}

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}