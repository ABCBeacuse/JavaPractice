package basic.reflection.question;

import basic.reflection.Cat;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 尝试实现反射控制
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException {
        // 根据 properties 配置信息，创建 Cat 对象并调用方法 hi

        // 传统的方式 new 创建对象并调用
        Cat cat = new Cat();
        cat.hi();

        // 我们尝试做一做 -> 明白反射

        // 1. 使用 Properties 类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\basic\\reflection\\re.properties"));
        // 2. 拿到 Cat 类的全路径
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println(classfullpath + " " + methodName);

        // 没法使用提取出来的 classfullpath，因为 classfullpath 是一个字符串
        // new classfullpath() 不行，new 后面要跟一个类名。


        // 结论：传统 new 方式无法实现需求


        /**
         * 通过反射的方式实现
         */
        try {
            System.out.println("=====================================");
            // 根据 classfullpath 来创建一个 Class 对象
            Class anonymousClass = Class.forName(classfullpath);
            // 根据创建出来的 Class 对象，来实例化一个其对应的实例对象
            Object o = anonymousClass.newInstance();
            // 这里 o 的编译类型为 Obejct，查看 o 的运行类型
            System.out.println("o 的运行类型为 " + o.getClass());
            // 根据创建出来的 Class 对象，结合读取出来的 methodName，来创建一个 方法对象
            Method method = anonymousClass.getMethod(methodName);
            // 使用方法对象 method 来调用方法
            method.invoke(o);

            /**
             * 了解了对象 o 的运行类型为 Cat，也可以使用向下转型（强转）来调用 hi 方法
             */
            // Cat cat1 = (Cat) o;
            // cat1.hi();
            // 但是这样操作没有意义，因为如果配置文件中的内容发生了变化，源码也需要改变。
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
