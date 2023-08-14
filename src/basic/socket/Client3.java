package basic.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client3 {
    public static void main(String[] args) throws IOException {
        // 思路
        // 1. 连接服务端（ip，端口）
        // 连接本机的 9999 端口，如果连接成功，返回 socket 对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket 返回 " + socket.getClass());

        // 2.通过 socket.getOutputStream() 获取 字节输出流，
        // 准备往数据通道写入数据，传送给 Server 端接收。
        // 使用转换流进行转换，将 字节输出流 -> 字符输出流
        // 因为是文本传输，因此使用 字符输出流，比较方便，字符输出流有更多的 API 支持。
        OutputStreamWriter clientWriter = new OutputStreamWriter(socket.getOutputStream());
        clientWriter.write("hello, server");
        // 使用 write 必须使用 flush() 刷新，否则数据不会写入数据通道。
        clientWriter.flush();
        // 写消息完毕后，需要添加一个结束标记。
        socket.shutdownOutput();
        // 存在另一种添加 结束标记 的写法，clientWriter.newLine();，此时要求对方也使用 readLine() 的方式来读，否则对方也读取不到这个结束符。

        // 3. （通过转换流把 字节输入流 转换为 字符输入流）
        //     使用字符输入流，从数据通道中读取 由服务端 传送来的数据，并显示
        InputStreamReader clientReader = new InputStreamReader(socket.getInputStream());
        char[] buf = new char[1024];
        int len = 0;
        while ((len = clientReader.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }

        //关闭 socket 和 io
        clientReader.close();  // 关闭转换后的 Reader 即可，实际上底层使用的还是 传入的字节输入流
        clientWriter.close();
        socket.close();
    }
}
