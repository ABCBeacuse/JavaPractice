package basic.practise.File_;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 打印输出流
 */
public class PrintStream_ {

    @Test
    void test() throws IOException {
        PrintStream out = System.out;
        // 默认情况下，PrintStream 输出数据的位置是 标准输出，即显示器。
        /**
         *     public void print(String s) {
         *         if (s == null) {
         *             s = "null";
         *         }
         *         write(s);
         *     }
         */
        out.print("啊？");
        // 因为 print 底层使用的是 write，所以我们可以直接调用 write 进行打印 / 输出。
        // write 方法中参数是 byte[] 字节数组，这是因为 PrintStream 本身就是 字节输出流，其父类是 OutputStream。
        // print 和 write 本质一样
        out.write("dsa".getBytes());

        // 我们可以去修改打印流输出的位置/设备
        // 1. 输出修改成到 "d:\\note.txt"
        // 2. "" 就会输出到 d:\note.txt
        System.setOut(new PrintStream("d:\\note.txt"));
        System.out.println("输出到 note.txt 文件中");
        out.close();
    }

    @Test
    void test2() throws IOException {
        // 传入是一个默认的输出，即显示屏。new PrintWriter() 中可以传递 OutputStream 类型的对象，
        // 而 System.out 是 PrintStream 类型，PrintStream 类型是 OutputStream 的实现子类。所以可以接收。
        // PrintWriter writer = new PrintWriter(System.out);

        PrintWriter writer = new PrintWriter(new FileWriter("d:\\note.txt", true));
        writer.print("输出到文件中");
        // 必须关闭，和之前的 Writer 一样，必须 close() 才会真正写，否则内容是在内存中。
        // close() 相当于 flush() + 关闭
        writer.close();
    }
}
