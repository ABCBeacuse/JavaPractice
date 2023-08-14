package basic.practise.interface_;


public class InterfacePolyParameter {
    public static void main(String[] args) {

        // 接口的多态实现
        // 接口类型的变量 f1 可以指向 实现了 F1 接口的类的对象实例
        F1 f1 = new Monster();
        f1 = new Car();

        // 继承体现的多态
        // 向上转型，父类类型的变量 a 可以指向继承 AAA 的子类的对象实例
        AAA a = new BBB();
        a = new CCC();
    }
}

interface F1 {

}

class Monster implements F1 {

}

class Car implements F1 {

}

class AAA {

}

class BBB extends AAA {

}

class CCC extends AAA {

}

