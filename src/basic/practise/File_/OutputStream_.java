package basic.practise.File_;

import org.junit.jupiter.api.Test;

import java.io.*;

public class OutputStream_ {

    @Test
    void test() {
        File file = new File("d:\\hello.txt");
        FileOutputStream outputStream = null;
        try {
            // append - 如果 true ，则字节将被写入文件的末尾而不是开头
            outputStream = new FileOutputStream(file, true);
            // 写一个字节( char 可以自动转换为 int )
            outputStream.write('a');
            // 写入多个字节（写入一个字符串） .getBytes() 可以把字符串转换成一个 byte[]，并且可以指定字符串编码。
            outputStream.write("hello,world".getBytes());
            /**
             * 可以限制从 byte[] 中哪个位置开始写入，然后写入多少个
             * write(byte[] b, int off, int len)
             * 将 len字节从位于偏移量 off的 指定字节数组 写入此文件输出流。
             */
            outputStream.write("abcdefg".getBytes(), 2, 3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
