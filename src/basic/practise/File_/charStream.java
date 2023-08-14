package basic.practise.File_;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 文件字符流
 */
public class charStream {

    /**
     * 字符输入流（InputStreamReader）
     * <p>
     * read() 一次读取一个字符
     */
    @Test
    void test() {
        File file = new File("d:\\hello.txt");
        FileReader fileReader = null;
        try {
            // 创建一个 字符输入流
            fileReader = new FileReader(file);
            int data = 0;
            while ((data = fileReader.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * 字符输入流（InputStreamReader）
     * <p>
     * read() 一次读取多个字符
     */
    @Test
    void test2() {
        File file = new File("d:\\hello.txt");
        FileReader fileReader = null;
        try {
            // 创建一个 字符输入流
            fileReader = new FileReader(file);
            char[] c = new char[8];
            int readLen = 0;
            while ((readLen = fileReader.read(c)) != -1) {
                System.out.println(readLen);
                System.out.println(new String(c, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * 字符输出流
     */
    @Test
    void test3() {
        FileWriter writer = null;
        try {
            writer = new FileWriter("d:\\note.txt");

            /**
             * 接收 String，或者 char[] 数组时，可以指定额外的两个参数 offset 和 len
             */
            // 参数可以接收 String
            writer.write("风雨之后，定见彩虹");
            // 参数可以接收 char[]，String.toCharArray() 方法可以将 字符串转换为 字符数组
            writer.write("另一种方式".toCharArray());
            // char 字符可以自动转换为 int
            writer.write('女');
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭 或者 刷新 都可以，推荐优先使用 关闭 close()
            if (writer != null) {
                try {
                     writer.close();
                    // writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
