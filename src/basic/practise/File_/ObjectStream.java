package basic.practise.File_;

import org.junit.jupiter.api.Test;

import java.io.*;

public class ObjectStream {

    /**
     * 使用 ObjectOutputStream 序列化 对象数据+对象类型 到 .dat 文件
     *
     * @throws IOException
     */
    @Test
    void test() throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("d:\\des.dat"));

        /**
         * 向文件中写不同类型的数据
         * 即 数据的 序列化
         */
        outputStream.writeInt(100);  // 自动装箱 int -> Integer，Integer 实现了 Serializable 接口
        outputStream.writeBoolean(true);  // 自动装箱 boolean -> Boolean，Boolean 实现了 Serializable 接口
        outputStream.writeChar('a');  // 自动装箱 char -> Character，Character 实现了 Serializable 接口
        outputStream.writeDouble(7.5);  // 自动装箱 double -> Double，Double 实现了 Serializable 接口
        outputStream.writeUTF("韩顺平教育");  // 写字符串的方式，String 实现了 Serializable 接口

        // 保存一个自定义类的实体对象，自定义类需要实现 Serializable 接口
        outputStream.writeObject(new Dog("大黄", 12));

        // 关闭外层流，（）释放资源
        outputStream.close();
    }


    /**
     * 从 .dat 文件中 反序列化数据 到
     */
    @Test
    void Recover() throws IOException, ClassNotFoundException {
        // 也有可以传递文件路径的 FileInputStream 构造器
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:\\des.dat"));

        // 读取的顺序必须要和写入的顺序保持一致，否则会报异常
        int i = objectInputStream.readInt();
        System.out.println(i);

        boolean b = objectInputStream.readBoolean();
        System.out.println(b);

        char c = objectInputStream.readChar();
        System.out.println(c);

        double v = objectInputStream.readDouble();
        System.out.println(v);

        String s = objectInputStream.readUTF();
        System.out.println(s);

        // 读取的对象的编译类型为 Object，它的运行类型为这个对象具体对应的类型。
        Object dog = objectInputStream.readObject();
        System.out.println(dog.getClass());

        // 如果想使用 Dog 类中实现的方法，需要将 dog 进行向下转型。Object -> dog
        Dog dog2 = (Dog)dog;
        System.out.println(dog2.getAge());

        // 如果在写入后重新更改了 dog 对象对应的 Dog 类的代码，这样直接读就会出异常。
        System.out.println(dog);

        // 关闭流，释放资源，关闭外层流即可，因为实际上工作的是 节点流 FileInputStream
        objectInputStream.close();
    }
}

class Dog implements Serializable {

    private static final long serialVersionUID = -1884028751286707510L;
    private String name;
    private int age;

    private String master;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMaster() {
        return master;
    }
}
