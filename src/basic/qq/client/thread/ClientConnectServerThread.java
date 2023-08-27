package basic.qq.client.thread;

import basic.qq.model.domain.Message;
import basic.qq.model.enums.MessageType;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * 维护客户端连接成功服务端后 返回的 socket 的线程
 */
public class ClientConnectServerThread extends Thread {
    /**
     * 该线程维护的 socket 对象
     */
    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    /**
     * 维护 socket 对象，保持与 服务端 的连接状态
     */
    @Override
    public void run() {
        // 因为 Thread 需要在后台和服务器通信，因为使用 while 循环
        while (true) {
            // 通过 socket 对象一直读取服务端返回的消息
            try {
                System.out.println("客户端线程，等待从服务端读取消息。");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 如果服务器没有发送 Message 对象，线程会阻塞在这里
                Message message = (Message) ois.readObject();
                // 新添加了 获取当前在线用户列表的 功能，所以在这里对 MessageType 进行判断
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    // 返回的 message 类别是  “由服务端返回的用户列表信息”
                    // 这里规定服务端返回的用户列表字符串形式为 "用户1 用户2 用户3"，中间由空格分割
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("\n=============当前在线用户列表=============");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("\t\t" + onlineUsers[i]);
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    // 普通聊天信息
                    // 客户端接收到 由 服务端 中转，然后转发的 message 对象
                    System.out.println("\n（" + message.getSendTime() + "）" + message.getSender() + " 对 " + message.getGetter() + " 说：" + message.getContent());
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    // 群发消息
                    // 客户端接收到群发消息类型，群转发的 message 对象
                    System.out.println("\n（" + message.getSendTime() + "）" + message.getSender() + " 对大家说：" + message.getContent());
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    // 接收到转发的文件消息
                    // 客户端接收到文件消息类型，进行下载，保存在指定的 dest 路径
                    // 将 byte 数组转存为本地文件
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(message.getDest()));
                    bufferedOutputStream.write(message.getFileBytes());
                    // 必须 close ，否则内容仍然在内存。
                    bufferedOutputStream.close();
                    System.out.println(message.getGetter() + " 接收到来自 " + message.getSender() + " 的文件: " + message.getSrc() + " 转存在 " + message.getDest());
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 为了方便获取该线程维护的 socket 对象
     *
     * @return
     */
    public Socket getSocket() {
        return socket;
    }
}
