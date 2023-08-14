package basic.practise;

/**
 * 父类
 */
public class Base {

    public int n1 = 100;

    protected int n2 = 200;

    int n3 = 300;

    private int n4 = 400;

    public Base() {
    }

    // 自定义构造器，提供了自己定义的构造器后，默认的无参构造器会被覆盖。
    public Base(int n1, int n2) {
        System.out.println("int n1, int n2, 自定义构造器");
    }

    public int getN4() {
        return n4;
    }

    public void test100() {
        System.out.println("test100");
    }

    protected void test200() {
        System.out.println("test200");
    }

    void test300() {
        System.out.println("test300");
    }

    private void test400() {
        System.out.println("test400");
    }

    public void callTest400() {
        test400();
    }
}
