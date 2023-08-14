package basic.practise.static_;

public class Main {
    public static void main(String[] args) {
        Child child = new Child("张三");
        child.join();
        child.count ++;

        Child child1 = new Child("李四");
        child1.join();
        child1.count ++;

        // 类变量可以通过类名来直接访问
        System.out.println("共有 " + Child.count + " 人加入了游戏");
        // 类变量被所有类的实例对象共享
        System.out.println("child.count=" + child.count);
        System.out.println("child1.count=" + child1.count);

    }
}
