package basic.reflection.question;

import basic.reflection.Cat;

/**
 * Class 类的一些使用方法介绍
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        // 传统方式创建对象，查看 Cat类 对应的 Class 对象是如何创建的。
        /**
         *     ClassLoader.java
         *
         *     public Class<?> loadClass(String name) throws ClassNotFoundException {
         *         return loadClass(name, false);
         *     }
         */
        Cat cat = new Cat();

        // 使用反射的方式创建 Cat 类的实例，查看其对应的 Class 对象是如何创建的。
        // 如果上方没有注释掉 Cat cat = new Cat();，会导致无法进入下方的 debug 的 loadClass 方法，因为类运行过程中只加载一次。
        /**
         *     ClassLoader.java
         *
         *     public Class<?> loadClass(String name) throws ClassNotFoundException {
         *         return loadClass(name, false);
         *     }
         */
        Class aClass = Class.forName("basic.reflection.Cat");
        Class bClass = Class.forName("basic.reflection.Cat");
        System.out.println(aClass.hashCode()); // 1554874502
        System.out.println(bClass.hashCode()); // 1554874502
    }
}
