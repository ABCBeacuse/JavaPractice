package basic.reflection.question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * java.lang.reflect 包使用介绍
 */
public class Reflection01 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        // 从 re.properties 配置文件中读取类信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\basic\\reflection\\re.properties"));
        // 获取配置文件中的类路径
        String classfullpath = properties.get("classfullpath").toString();
        // 获取配置文件中的方法名称
        String methodName = properties.get("method").toString();

        // 利用 反射机制 通过类路径 获得 Class 对象
        Class classObject = Class.forName(classfullpath);
        // 根据 Class 对象获取实例对象
        Object o = classObject.newInstance();
        // 根据获取的 Class 对象来获取类的 Field、Method、Constructor 对象
        Method methodObject = classObject.getMethod(methodName);
        // 调用 Method 方法对象
        methodObject.invoke(o); // 传统调用： 对象.方法(); 反射调用： Method 对象.invoke(实例对象)

        // java.lang.reflect.Field：代表类的成员变量，Field 对象表示某个类的成员变量
        // 取得 name 字段
        // getField 不能得到私有的属性（私有属性可以通过其他方法获得）
        Field ageField = classObject.getField("age");
        System.out.println(ageField.get(o)); // 传统方法：对象.成员变量，反射方式：成员变量对象Field.get(实例对象)

        // java.lang.reflect.constructor：代表类的构造方法，Constructor 表示构造器对象
        // getConstructor( ...参数类型.class )，不传参数 => 获取无参构造器
        Constructor constructor = classObject.getConstructor();
        System.out.println(constructor);
        // 获取只有一个参数 String 的构造器
        Constructor constructor1 = classObject.getConstructor(String.class);
        System.out.println(constructor1);
    }
}
