package basic.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws IOException {
        // 思路
        // 1. 连接服务端（ip，端口）
        // 连接本机的 9999 端口，如果连接成功，返回 socket 对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket 返回 = " + socket.getClass());

        // 2. 连接上后，生成 Socket，通过 socket.getOutputStream() 获得和 socket 对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        // 通过输出流，写入数据到数据通道。
        // 向服务端发送 "hello,server"
        outputStream.write("hello,server".getBytes());
        // 后面没有消息了，添加一个结束标记。
        // 如果没有添加，服务端不知道客户端的话有没有说完，会一致等待继续读取。
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();

        // 读取服务端发送来的 "hello,client"
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }

        // 关闭流
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
