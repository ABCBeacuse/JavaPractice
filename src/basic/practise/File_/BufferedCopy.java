package basic.practise.File_;

import org.junit.jupiter.api.Test;

import java.io.*;

public class BufferedCopy {

    @Test
    void test() throws IOException {

        // 创建基于 FileReader 的 BufferedReader 对象
        BufferedReader reader = new BufferedReader(new FileReader("d:\\note.txt"));

        // 创建基于 FileWriter 的 BufferedWriter 对象
        BufferedWriter writer = new BufferedWriter(new FileWriter("c:\\note_copy.txt"));

        // 边读边写
        String data = "";
        /**
         * A String containing the contents of the line,
         * not including any line-termination characters,
         * or null if the end of the stream has been reached
         */
        while ((data = reader.readLine()) != null) {
            writer.write(data);
            // 添加一个与系统相关的换行符
            writer.newLine();
        }

        // 读完写完，释放资源，关闭外层流即可，
        // 外层流底层会去调用 传入的 Reader/Writer （目前是字节流）的 close() 方法
        reader.close();
        writer.close();
    }
}
