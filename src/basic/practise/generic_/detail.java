package basic.practise.generic_;

import java.util.ArrayList;
import java.util.List;

public class detail {
    public static void main(String[] args) {
        // interface List<T> {}，public class HashSet<E> {} 等等
        // 1. T，E 只能是引用类型，不能是基本类型
        ArrayList<Integer> list = new ArrayList<>();
        // ArrayList<int> list1 = new ArrayList<int>(); // 报错

        // 2. 在泛型给定具体类型后，可以传入该类型或者其子类型
        Pig<A> pig = new Pig<>(new A());
        pig.f1();
        // class basic.practise.generic_.A
        Pig<A> pig1 = new Pig<>(new B());
        pig1.f1();
        // class basic.practise.generic_.B

        // 3. 泛型的使用形式
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        // 在实际开发中，我们往往简写
        // 编译器会进行类型推断，会推断后面的 <> 中填写的是前面 <> 中的内容
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Pig<A>> list4 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
    }
}

class A {
}

class B extends A {
}

class Pig<T> {
    T e;

    public Pig(T e) {
        this.e = e;
    }

    public void f1() {
        System.out.println(e.getClass());
    }
}
