package basic.reflection.question;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射练习
 * <p>
 * 定义 PrivateTest 类，有私有 name 属性，并且属性值为 hellokitty
 * 提供 getName 的公有方法
 * 创建 PrivateTest 的类，利用 Class 类得到私有的 name 属性，修改私有的 name 属性值，并调用 getName() 方法打印 name 属性值
 */
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 获取 PrivateTest 的 Class 对象
        Class<?> cls = Class.forName("basic.reflection.question.PrivateTest");
        // 根据 Class 对象对应的类的无参构造器 创建 实例对象
        Object o = cls.newInstance();
        // 获取 私有属性 name 的 Field 对象
        Field nameField = cls.getDeclaredField("name");
        // 私有属性，需要暴破
        nameField.setAccessible(true);
        // 修改 o 对象的 私有属性 name 的值
        nameField.set(o, "修改私有属性");

        // 获取 getName 方法对应的 Method 对象
        Method getNameMethod = cls.getDeclaredMethod("getName");
        // 因为是 public ，所以不需要暴破
        // 调用方法
        Object returnValue = getNameMethod.invoke(o);
        // 返回的编译类型是 Object，实际的运行类型仍然是 方法实际的返回类型
        System.out.println(returnValue.getClass()); // class java.lang.String
        System.out.println(returnValue); // 修改私有属性
    }

    @Test
    void test() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        /**
         * 利用 Class 类的 forName 方法得到 File 类的 class 对象
         * 在控制台打印 File 类的所有构造器
         * 通过 newInstance 的方法创建 File 对象，并创建 d:\mynew.txt 文件
         */
        Class<?> classObject = Class.forName("java.io.File");
        // 获取 File 类的所有构造器
        Constructor<?>[] declaredConstructors = classObject.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        // 使用 newInstance 方法创建 File 对象
        // 因为需要传递参数，所以需要获取 只有一个形参 String 的 构造器对象
        Constructor<?> stringConstructor = classObject.getDeclaredConstructor(String.class);
        // 公有构造器，不需要暴破
        // 返回的编译类型是 Object ，实际的运行类型是 File
        Object o = stringConstructor.newInstance("d:\\mynew.txt");
        // 获取创建文件方法的 Method 对象
        Method methodObject = classObject.getDeclaredMethod("createNewFile");
        // 真正创建文件
        Object res = methodObject.invoke(o);
        System.out.println(res.getClass()); // class java.lang.boolean
        System.out.println(res);
    }
}

class PrivateTest {
    private String name = "hellokitty";

    // 存在默认无参构造器

    public String getName() {
        return name;
    }
}
