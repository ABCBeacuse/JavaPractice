package basic.practise.File_;

import org.junit.jupiter.api.Test;

import java.io.*;

public class GarbledCode {

    @Test
    void test() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("d:\\note.txt"));

        // 读取一行数据
        String s = reader.readLine();
        System.out.println(s);

        // 关闭流，释放资源
        reader.close();
    }


    /**
     * 编程将 字节流 FileInputStream 包装成（转换成）字符流 InputStreamReader，对文件进行读取（默认为 utf-8），
     * 可以通过 InputStreamReader 的第二个参数设置文件编码
     * 进而再包装成 BufferedReader
     *
     * @throws IOException
     */
    @Test
    void test2() throws IOException {
        /**
         * 将 FileInputStream 字节输入流，通过 InputStreamReader 转换为 字符输入流，然后再包装成 BufferedReader。
         */

        // InputStreamReader 是 Reader 抽象父类 的实现子类
        InputStreamReader reader = new InputStreamReader(new FileInputStream("d:\\note.txt"), "gbk");

        // BufferedReader 是 包装流 / 处理流
        BufferedReader bufferedReader = new BufferedReader(reader);
        String s = bufferedReader.readLine();
        System.out.println(s);

        bufferedReader.close();
    }

    /**
     * 将字节输出流 FileOutputStream 包装成（转换成）字符输出流 OutputStreamWriter，
     * 对文件进行写入（按照 gbk 格式，可以指定其他编码方式，比如 utf-8）
     * <p>
     * 再进行包装，包装为 BufferedWriter，效率更高。
     *
     * @throws IOException
     */
    @Test
    void test3() throws IOException {
        // 创建流对象
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("d:\\note.txt", true), "gbk"));
        // 新创建一行
        writer.newLine();
        // 写入
        writer.write("gbk方式写入新的一行");
        // 关闭外层流即可
        writer.close();
    }
}
