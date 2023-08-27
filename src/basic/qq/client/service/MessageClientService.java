package basic.qq.client.service;

import basic.qq.client.thread.ClientConnectServerThread;
import basic.qq.model.domain.Message;
import basic.qq.model.enums.MessageType;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * 客户端向服务端发送的不同类别的消息的服务
 */
public class MessageClientService {

    /**
     * 私聊
     *
     * @param sender  发送人
     * @param getter  接收人
     * @param content 消息内容
     */
    public void directMessage(String sender, String getter, String content) {
        // 一个序列化对象只能有一个 header。
        // 第二次写入 header 后，readObject 无法识别 header，就会报 AC 异常。
        Message message = new Message();
        // message 对象，用来封装所有需要的信息
        message.setSender(sender);
        message.setGetter(getter);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        // 私聊的消息类型为 普通消息类型
        message.setMesType(MessageType.MESSAGE_COMM_MES);

        System.out.println(sender + " 对 " + getter + " 说：" + content);

        // 发送给服务端
        // 需要通过 客户端 id 获取到该客户端对应的 线程 对象，然后从该线程对象中获取 其持有的 socket 对象。
        Socket socket = ManageClientConnectServerThread.getClientConnectServerThread(sender).getSocket();
        try {
            // 通过 socket 对象来得到 对象输出流，用来给服务端发送该 message 对象。
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            // 将 message 对象写入该客户端对应的 数据通道，传递给服务端（服务端作为一个中转站），服务端接收到消息后，再转发给 getter 对应的客户端。
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 群发消息
     *
     * @param sender  发送者
     * @param content 内容
     */
    public void sendMessageToAll(String sender, String content) {
        Message message = new Message();
        // message 对象，用来封装所有需要的信息
        message.setSender(sender);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        // 私聊的消息类型为 群发消息类型
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
        // 根据 sender（客户端 id）获取到该客户端对应的 线程 对象，然后从该线程对象中获取 其持有的 socket 对象。
        Socket socket = ManageClientConnectServerThread.getClientConnectServerThread(sender).getSocket();
        try {
            // 通过 socket 对象来得到 对象输出流，用来给服务端发送该 message 对象。
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            // 将 message 对象写入该客户端对应的 数据通道，传递给服务端（服务端作为一个中转站），服务端接收到消息后，再转发 给除发送者外的所有客户端。
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 文件传输方法
     *
     * @param path   文件路径
     * @param sender 发送方
     * @param getter 接收方
     * @param dest   保存路径
     */
    public void transFileMessage(String path, String sender, String getter, String dest) {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSender(sender);
        message.setGetter(getter);
        // 设置源路径
        message.setSrc(path);
        // 目标路径
        message.setDest(dest);
        // 将文件先读取到内存中
        BufferedInputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(path));
            // 创建一个字节缓冲区，用来存储读取的文件字节数据
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buf)) != -1) {
                // 往字符缓冲区中写入 文件字节数据
                byteArrayOutputStream.write(buf, 0, len);
            }
            // 获取存储在内存中的所有字节数据
            byte[] fileBytes = byteArrayOutputStream.toByteArray();
            // 将文件信息封装到 message 对象中
            message.setFileBytes(fileBytes);
            // 根据 sender（客户端 id）获取其对应的线程，再根据线程获取其持有的 socket 对象
            ClientConnectServerThread thread = ManageClientConnectServerThread.getClientConnectServerThread(sender);
            ObjectOutputStream oos = new ObjectOutputStream(thread.getSocket().getOutputStream());
            // 写入数据通道，发送 message 对象给服务端
            oos.writeObject(message);
            System.out.println(message.getSender() + " 发送给 " + message.getGetter() + " 的文件: " + message.getSrc() + " 转存在 " + message.getDest());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (inputStream != null) {
                    // 关闭流，释放资源
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    // 关闭 ByteArrayOutputStream 没有任何效果
                    byteArrayOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
