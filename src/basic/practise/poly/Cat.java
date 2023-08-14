package basic.practise.poly;

public class Cat extends Animal {

    // 父类方法的重写
    public void eat() {
        System.out.println("猫吃鱼");
    }

    // Cat 类特有的方法
    public void catchMouse() {
        System.out.println("猫抓老鼠");
    }

}
