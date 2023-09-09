package basic.reflection.question;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试 Field 类对象的 api
 */
public class ReflectionUtils02 {
    //
    @Test
    void test() throws ClassNotFoundException, NoSuchFieldException {
        Class<?> cls = Class.forName("basic.reflection.question.Person_");
        Field salaryField = cls.getDeclaredField("salary");
        // getModifiers：以 int 形式返回修饰符
        // 说明：默认修饰符为 0，public 是 1，private 是 2，protected 是 4，static 是 8，final 是 16.
        // 如果一个属性是 public static 则返回 public(1) + static(8) = 9
        System.out.println(salaryField.getModifiers()); // 2
        Field ageField = cls.getDeclaredField("age");
        System.out.println(ageField.getModifiers()); // 12 ( 4 + 8 )

        // getType：返回属性 类型对应的类的 Class 对象
        System.out.println(ageField.getType()); // int
        // getName：返回属性名称
        System.out.println(ageField.getName()); // age
    }

    @Test
    void test1() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> cls = Class.forName("basic.reflection.question.Person_");
        Method privateMethod = cls.getDeclaredMethod("privateMethod", String.class, int.class);
        // getModifiers：以 int 形式返回修饰符
        // 说明：默认修饰符为 0，public 是 1，private 是 2，protected 是 4，static 是 8，final 是 16.
        // 如果一个方法是 public static 则返回 public(1) + static(8) = 9
        System.out.println(privateMethod.getModifiers()); // 2
        // getReturnType：以 Class 形式获取返回类型
        System.out.println(privateMethod.getReturnType()); // void
        // getName：返回方法名
        System.out.println(privateMethod.getName()); // privateMethod
        // getParameterTypes：以 Class[] 形式返回参数类型数组
        Class<?>[] parameterTypes = privateMethod.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println(parameterType);
        }
        /*
            class java.lang.String
            int
        */
    }

    @Test
    void test2() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> cls = Class.forName("basic.reflection.question.Person_");
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            // getModifiers：以 int 形式返回修饰符
            // 说明：默认修饰符为 0，public 是 1，private 是 2，protected 是 4，static 是 8，final 是 16.
            // 如果一个方法是 public static 则返回 public(1) + static(8) = 9
            int modifiers = declaredConstructor.getModifiers();
            System.out.println(declaredConstructor + " 的修饰符" + modifiers);
            // getName：返回构造器名（全类名）
            // getParameterTypes：以 Class[] 返回参数类型数组
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType);
            }
        }
    }

    @Test
    void test3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        /**
         * 通过 public 无参构造器创造实例对象
         */
        // 1. 通过反射创建某类的对象，要求该类中必须有 public 的无参构造
        Class<?> classObject = Class.forName("basic.reflection.question.Person_");
        // 使用该 Class 类对象的无参构造器创建一个实例对象
        Person_ o = (Person_) classObject.newInstance();

        /**
         * 通过 public 有参构造器创建实例对象
         */
        // 2. 调用类对象中某个特定构造器的方式，实现创建某类的对象
        // 获得一个特定的构造器对象，该构造器对象存在一个 String 类型的参数
        Constructor<?> declaredConstructor = classObject.getDeclaredConstructor(String.class);
        // 调用构造器对象的 newInstance 方法创建实例对象，传入实参
        Person_ o1 = (Person_) declaredConstructor.newInstance("string 参数");
        System.out.println(o1);

        /**
         * 3. 获得一个私有的构造器对象（通过 非public 的有参构造器创建实例对象）
         */
        Constructor<?> privateConstructor = classObject.getDeclaredConstructor(String.class, int.class);
        // 暴破【暴力破解】，使用反射可以访问 private 构造器/方法/属性。在反射面前，什么都是纸老虎。
        privateConstructor.setAccessible(true);
        Person_ o2 = (Person_) privateConstructor.newInstance("私有构造器对象创建", 20);
        // 未执行 privateConstructor.setAccessible(true) 直接访问会报 private 权限问题：
        // can not access a member of class basic.reflection.question.Person_ with modifiers "private"
        // System.out.println(o2);
        System.out.println(o2);
    }

    @Test
    void test4() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        // 1. 先获得类的 Class 对象
        Class<?> classObject = Class.forName("basic.reflection.question.Person_");
        // 2. 使用该类的 无参构造器 创建一个实例对象
        Person_ o = (Person_) classObject.newInstance();
        // 3. 获取类的属性 public
        Field nameField = classObject.getField("name");
        nameField.set(o, "属性设置"); // 通过反射来操作属性
        System.out.println(nameField.get(o));

        /**
         * 4. 获取类的属性 除 public 外 ( getDeclaredField )
         */
        Field ageField = classObject.getDeclaredField("age");
        // 因为 age 属性是 protected static 静态属性，所以 o 可以使用 null 代替。
        // protected 属性不需要暴破
        ageField.set(null, 20);
        System.out.println(ageField.get(null));

        // introduce 属性是 默认
        // 默认 属性不需要暴破
        Field introduceField = classObject.getDeclaredField("introduce");
        introduceField.set(o, "介绍");
        System.out.println(introduceField.get(o));

        // salary 属性是 private
        Field salaryField = classObject.getDeclaredField("salary");
        // 暴破
        salaryField.setAccessible(true);
        // private 需要暴破，否则会报出下方错误
        // can not access a member of class basic.reflection.question.Person_ with modifiers "private"
        salaryField.set(o, 10000);
        System.out.println(salaryField.get(o));
    }

    @Test
    void test5() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 1. 获取 类的 Class 对象
        Class<?> classObject = Class.forName("basic.reflection.question.Person_");
        // 2. 根据 Class 对象的无参构造器创建实例对象
        Object o = classObject.newInstance();
        // 3. 获取 Method 对象（public）
        Method publicMethod = classObject.getDeclaredMethod("publicMethod");
        // 4. 调用 Method 对象
        publicMethod.invoke(o);

        // 3. 获取 Method 对象（private）
        Method privateMethod = classObject.getDeclaredMethod("privateMethod", String.class, int.class);
        // private 方法需要暴破（不暴破 会报错 can not access a member of class basic.reflection.question.Person_ with modifiers "private"）
        privateMethod.setAccessible(true);
        // 传递参数
        privateMethod.invoke(o, "hello", 10);

        // 3. 获取 Method 对象（static）
        Method staticMethod = classObject.getDeclaredMethod("staticMethod");
        // 调用方法对象（静态方法对象）
        // 静态方法对象可以 传递 o，也可也传递 null。因为静态方法通过实例对象也可以访问。
        // staticMethod.invoke(o);
        staticMethod.invoke(null);
    }
}


class A_ {
    public String hobby;

    public A_() {
    }

    public A_(String hobby) {

    }

    public void hi() {

    }
}

interface IA_ {

}

interface IB_ {

}

@Deprecated
class Person_ extends A_ implements IA_, IB_ {
    /**
     * 四种访问权限的属性
     */
    public String name;
    protected static int age;
    String introduce;
    private float salary;

    public Person_() {
    }

    public Person_(String name) {
        this.name = name;
    }

    private Person_(String name, int age) {
        this.name = name;
    }

    public static void staticMethod() {
        System.out.println("staticMethod");
    }

    /**
     * 四种访问权限的方法
     */
    public void publicMethod() {
        System.out.println("publicMethod");
    }

    protected void protectedMethod() {
        System.out.println("protectedMethod");
    }

    void defaultMethod() {
        System.out.println("defaultMethod");
    }

    private void privateMethod(String name, int age) {
        System.out.println("privateMethod");
    }

    @Override
    public String toString() {
        return "Person_{" +
                "name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", salary=" + salary +
                '}';
    }
}