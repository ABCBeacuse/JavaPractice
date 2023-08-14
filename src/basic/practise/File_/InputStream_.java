package basic.practise.File_;

import basic.practise.super_.B;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InputStream_ {

    @Test
    void readTxtByte() {
        File file = new File("D:\\new2.txt");
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            int read = 0;
            while ((read = inputStream.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // 关闭文件流，释放资源
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 一次读取多个 byte （字节），通过字节数组的方式
    @Test
    void readTxtByByteArray() {
        File file = new File("D:\\new2.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            // 创建一个 8 字节大小的数组，用来一次性从输入流中读取 8 个字节的数据。
            byte[] b = new byte[8];
            // 一次从 输入流中 读取的字节的长度
            int readLen = 0;
            // 从该输入流读取最多b.length字节的数据到字节数组，如果没有将 字节缓冲区 读满，返回的 int 值比 b.length 小。
            // 第一次读取的 readLen 为 8，第二次没有读满 readLen 为 3，byte[] 中有一部分值是第一次读取的值。第三次 读取完毕，返回 -1.
            // 但 使用 new String() 创建字符串时，使用了 readLen 参数进行了限制。所以不需要在意后面的垃圾数据。
            while ((readLen = fileInputStream.read(b)) != -1) {
                /**
                 * Params:
                 * bytes – The bytes to be decoded into characters
                 * offset – The index of the first byte to decode
                 * length – The number of bytes to decode
                 */
                System.out.println(new String(b, 0, readLen));
            }
        }catch (IOException e) {

        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
