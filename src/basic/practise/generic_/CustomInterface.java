package basic.practise.generic_;

public class CustomInterface {
    public static void main(String[] args) {

    }
}

class C_<T, U> implements IUsb<T, U> {
    @Override
    public U get(T t) {
        return null;
    }

    @Override
    public void hi(U u) {

    }

    @Override
    public void run(U r1, U r2, T u1, T u2) {

    }
}

// 泛型如果不指定的话，默认为 Object
// class C implements IUsb 等价于 class C implements IUsb<Object, Object>
// 建议写成 class C implements IUsb<Object, Object> 可以没有警告 Raw use of parameterized class 'IUsb'
class C implements IUsb<Object, Object> {
    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public void hi(Object o) {

    }

    @Override
    public void run(Object r1, Object r2, Object u1, Object u2) {

    }
}

// 自定义接口泛型，在实现接口时指定
class c1 implements IUsb<String, Integer> {
    @Override
    public Integer get(String s) {
        return null;
    }

    @Override
    public void hi(Integer integer) {

    }

    @Override
    public void run(Integer r1, Integer r2, String u1, String u2) {

    }
}

// 在继承接口时 指定泛型接口的类型
interface MyInterface extends IUsb<String, Integer> {

}

// 当我们去实现 MyInterface 接口时，因为 MyInterface 在继承 IUsb 接口时，指定了 U 为 String，R 为 Integer
// 在实现 IUsb 接口的方法时，使用 String 替换 U，使用 Integer 替换 R
class D implements MyInterface {
    @Override
    public Integer get(String s) {
        return null;
    }

    @Override
    public void hi(Integer integer) {

    }

    @Override
    public void run(Integer r1, Integer r2, String u1, String u2) {

    }
}

interface IUsb<U, R> {

    // 接口中默认都是 public static
    // U age;  'basic.practise.generic_.IUsb.this' cannot be referenced from a static context

    // 普通方法中，可以使用接口泛型
    R get(U u);

    void hi(R r);

    void run(R r1, R r2, U u1, U u2);

    // jdk8 中, 可以在接口中，使用默认方法，默认方法中也可以使用泛型
    default R method(U u) {
        return null;
    }
}
