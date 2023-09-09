package basic.reflection.question;

import basic.reflection.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射的方式调用方法，耗时高。
 */
public class Reflection02 {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        m1();
        m2();
        m3();
    }

    public static void m1() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cat.hello();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方法耗时： " + (end - start));
    }

    public static void m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class classObject = Class.forName("basic.reflection.Cat");
        Object o = classObject.newInstance();
        Method methodObject = classObject.getMethod("hello");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            methodObject.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射方式耗时： " + (end - start));
    }

    public static void m3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class classObject = Class.forName("basic.reflection.Cat");
        Object o = classObject.newInstance();
        Method methodObject = classObject.getMethod("hello");
        // 在使用反射的方式调用方法时，取消访问检查。
        methodObject.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            methodObject.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射方式耗时（取消访问检查）： " + (end - start));
    }
}
