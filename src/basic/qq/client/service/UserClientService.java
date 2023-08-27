package basic.qq.client.service;

import basic.qq.client.thread.ClientConnectServerThread;
import basic.qq.model.domain.Message;
import basic.qq.model.domain.User;
import basic.qq.model.enums.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端与服务器的服务汇总
 *
 * 主要用来管理用户的注册和登录
 */
public class UserClientService {

    /**
     * 将 user 对象提取为属性，该 Service 的其他方法可能会使用
     */
    private User user = new User();

    /**
     * 将与服务端连接成功返回的 socket 对象提取出来，供其他方法使用
     */
    private Socket socket;

    /**
     * 连接到服务端 检查用户信息
     *
     * @param userName
     * @param pwd
     * @return
     */
    public boolean checkUser(String userName, String pwd) {
        // 初始化 user 对象的属性信息
        user.setUserName(userName);
        user.setPassWord(pwd);
        boolean b = false;

        /**
         * 与服务端进行连接，传递 user 对象到服务端，服务端验证用户信息
         * 然后返回 Message 对象给客户端，客户端根据 Message 对象来判断是否登录成功
         */
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);

            // 将 user 对象传递给服务端（使用 对象输出流 来进行传递）
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user);

            // 接收从服务端返回的 Message 对象（使用 对象输入流 来接收从服务器传递回的对象信息）
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            // 因为返回的绝对是 Message 对象，所以这里可以强转
            Message mes = (Message) ois.readObject();

            // 判断返回的 Message 对象的类型
            if (mes.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
                // 登录成功
                /**
                 * 需要创建一个线程对象来维护该 socket 对象
                 *
                 * 使用线程维护原因：方便管理；因为 socket 需要不停的从服务端读取数据，如果不使用线程来维护该 socket 的话，主线程就只能干这一件事了
                 *
                 * 即 创建一个和服务器端保持通信的线程 -> 创建一个类 ClientConnectServerThread
                 */
                ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
                // 启动线程
                ccst.start();
                // 为了方便管理所有的线程，方便客户端的拓展。所以将 该线程 放在客户端一个专门管理线程的集合中
                ManageClientConnectServerThread.addClientConnectServerThread(userName, ccst);
                b = true;
            } else {
                // 登录失败，不能启动和服务器通信的线程
                // 登录失败，关闭 socket。
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return b;
    }

    /**
     * 向服务端请求在线用户信息列表
     */
    public void requestOnlineFriends() {
        // 根据当前登录的 用户名 来获取对应的 线程
        ClientConnectServerThread thread = ManageClientConnectServerThread.getClientConnectServerThread(user.getUserName());
        // 从线程中获取该线程维护的 socket 对象
        Socket socket = thread.getSocket();
        try {
            // 获取该 socket 对应的对象输出流
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            // 创建需要向服务端发送的 Message 对象
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
            message.setSender(user.getUserName());
            // 写入该 socket 对应的数据通道，供服务端读取
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 编写方法，退出客户端，并给服务端发送一个退出系统的 message 对象
     */
    public void logout() {
        // 客户端如果管理了多个线程，最好从 ManageClientConnectServerThread 中根据 唯一key 来取出对应的 socket。
        ClientConnectServerThread thread = ManageClientConnectServerThread.getClientConnectServerThread(user.getUserName());
        // 创建一个 message 对象
        Message mes = new Message();
        mes.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        // 这里必须写，因为 服务端管理着多个客户端对应的 socket 对象，我们需要将服务端的 socket 从管理线程的 HashMap 移除，就需要 key。
        mes.setSender(user.getUserName());
        try {
            // 从 唯一key 对应的 thread 中取出其持有的 socket，然后使用对象输出流来向服务端中该客户端对应的数据通道发送 message 对象
            ObjectOutputStream oos = new ObjectOutputStream(thread.getSocket().getOutputStream());
            // 并发送
            oos.writeObject(mes);
            // 结束整个进程
            System.out.println(user.getUserName() + " 退出客户端");
            System.exit(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
