package basic.practise.innerclass;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04(100);
        outer04.m1();
    }
}

class Outer04 {
    // 属性
    private int n1 = 100;

    // 构造器
    public Outer04(int n1) {
        this.n1 = n1;
    }

    // 方法
    public void m1() {
        // 基于接口的匿名内部类
        // 1. 需求：想使用 IA 接口，并创建对象
        // 2. 传统方式，是写一个类，实现该接口，并创建对象
        // 3. 新需求，Tiger / Dog 类只是使用一次，后面不再使用
        // 4. 可以使用匿名内部类来简化开发 ( 基于接口创建一个新的类，这个类只使用一次，以后就不想用了 ) ，传统写法创建新的类文件，比较啰嗦
        // 5. tiger 的编译类型？ IA
        // 6. tiger 的运行类型？ 就是匿名内部类 XXXX => Outer04$1 (外部类类名$1)
        /**
         * 底层会分配一个类名 Outer04$1
         * class Outer04$1 implements IA {
         *    @Override
         *    public void cry() {
         *      System.out.println("老虎叫唤...");
         *    }
         * }
         */
        // 7. jdk 底层在创建匿名内部类 Outer04$1，new -> 立即马上就创建了 Outer04$1 实例，并且把地址返回给 tiger
        // 8. 匿名内部类只能使用一次，就不能再使用。匿名内部类，使用一次再内存中就消失了。匿名的原因 -> 相对于程序员 类的名字是透明的
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("老虎叫唤...");
            }
        };
        // 9. 但是生成的这个 实例对象 可以多次使用
        tiger.cry();
        // getClass() 方法可以获取一个对象的运行类型
        System.out.println(tiger.getClass()); // class basic.practise.innerclass.Outer04$1

        // 基于类的匿名内部类
        // 1. father 的编译类型是 Father
        // 2. father 的运行类型是 Outer04$2
        // 3. 底层会创建匿名内部类
        /**
         * class Outer04$2 extends Father {
         *      @Override
         *      public void test() {
         *         System.out.println("基于类的匿名抽象类重写了 Father 类 test 方法");
         *      }
         * }
         */
        // 4. 同时也直接返回了 匿名内部类 Outer04$2 的实例对象
        // 5. ("jack") 参数列表 会传递给 类 Father 的 构造器
        Father father = new Father("jack") {
            // 如果这里面什么都没有写的话，那么底层生成的匿名内部类中也什么都没有
            @Override
            public void test() {
                System.out.println("基于类的匿名内部类重写了 Father 类 test 方法");
            }
        };
        System.out.println(father.getClass()); // class basic.practise.innerclass.Outer04$2
        father.test(); // 基于类的匿名抽象类重写了 Father 类 test 方法

        // 5. 基于抽象类的匿名内部类的实现，需要实现抽象类中所有的抽象方法
        Animal animal = new Animal() {
            @Override
            void eat() {
                System.out.println("小狗吃骨头");
            }
        };
        System.out.println(animal.getClass()); // class basic.practise.innerclass.Outer04$3
        animal.eat();
    }
}

interface IA {

    void cry();

}

class Father {
    private String name;

    public Father(String name) {
        this.name = name;
    }

    public void test() {

    }
}

abstract class Animal {
    abstract void eat();
}

