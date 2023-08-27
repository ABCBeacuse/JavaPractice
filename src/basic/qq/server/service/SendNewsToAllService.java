package basic.qq.server.service;

import basic.qq.model.domain.Message;
import basic.qq.model.enums.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * 服务端推送新闻，自定义线程
 */
public class SendNewsToAllService implements Runnable {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        // 服务端可以一直推送新闻，所以这里使用 while(true) 防止线程退出
        String newsContent = "";
        // 封装一个 message 对象，用来存放新闻内容并发送
        Message message = new Message();
        while (true) {
            System.out.print("请输入新闻内容：");
            newsContent = scanner.next();
            // 完善 message 对象内容
            // 设置 message 类型为 群发消息类型
            message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
            message.setSender("服务端");
            message.setSendTime(new Date().toString());
            message.setContent(newsContent);
            // 取得所有在线用户的 socket 对象
            ArrayList<Socket> onlineSockets = ManageServerConnectClientThread.getAllSocketWithOutInput("");
            // 给所有在线用户发送 message 对象
            ObjectOutputStream oos = null;
            try {
                for (Socket socket : onlineSockets) {
                    oos = new ObjectOutputStream(socket.getOutputStream());
                    // 发送
                    oos.writeObject(message);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
