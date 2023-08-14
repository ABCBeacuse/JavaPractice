package basic.practise.generic_;

import java.util.ArrayList;

public class Generic01 {
    public static void main(String[] args) {
        ArrayList<Dog> list = new ArrayList<Dog>();
        list.add(new Dog("旺财", 10));
        list.add(new Dog("发财", 1));
        list.add(new Dog("小黄", 5));

        // 如果程序员不小心加入了 一只猫 进入 list，编译器会报错。
        // list.add(new Cat("小猫咪", 3));

        // 来遍历输出 ArrayList 中的对象，不再需要进行向下转型，可以直接放入 Dog 类型
        for (Dog dog : list) {
            System.out.println(dog.getName() + "-" + dog.getAge());
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}