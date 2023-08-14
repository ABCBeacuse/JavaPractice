package basic.practise.super_;

public class B extends A{

    private int n1 = 200;

    public B() {
        // super();
        // super(1);
        // super(1, 2);
    }

    // 访问父类的属性，但不能访问父类的 private 属性
    public void hi() {
        System.out.println(super.n1 + "" + super.n2 + "" + super.n3);
    }

    public void sum() {
        System.out.println("B类的 sum()");


        // 希望调用 父类--A 的 cal 方法
        // 这时，因为子类 B 没有 cal 方法，因此我可以使用下面三种方式 this.cal(); cal(); super.cal();

        // 找 cal 方法时，顺序是：
        // (1)先找本类，如果有，则调用
        // (2)如果没有，则找父类（如果有，并且可以访问(访问修饰符的限制)，则调用）
        // (3)如果父类没有，则继续找父类的父类，整个规则，就是一样的，直到 Object 类
        // (4)如果查找方法的过程中，没有找到，则提示方法不存在
        //    如果查找方法的过程中，找到了，但是不能访问，则报错
        cal();

        // 属性 的查找规则 与 方法 一致。
        // n1; this.n1; 都先看本类有没有，即从（1）走
        // super.n1; 直接去看父类有没有，即从（2）走
        System.out.println(n1);
    }

    // 访问父类的方法，不能访问父类的 private 方法，super.方法名(参数列表)
    public void ok() {
        super.test100();
        super.test200();
        super.test300();
    }
}
