package basic.practise.File_;

import org.junit.jupiter.api.Test;

import java.io.*;

public class BufferedExer {

    @Test
    void test() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("d:\\note.txt"));
            String data = "";
            /**
             *   A String containing the contents of the line, not including any line-termination characters,
             *   or null if the end of the stream has been reached
             */
            while ((data = reader.readLine()) != null) {
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    void test2() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:\\note.txt", true));
        bufferedWriter.write("hello，韩顺平教育");
        // 插入一个和系统相关的换行符
        bufferedWriter.newLine();
        bufferedWriter.write("hello，java工程师");
        bufferedWriter.close();
    }
}
