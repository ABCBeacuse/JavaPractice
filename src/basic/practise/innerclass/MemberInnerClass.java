package basic.practise.innerclass;

public class MemberInnerClass {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.t1();

        // 外部其他类 使用 成员内部类
        // 第一种方式
        Outer08.Inner08 inner08 = outer08.new Inner08();
        inner08.say();

        // 第二种方式，在外部类中定义一个方法返回成员内部类的实例对象
        Outer08.Inner08 inner08Instance = outer08.getInner08Instance();
        inner08Instance.say();
    }
}

class Outer08 { // 外部类
    private int n1 = 10;
    public String name = "张三";

    // 注意： 成员内部类，定义在类成员的位置（即属性和方法的位置）
    // 可以添加任意访问修饰符（public、protected、默认、private），因为它的地位就是一个成员
    public class Inner08 {
        private double sal = 99.8;
        private int n1 = 66;
        public void say() {
            // 可以直接访问外部类的所有成员，包含私有的
            System.out.println("n1= " + n1 + " name= " + name + " 外部类 n1= " + Outer08.this.n1);
        }
    }

    // 成员内部类的使用方式
    public void t1() {
        // 在 Outer08 中可以直接创建 类 Inner08 的实例对象，因为毕竟是成员
        // 外部类通过创建内部成员类的实例对象，来访问 内部成员类的属性和方法
        Inner08 inner08 = new Inner08();
        inner08.say();
        // private 也可以访问，因为都是在同一个类
        System.out.println(inner08.sal);
    }

    public Inner08 getInner08Instance() {
        return new Inner08();
    }
}
