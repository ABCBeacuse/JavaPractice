package basic.qq.server.thread;

import basic.qq.model.domain.Message;
import basic.qq.model.enums.MessageType;
import basic.qq.server.service.ManageOffLineMessage;
import basic.qq.server.service.ManageServerConnectClientThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 服务端 用来维护 socket 的线程类
 */
public class ServerConnectClientThread extends Thread {
    /**
     * 该线程维护的 socket 对应的 客户端 id
     */
    private String userId;

    /**
     * 该线程持有的 Socket 对象
     */
    private Socket socket;

    public ServerConnectClientThread(String userId, Socket socket) {
        this.userId = userId;
        this.socket = socket;
    }

    /**
     * 方法循环执行，目的是为了保持该 socket 对应的通道连通
     */
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("服务器端在与 " + userId + " 进行通信");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 不断读取该 socket 通道中的消息，（一定是 Message 对象）
                Message mes = (Message) ois.readObject();
                if (mes.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    System.out.println("用户 " + mes.getSender() + " 要求返回在线人员信息列表");
                    // 收到 socket 对应客户端消息，要求返回当前在线人员信息
                    String onlineUsers = ManageServerConnectClientThread.getOnlineFriends();
                    // 建立 Message 对象，用于包装 在线用户信息
                    Message message = new Message();
                    message.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message.setContent(onlineUsers);
                    // 写入数据通道，发送给对应的客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);
                } else if (mes.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    // 服务端中某个管理 socket 的线程收到了 客户端请求退出 的 message
                    // 从管理线程的集合中移除 该 id 对应的 socket 对象
                    ManageServerConnectClientThread.removeServerConnectClientThread(mes.getSender());
                    // 关闭 socket，释放资源
                    socket.close();
                    System.out.println(mes.getSender() + " 客户端已退出");
                    // 退出 while 循环，使该 socket 对应的子线程结束
                    break;
                } else if (mes.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    // 服务端接收到某个客户端发来的普通消息，需要转发给 message 中对应的 getter 接收人
                    // 先根据 message 中的 getter （客户端 id）获取到对应的线程
                    ServerConnectClientThread thread = ManageServerConnectClientThread.getServerConnectClientThread(mes.getGetter());
                    // 如果用户客户端不在线，则无法获得与用户客户端相关的 thread
                    if (thread == null) {
                        // 写入服务器的离线存储
                        ManageOffLineMessage.addMessage(mes.getGetter(), mes);
                    } else {
                        // 从该线程中得到其所维护的 socket 对象，然后获取一个由该 socket 对象对应的 对象输出流。
                        ObjectOutputStream oos = new ObjectOutputStream(thread.getSocket().getOutputStream());
                        // 将该 message 对象写入 getter 接收方对应的数据通道
                        oos.writeObject(mes); // 转发 todo 如果提示客户不在线，可以保存到数据库，这样就可以实现离线留言
                    }
                } else if (mes.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    // 服务端接收到某个客户端发来的群发消息的请求，需要转发给除发送者外的所有在线客户端。
                    ArrayList<Socket> sockets = ManageServerConnectClientThread.getAllSocketWithOutInput(mes.getSender());
                    // 取出除发送者外的所有对应的 socket，然后对每个 socket 都进行写消息。
                    for (Socket i : sockets) {
                        // 获取 socket 对应的对象输出流
                        ObjectOutputStream oos = new ObjectOutputStream(i.getOutputStream());
                        // 写入 mes 对象
                        oos.writeObject(mes);
                    }
                } else if (mes.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    // 接收到了某个客户端传递来的文件消息
                    // 获取该消息对应的接收者的线程，从该线程获得其所持有的 socket
                    ServerConnectClientThread thread = ManageServerConnectClientThread.getServerConnectClientThread(mes.getGetter());
                    // 如果用户客户端不在线，则无法获得与用户客户端相关的 thread
                    if (thread == null) {
                        // 写入服务器的离线存储
                        ManageOffLineMessage.addMessage(mes.getGetter(), mes);
                    } else {
                        ObjectOutputStream oos = new ObjectOutputStream(thread.getSocket().getOutputStream());
                        // 转发
                        oos.writeObject(mes);
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 获取该线程维护的 socket
     *
     * @return
     */
    public Socket getSocket() {
        return socket;
    }
}
