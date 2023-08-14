package basic.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // 1. 连接服务端（ip，端口）, 客户端连接本机的 9999 端口，如果连接成功，返回 Socket 对象。
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket 返回 " + socket.getClass());
        // 2. 连接上后，生成 socket，通过 socket.getOutputStream()
        // 得到和 该 socket 关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        // 3. 通过输出流，写入数据到数据通道。
        outputStream.write("hello,server".getBytes());
        // 4. 关闭流对象
        outputStream.close();
        // 5. 关闭 socket 对象
        socket.close();
        System.out.println("客户端退出");
    }
}
