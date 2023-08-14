package basic.practise.interface_;

public interface AInterface {

    // 可以有属性
    public int n1 = 10;
    // Modifier 'public' is redundant for interface members

    // 可以有方法，接口中的方法都是抽象方法，没有方法体，可以省略 abstract 关键字
    public void hi();
    // Modifier 'public' is redundant for interface members

    // jdk 8之后，可以有默认实现方法，需要使用 default 关键字修饰
    default public void ok() {
        System.out.println("ok...");
    }

    // jdk 8 之后，可以有静态方法
    public static void cry() {
        System.out.println("cry....");
    }
}
