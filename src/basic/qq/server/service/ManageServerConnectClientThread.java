package basic.qq.server.service;

import basic.qq.server.thread.ServerConnectClientThread;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 服务端用来 管理线程 的一个类，该类用于管理和客户端通信的线程
 * 内部维护一个集合
 */
public class ManageServerConnectClientThread {

    /**
     * key 为 userId，value 为 ServerConnectClientThread
     */
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    /**
     * 将某个线程加入到集合
     *
     * @param userId                    客户端 id
     * @param serverConnectClientThread 线程对象
     */
    public static void addServerConnectClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hm.put(userId, serverConnectClientThread);
    }

    // 通过 userId（客户端 id） 可以得到对应线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        return hm.get(userId);
    }

    // 通过 userId（客户端 id）移除集合中的线程
    public static void removeServerConnectClientThread(String userId) {
        hm.remove(userId);
    }

    /**
     * 获取当前在线人员列表
     */
    public static String getOnlineFriends() {
        String result = "";
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            result += "用户：" + iterator.next() + " ";
        }
        return result;
    }

    /**
     * 获取当前在线的所有 socket（除了 clientId 外）
     */
    public static ArrayList<Socket> getAllSocketWithOutInput(String clientId) {
        ArrayList<Socket> sockets = new ArrayList<>();
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            String cId = iterator.next();
            if (!cId.equals(clientId)) {
                sockets.add(getServerConnectClientThread(cId).getSocket());
            }
        }
        return sockets;
    }

    /**
     * 可以通过 key 的唯一性，实现用户单点登录
     */
}
