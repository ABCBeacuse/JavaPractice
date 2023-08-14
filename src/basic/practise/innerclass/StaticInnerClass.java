package basic.practise.innerclass;

public class StaticInnerClass {
    public static void main(String[] args) {
        Outer10 outer10 = new Outer10();
        outer10.hi();

        // 外部其他类 访问 静态内部类
        // 方式一
        Outer10.Inner10 inner10 = new Outer10.Inner10();
        inner10.say();
        // 方式二 在 外部类 中写一个方法返回 静态内部类的实例对象
        Outer10.Inner10 inner10Instance = outer10.getInner10Instance();
        inner10Instance.say();

        // 方式二 因为是静态 static 类，所以可以创建一个外部类的静态方法 来返回 静态内部类的实例对象
        Outer10.Inner10 inner10Ins = Outer10.getInner10Ins();
        inner10Ins.say();
    }
}

class Outer10 { //外部类
    private int n1 = 10;
    private static String name = "张三";

    private static void cry(){}

    // Inner10 就是静态内部类
    // 1. 放在外部类的成员位置
    // 2. 使用 static 修饰
    // 3. 可以直接访问外部类的所有静态成员，包含私有的，但不能直接访问非静态成员
    // 4. 可以添加任意访问修饰符，因为它的地位就是一个成员
    // 5. 作用域：同其他的成员，为整个类体
    static class Inner10 {

        private static String name = "教育";

        public void say() {
            System.out.println(name + " 外部类 name= " + Outer10.name);
            cry();
        }
    }

    public void hi() {
        Inner10 inner10 = new Inner10();
        inner10.say();
    }

    public Inner10 getInner10Instance() {
        return new Inner10();
    }

    public static Inner10 getInner10Ins() {
        return new Inner10();
    }
}