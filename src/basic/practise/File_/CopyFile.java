package basic.practise.File_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

    /**
     * 文件拷贝
     */
    @Test
    void copy() {
        // 来源
        String origin = "d:\\640.jpg";
        // 目标位置
        String destination = "c:\\640.jpg";
        FileInputStream originInputStream = null;
        FileOutputStream destOutStream = null;
        try {
            // 输入流（将）文件中的字节信息读取到 程序内存
            originInputStream = new FileInputStream(origin);
            // 输出流（将）程序内存中的字节信息写入到 文件
            destOutStream = new FileOutputStream(destination);

            // 创建字节数组，一次读取 1kb
            byte[] b = new byte[1024];
            int readLen = 0;
            while ((readLen = originInputStream.read(b)) != -1) {
                // 将读取到的信息，从内存中写入到文件(注意需要使用 readLen，防止读取到脏数据的情况，因为 1024 不一定每次都被读满，会留下之前的读取信息)
                // 一边读，一边写
                destOutStream.write(b, 0, readLen);
            }
            System.out.println("拷贝完毕");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭输入流和输出流，释放资源
            try {
                if (originInputStream != null) {
                    originInputStream.close();
                }
                if (destOutStream != null) {
                    destOutStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
