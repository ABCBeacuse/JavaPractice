package basic.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        // 1. 服务端在本地监听 9999 端口，等待连接
        //    细节：要求在本机没有其他服务在监听 9999，如果有，会抛异常
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在 9999 端口进行监听");
        // 2. 在客户端连接成功之前，程序会在这里阻塞，等待连接。
        //    如果有客户端连接成功，则会返回一个 Socket 对象，程序继续。
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket = " + socket.getClass());

        // 3. 通过 socket.getInputStream() 获取与该 socket 相关的输入流，
        //    读取客户端写入数据通道的数据，并显示。（IO 读取）
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buf)) != -1) {
            // 根据读取到的实际长度，显示内容。
            System.out.println(new String(buf, 0, len));
        }

        // 关闭流
        inputStream.close();
        // 关闭 socket
        socket.close();
        // 关闭 ServerSocket
        serverSocket.close();
    }
}
