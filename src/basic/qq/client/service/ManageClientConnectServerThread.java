package basic.qq.client.service;

import basic.qq.client.thread.ClientConnectServerThread;

import java.util.HashMap;

/**
 * 维护客户端的一个线程集合，该集合中存放着客户端中的很多线程
 */
public class ManageClientConnectServerThread {
    // 我们把多个线程放入到一个 HashMap 集合，key 是 id，value 是线程
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    // 将某个线程加入到集合
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread clientConnectServerThread) {
        hm.put(userId, clientConnectServerThread);
    }

    // 通过 userId 可以得到对应线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId) {
        return hm.get(userId);
    }
}
