package basic.practise.poly;

public class PolyDetail {
    public static void main(String[] args) {

        // 向上转型：父类的引用指向了子类的对象
        // 父类类型 引用名 = new 子类类型();
        Animal animal = new Cat();
        // Object obj = new Cat();  // Object 也属于 Cat 的父类。这里的父类指的并不是仅仅一层。

        // 可以调用父类中的所有成员（需要遵守访问权限，比如 父类中 private 修饰的属性和方法就没法直接调用）

        // 但是不能调用子类的特有的成员，因为写代码时在编译阶段，能不能调用，完全是由你的编译器javac决定的，所以要看编译类型。
        // 而你的 animal 的编译类型就是 Animal，完全不知道 catchMouse 这个方法。
        // animal.catchMouse(); 错误

        // 运行阶段查看运行类型，因为运行阶段是交给Java虚拟机的。
        // 运行类型是 Cat。所以优先从 Cat 中找有没有 eat 方法。
        // 最终运行效果看子类（运行类型） Cat 的具体实现，即调用方法时，按照从子类（运行类型）开始查找方法，然后调用，规则与前面讲的方法调用规则一致。
        // 运行类型可以变化，所以当运行类型发生变化之后，代码不变的情况下，执行效果也会发生变化。

        animal.eat(); // 猫吃鱼
        // 下面这些方法也会先从运行类型 Cat 中去查找，但是没找到的话，就会沿着父级进行查找，直到找到一个可访问的方法。
        // 如果查找过程中找到该方法了，但是不能访问 比如是 父类的 private 类型，就会报错。当查找完毕后，没有找到该方法也一样会报错。
        animal.run(); // 跑
        animal.show(); // 你好！Animal
        animal.sleep(); //睡觉

        // cat 的编译类型是 Cat，运行类型也是 Cat。
        // 要求父类的引用必须指向的是当前目标类型的对象。( 本身指向的就是准备转换的子类类型的对象 )
        // animal 本身是 Animal 类的对象引用，指向的是 Cat 类型的对象。
        // 编译类型是 Cat，而 Cat 类中存在 catchMouse 方法。
        Cat cat = (Cat) animal;
        cat.catchMouse();

//        Dog dog = (Dog) animal;
    }
}
