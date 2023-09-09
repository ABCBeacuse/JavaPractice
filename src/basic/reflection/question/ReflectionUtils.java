package basic.reflection.question;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射获取类的结构信息
 */
public class ReflectionUtils {

    // 第一组方法 API
    @Test
    void test() throws ClassNotFoundException {
        // 得到 Class 对象
        Class<?> classObject = Class.forName("basic.reflection.question.Person_");
        // 获取全类名
        System.out.println(classObject.getName()); // basic.reflection.question.Person_
        // 获取简单类名
        System.out.println(classObject.getSimpleName()); // Person_
        // getFields：获取所有 public 修饰的属性，包含 本类以及父类（并不局限于直接父类）的
        Field[] fields = classObject.getFields();
        for (Field field : fields) {
            System.out.println("本类以及父类的属性：" + field.getName());
        }
        // getDeclaredFields：获取本类中所有属性
        Field[] declaredFields = classObject.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性：" + declaredField.getName());
        }
        // getMethods：获取所有 public 修饰的方法，包含本类以及父类（并不局限于直接父类）的
        Method[] methods = classObject.getMethods();
        for (Method method : methods) {
            System.out.println("本类以及父类的方法：" + method.getName());
        }
        // getDeclaredMethods：获取本类中所有方法
        Method[] declaredMethods = classObject.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法：" + declaredMethod.getName());
        }
        // getConstructors：获取所有 public 修饰的构造器，只能获取本类的
        Constructor<?>[] constructors = classObject.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类的构造器（不包含父类） = " + constructor.getName());
        }
        // getDeclaredConstructors：获取本类中所有构造器
        Constructor<?>[] declaredConstructors = classObject.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类中所有构造器 = " + declaredConstructor.getName());
        }
        // getPackage：以 Package 形式返回包信息
        System.out.println(classObject.getPackage().getName());
        // getSuperclass：以 Class 形式返回父类信息
        Class<?> superclass = classObject.getSuperclass();
        System.out.println(superclass);
        // getInterfaces：以 Class[] 形式返回接口信息
        Class<?>[] interfaces = classObject.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息 = " + anInterface);
        }
        // getAnnotations：以 Annotation[] 形式返回注解信息
        Annotation[] annotations = classObject.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息 = " + annotation);
        }
    }
}

class A {
    public String hobby;

    public A() {
    }

    public A(String hobby) {

    }

    public void hi() {

    }
}

interface IA {

}

interface IB {

}

@Deprecated
class Person extends A_ implements IA, IB_ {
    /**
     * 四种访问权限的属性
     */
    public String name;
    protected int age;
    String introduce;
    private float salary;

    public Person() {
    }

    public Person(String name) {

    }

    private Person(String name, int age) {

    }

    /**
     * 四种访问权限的方法
     */
    public void publicMethod() {

    }

    protected void protectedMethod() {

    }

    void defaultMethod() {

    }

    private void privateMethod() {

    }
}
