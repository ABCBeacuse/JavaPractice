package basic.socket.file;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        // 监听本机 9999 端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端等待传输文件");
        // 在本机未被客户端连接时，程序会阻塞在这里，等待连接。
        // 连接成功后，会返回一个 Socket
        Socket socket = serverSocket.accept();

        // 因为要接收客户端传递的文件（图片），所以这里使用字节输入流。
        BufferedInputStream serverInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] buf = new byte[1024];
        int len = 0;
        // 需要往本地项目中写二进制文件，所以需要使用 字节输出流（这里使用效率更高的 BufferedOutputStream 包装类来写）
        BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream("src\\鱼皮接口-开放api平台（1）.m4v"));
        // 边读边写(此时只是写道了内存，因为没有使用 close())
        while ((len = serverInputStream.read(buf)) != -1) {
            fileOutputStream.write(buf, 0, len);
        }
        // 读写完毕后，需要 close() 关闭写本地的输出流，
        // 并且只有 close() 后，才会真正写到本地文件中
        fileOutputStream.close();
        System.out.println("服务端已接收到文件");

        // 存储图片完毕后，需要向客户端发送一个“收到图片”的消息，
        // 因为这个“收到图片”的消息是由文本组成的，所以优先使用 字符输出流，往数据通道上写。
        BufferedWriter serverWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        serverWriter.write("收到图片");
        // 这里可以使用 newLine() 方法来替换掉 socket.shutdownOutput();
        // 注意：newLine() 方法要求客户端必须使用 readLine() 方法来读取，否则起不到 结束标志 的作用。
        // 注意 writer 的 flush() 或者 close()，才能真正的写入。
        serverWriter.newLine();

        // 关闭 socket 和 io 流（一般后创建的流，先关闭）
        serverWriter.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端关闭");
    }
}
