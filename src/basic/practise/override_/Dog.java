package basic.practise.override_;

public class Dog extends Animal {

    // 1. 因为 Dog 是 Animal 子类
    // 2. Dog 的 cry 方法和 Animal 的 cry 定义形式一样（名称、返回类型、参数）
    // 3. 这时我们就说 Dog 的 cry 方法，重写了 Animal 的 cry 方法
    public void cry() {
        System.out.println("小狗汪汪叫.....");
    }

    // 子类方法的返回类型和父类方法返回类型一样，或者是父类返回类型的子类。
    public String m1() {
        return null;
    }

    public void eat() {

    }
}
