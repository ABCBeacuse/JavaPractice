package basic.practise.override_.poly;

public class A {
    public int sum(int n1, int n2) {
        return n1 + n2;
    }

    public int sum(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }

    public void say() {
        System.out.println("A 类方法的 say() 对象被调用...");
    }
}
