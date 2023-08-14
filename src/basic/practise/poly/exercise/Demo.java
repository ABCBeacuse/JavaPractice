package basic.practise.poly.exercise;

public class Demo extends Test{
    String name = "Jack";
    Demo() {
        super();
        System.out.println("Demo");
    }
    Demo(String s) {
        super(s);
    }
    public void test() {
        System.out.println(super.name);
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        new Demo().test();  // 匿名对象 顺序输出 Test、Demo、Rose、Jack
        new Demo("john").test();   // 匿名对象  顺序输出 john Jack

        /**
         * 需要注意 Demo(String s) { super(s); }， -> Test(String name) {this.name = name;} 中 属性没有动态绑定机制，所以会把 Test 父类的 name 改为 john
         * 属性哪里定义，哪里声明的就在哪里使用。（可以理解为 父类构造器 只会初始化 父类属性）
         *
         */
    }
}
