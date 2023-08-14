package basic.practise.generic_;

import java.util.ArrayList;

public class GenericMethods {
    public static void main(String[] args) {
        Car car = new Car();
        // 当调用方法时，传入参数，编译器，会自动确定 泛型的类型

        // 泛型都是引用类型，这里虽然传入的是一个 int 的 100，但是会一个自动装箱 int -> Integer
        // 使用 泛型方法 与 使用 普通方法 没有什么区别，一旦传入参数，泛型方法中的 类型就会确定
        car.fly("BMW", 100);
        // class java.lang.String  class java.lang.Integer

        car.fly(100, 100.1);
        // class java.lang.Integer class java.lang.Double

        // ArrayList -> T, String -> R
        Fish<ArrayList, String> fish = new Fish<>();
        fish.hello("Fish", 100.0);
        // class java.lang.String class java.lang.Double
    }
}

// 普通类 和 泛型类中，都可以使用泛型方法
class Car {

    public void run() {

    }

    // <U, R> 就是泛型，<U, R>提供给 fly 方法使用
    public <U, R> void fly(U u, R r) {
        System.out.println(u.getClass());
        System.out.println(r.getClass());
    }

}

class Fish<T, R> {

    // 普通方法
    public void run() {

    }

    // 泛型方法，泛型方法中的 <U, M> 一般需要与 类的泛型 <T, R> 区分开来
    public <U, M> void eat(U u, M m) {

    }

    // 修饰符后没有泛型，比如 下方不是泛型方法，而是使用了 类声明的泛型
    public void swim(T e) {

    }

    // 泛型方法，可以使用类声明的泛型，也可以使用自己声明的泛型
    // K 泛型在 方法被使用 的时候指定
    public <K> void hello(R r, K k) {
        System.out.println(r.getClass());
        System.out.println(k.getClass());
    }
}