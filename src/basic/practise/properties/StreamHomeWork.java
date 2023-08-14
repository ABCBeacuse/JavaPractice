package basic.practise.properties;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

public class StreamHomeWork {

    @Test
    void test() throws IOException {
        File file = new File("d:\\mytemp");
        if (!(file.exists())) {
            // 文件夹不存在，再创建文件夹 mytemp
            // mkdir() 创建一级目录，mkdirs() 也可以创建单级目录
            if (file.mkdir()) {
                System.out.println("创建文件夹 " + file.getPath());
            } else {
                System.out.println("创建失败");
            }
        }
        // 文件夹 d:\\mytemp 已经存在，则创建文件
        file = new File("d:\\mytemp\\hello.txt");
        if (file.exists()) {
            System.out.println(file.getName() + "文件已存在");
        } else {
            // 也可以使用 file.createNewFile() 来创建文件
            BufferedWriter writer = new BufferedWriter(new FileWriter("d:\\mytemp\\hello.txt", true));
            writer.write("hello,world~");
            writer.close();
            System.out.println(file.getPath() + "创建成功");
        }
    }

    /**
     * 使用 BufferedReader 读取一个文本文件，为每行加上行号，再连同内容一并输出到屏幕上。
     */
    @Test
    void test2() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("d:\\note.txt"));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println("\"" + line + "\"");
        }
        reader.close();
    }

    /**
     * 使用 gbk 方式来读取 note.txt 文件，note.txt 为 ANSI 国标编码，即 gbk。
     * 如果使用 utf8 ，即默认读取方式，中文会产生乱码。
     *
     * @throws IOException
     */
    @Test
    void test3() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("d:\\hello.txt"), "gbk"));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    /**
     * 1. 要编写一个 dog.properties（存在 name、age、color 属性）
     * 2. 编写 Dog 类 (name，age，color)创建一个 dog 对象，读取 dog.properties 用相应的内容完成属性初始化，并输出。
     * 3. 将创建的 Dog 对象，序列化到文件 dog.dat 中
     *
     * @throws IOException
     */
    @Test
    void test4() throws IOException {
        Properties properties = new Properties();
        // 加载 dog.properties 中的 K-V 到 Properties 中
        properties.load(new FileReader("src\\dog.properties"));

        // 获取对应 key 对应的 value值
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        String color = properties.getProperty("color");

        // 创建 Dog 对象
        Dog dog = new Dog(name, age, color);
        // 序列化到文件 d:\dog.dat 中
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("d:\\dog.dat"));
        outputStream.writeObject(dog);

        // 关闭流
        outputStream.close();
    }

    /**
     * 从 d:\dog.dat 中 反序列化 读取出 dog
     */
    @Test
    void test5() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("d:\\dog.dat"));
        // 需要按照序列化的顺序 来进行 反序列化
        Object dog = inputStream.readObject();
        // 运行类型为 dog.class
        System.out.println(dog.getClass());
        System.out.println(dog);
        // 关闭流
        inputStream.close();
    }
}

class Dog implements Serializable{

    private static final long serialVersionUID = -2560924690313806315L;
    private String name;
    private String age;
    private String color;

    public Dog(String name, String age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
