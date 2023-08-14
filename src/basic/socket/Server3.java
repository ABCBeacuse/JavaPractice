package basic.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {
    public static void main(String[] args) throws IOException {
        // 1. 服务端在本地监听 9999 端口，等待连接
        //    细节：要求在本机没有其他服务在监听 9999，如果有，会抛异常
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在 9999 进行监听");

        // 2. 当没有客户端连接 9999 端口时，程序会阻塞，等待连接
        //    如果有客户端连接，则会返回 Socket 对象，程序继续
        Socket socket = serverSocket.accept();

        // 3. 通过 socket.getInputStream() 拿到服务端 socket 对应的字节输入流
        //    因为是文本传输，所以使用 字符输入流 来读取比较方便，并且字符输入流由更多的 API 支持
        //    通过 转换流 将 字节输入流 转换为 字符输入流。
        InputStreamReader serverReader = new InputStreamReader(socket.getInputStream());
        char[] buf = new char[1024];
        int len = 0;
        while ((len = serverReader.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }

        // 4. 通过 socket.getOutputStream() 拿到服务端 socket 对应的字节输出流
        //    因为是文本传输，所以使用 字符输出流 来读取比较方便，并且字符输出流由更多的 API 支持
        //    通过 转换流 可以将 字节输出流 转换为 字符输出流。
        OutputStreamWriter serverWriter = new OutputStreamWriter(socket.getOutputStream());
        serverWriter.write("hello,client");
        // 因为使用的是 writer，所以需要手动 flush()，否则数据是无法写入到数据通道中的。
        serverWriter.flush();
        // 添加结束标记，表示 服务端的话 已说完，否则，客户端会一直阻塞等待服务端的下一句话。
        socket.shutdownOutput();

        // 关闭 socket 和 io
        serverWriter.close(); // 关闭外层流即可
        serverReader.close();
        socket.close();

        // 服务端需要额外关闭一个 ServerSocket
        serverSocket.close();
    }
}
