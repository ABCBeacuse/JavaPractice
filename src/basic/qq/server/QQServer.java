package basic.qq.server;

import basic.qq.model.domain.Message;
import basic.qq.model.domain.User;
import basic.qq.model.enums.MessageType;
import basic.qq.server.service.ManageOffLineMessage;
import basic.qq.server.service.ManageServerConnectClientThread;
import basic.qq.server.service.SendNewsToAllService;
import basic.qq.server.thread.ServerConnectClientThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * QQ 服务端
 */
public class QQServer {

    // 将 serverSocket 提取出来，供其他方法使用
    private ServerSocket serverSocket;

    /**
     * 模拟数据库，合法用户
     * <p>
     * HashMap 没有处理线程安全，因此在多线程情况下是不安全的
     * ConcurrentHashMap 处理的线程安全，即线程同步处理，在多线程下是安全的
     */
    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();

    static {
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("会员魔君", new User("会员魔君", "123456"));
    }

    public static void main(String[] args) {
        new QQServer().serverStart();
    }

    /**
     * 启动服务端，使其在 9999 端口进行监听
     */
    public void serverStart() {
        try {
            System.out.println("服务端启动, 在 9999 端口进行监听");
            serverSocket = new ServerSocket(9999);
            // 启动推送新闻线程
            new Thread(new SendNewsToAllService()).start();
            // 循环监听，生成 不同客户端 对应的 socket 对象，服务端一直在监听
            while (true) {
                // 有客户端连接成功，返回 socket 对象；如果没有客户端连接，则阻塞在这里
                Socket socket = serverSocket.accept();
                // 读取从客户端传来的 user 对象（用户验证），得到 socket 关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 第一个读取的对象信息一定是一个 user 对象
                User u = (User) ois.readObject();

                // 服务端校验后，需要给客户端返回 Message 信息，得到 socket 关联的对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                // 创建服务端返回给客户端的 Message 对象
                Message message = new Message();
                // 校验 user 对象的信息
                if (checkUser(u.getUserName(), u.getPassWord())) {
                    // 设置 message 对象的消息类型为 登录成功
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    // 校验成功，创建一个 服务端的线程 来维护该 socket 对象（即成功连接一个客户端，启动一个线程来维护与该客户端对应的 socket）
                    ServerConnectClientThread scct = new ServerConnectClientThread(u.getUserName(), socket);
                    // 启动该线程
                    scct.start();
                    // 将这个线程添加到 服务端一个专门维护线程的列表中
                    ManageServerConnectClientThread.addServerConnectClientThread(u.getUserName(), scct);
                    // 返回给 socket 对应的客户端 Message 对象
                    oos.writeObject(message);
                    // 查看该客户端是否存在离线消息 / 文件
                    ArrayList<Message> offlineMessage = ManageOffLineMessage.getMessage(u.getUserName());
                    if (offlineMessage != null) {
                        // 存在离线信息
                        for (Message mes : offlineMessage) {
                            oos = new ObjectOutputStream(socket.getOutputStream());
                            // 将离线信息写入数据通道
                            oos.writeObject(mes);
                        }
                        // 读取完毕后，删除存储的离线消息 / 文件
                        ManageOffLineMessage.removeMessage(u.getUserName());
                    }
                } else {
                    // 设置 message 的类型为 登录失败
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    // 向通道写入 message
                    oos.writeObject(message);
                    // 服务端 消息提示
                    System.out.println("用户 " + u.getUserName() + " 尝试登录失败");
                    // 校验失败，关闭 socket
                    socket.close();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // 如果服务器退出了 while，说明服务器端不再，因此需要关闭 ServerSocket
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 查看用户是否在 validUsers HashMap 集合中
     */
    private boolean checkUser(String userName, String password) {
        User user = validUsers.get(userName);
        if (user != null && user.getPassWord().equals(password)) {
            return true;
        }
        return false;
    }
}
