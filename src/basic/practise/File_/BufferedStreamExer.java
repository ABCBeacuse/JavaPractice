package basic.practise.File_;

import org.junit.jupiter.api.Test;

import java.io.*;

public class BufferedStreamExer implements Serializable{

    @Test
    void test() throws IOException {

        // 创建 缓冲字节输入流 对象
        // FileInputStream 是 InputStream 子类，并且当前操作的数据源是 文件，所以使用 FileInputStream --- 操作文件的节点流
        // 之后数据源发生变化后，可以选择其他对应数据源的 节点流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d:\\640.jpg"));
        // 创建 缓冲字节输出流 对象
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("c:\\640.jpg"));

        // 循环读取，并写入到新文件
        byte[] b = new byte[1024];
        int len = 0;
        // 当返回 -1 时，表示文件读取完毕
        while ((len = bufferedInputStream.read(b)) != -1) {
            bufferedOutputStream.write(b, 0, len);
        }
        // 关闭流，释放资源（ 包装流 / 处理流只需要关闭外层流即可 ）
        // 追踪源码可以看到底层在关闭 FileInputStream 节点流
        bufferedInputStream.close();
        // 追踪源码可以看到底层在关闭 FileOutputStream 节点流
        bufferedOutputStream.close();
    }
}
