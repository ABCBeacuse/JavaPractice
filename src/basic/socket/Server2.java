package basic.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) throws IOException {
        // 1. 服务端在本地监听 9999 端口，等待连接
        //    细节：要求在本机没有其他服务在监听 9999，如果有，会抛异常
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在 9999 端口监听，等待连接..");
        // 2. 当没有客户端连接 9999 端口时，程序会阻塞，等待连接
        //    如果有客户端连接，则会返回 Socket 对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket = " + socket.getClass());

        // 3. 通过 socket.getInputStream() 读取客户端写入到数据通道的数据，显示
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }

        // 4. 通过 socket.getOutputStream() 写入数据到数据通道，供客户端读取。
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());
        // 后面没有消息了，添加一个结束标记
        socket.shutdownOutput();

        // 5. 关闭 socket 和 io
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
