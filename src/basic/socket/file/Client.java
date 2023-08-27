package basic.socket.file;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // 客户端连接本地的 9999 端口，连接成功后返回一个 socket 对象。
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        // 向服务端传输图片，因为图片是二进制文件，所以只能使用 字节输出流。
        // 使用字节输出流之前，需要先使用本地的字节输入流，将图片读取到内存。
        BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream("d:\\学习视频\\鱼皮接口-开放api平台（1）.m4v"));
        // 一边将图片往内存中读取，一遍将读取到的图片信息写入数据通道，需要使用 该socket 对应的字节输出流
        BufferedOutputStream clientOutputStream = new BufferedOutputStream(socket.getOutputStream());
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(buf)) != -1) {
            // client 的 socket 对应的 字节输出流 同步往数据通道中去写。
            // 此时，因为没有 flush() 操作，数据并没有真正存到 数据通道 中去。
            clientOutputStream.write(buf, 0, len);
        }
        // 写完毕后，需要 flush() 刷新，真正写入到数据通道中。
        clientOutputStream.flush();
        // 需要添加结束符，否则服务端一直在等待
        socket.shutdownOutput();
        System.out.println("客户端已向服务端发送文件");

        // 等待服务端发送回来的消息，服务端发送回来的消息为文本，所以客户端优先使用 字符输入流 读取。
        BufferedReader clientReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // readLine() 可以接收到 newLine() 标识的结束标志
        String s = clientReader.readLine();
        System.out.println("客户端收到消息 " + s);

        // 关闭 socket 和 io 流
        clientReader.close();
        clientOutputStream.close();
        fileInputStream.close();
        socket.close();
        System.out.println("客户端关闭");
    }
}
