package basic.practise.generic_;

public class CustomGeneric {
    public static void main(String[] args) {

    }
}

/**
 * 1. Rabbit 后面泛型，所以我们把 Rabbit 就称为自定义泛型类
 * 2. T, R, M 泛型的标识符，一般是 大写字母
 * 3. 泛型的标识符可以有多个
 * 4. 普通成员可以使用泛型（属性，方法）
 * 5. 使用泛型的数组，不能够初始化。因为不知道需要开辟多大的空间
 * 6. 静态方法中不可以使用泛型
 */
class Rabbit<T, R, M> {
    String name;
    T t;    // 属性使用到泛型
    R r;
    M m;
    // T[] ts = new T[8];  Type parameter T cannot be instantiated directly，因为数组在 new 的时候无法确定 T 的类型，就无法在内存开辟空间

    public Rabbit(String name, T t, R r, M m) { // 构造器使用泛型
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
    }

    // 因为静态是和类相关的，在类加载时，对象还没有创建
    // 所以，如果静态方法和静态属性使用了泛型，JVM 在类加载期间无法确定 T,R,M 的类型，JVM 就无法完成类的初始化
    // static R r2; // 'basic.practise.generic_.Rabbit.this' cannot be referenced from a static context
    // public static void m1(M m){ // 'basic.practise.generic_.Rabbit.this' cannot be referenced from a static context

    // }
    // 方法使用泛型
    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }
}