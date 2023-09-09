package basic.reflection.question;

import basic.reflection.Cat;

import java.lang.reflect.Field;

/**
 * Class 类的一些常用方法
 */
public class ClassTest2 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 获取 Cat 类对应的 Class 对象
        // <?> 表示不确定的 Java 类型，即 指这是一个 Class 对象，但是这个是哪个类的 Class 对象，不确定
        Class<?> cls = Class.forName("basic.reflection.Cat");
        // 2. 输出 cls
        System.out.println(cls); // 会输出这个 Class 对象是哪个类的 Class 对象。 class basic.reflection.Cat
        System.out.println(cls.getClass());  // 因为 Class 对象也是一个类的实例对象，所以 getClass() 可以获取其运行类型，即 class java.lang.Class
        // 3. 获得包名
        System.out.println(cls.getPackage().getName()); // basic.reflection
        // 4. 得到全类名
        System.out.println(cls.getName()); // basic.reflection.Cat
        // 5. 通过 cls 创建对象实例
        Cat o = (Cat) cls.newInstance();  // 因为这里创建的实例实际上是 Cat 类型，所以可以直接强转。
        System.out.println(o); // 实际上调用 Cat 类中的 toString() 方法
        // 6. 通过反射获取属性 age
        Field ageField = cls.getField("age");
        System.out.println(ageField.get(o)); // 10
        // 7. 通过反射给属性赋值
        ageField.set(o, 12);
        System.out.println(ageField.get(o)); // 12
        // 8. 希望可以获得所有的属性（字段）
        Field[] fields = cls.getFields();
        for(Field field : fields) {
            System.out.println(field.getName());
        }
    }
}
