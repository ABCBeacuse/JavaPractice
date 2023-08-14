package basic.practise.generic_;

import java.util.List;

public class Generic02 {
    public static void main(String[] args) {
        // Person 类中 E 的部分都用 String 表示了
        Person<String> person = new Person<String>("hsp");
        person.f2();
        // class java.lang.String

        Person<Integer> person1 = new Person<Integer>(100);
        person1.f2();
        // class java.lang.Integer
    }
}

// 可以在类声明时通过一个标识表示类中某个属性的类型
class Person<E> {
    E s;    // E 表示 s 的数据类型，该数据类型在定义 Person 对象的时候指定，即在编译期间，就确定 E 是什么类型

    public Person(E s) {    // E 也可以是 参数类型
        this.s = s;
    }

    public E f1() {     // E 也可以是 返回类型
        return s;
    }

    public void f2() {
        // 输出 s 的运行类型
        System.out.println(s.getClass());
    }
}
