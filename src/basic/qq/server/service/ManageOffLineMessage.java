package basic.qq.server.service;

import basic.qq.model.domain.Message;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 离线消息 / 文件存储
 */
public class ManageOffLineMessage {

    /**
     * 使用 ConcurrentHashMap 模拟数据库，存储离线信息
     */
    private static ConcurrentHashMap<String, ArrayList<Message>> dataBase = new ConcurrentHashMap<>();

    /**
     * 添加离线信息
     *
     * @param userId
     * @param message
     */
    public static void addMessage(String userId, Message message) {
        if (dataBase.get(userId) == null) {
            dataBase.put(userId, new ArrayList<>());
        }
        dataBase.get(userId).add(message);
    }

    /**
     * 根据 userId 获取 离线信息
     *
     * @param userId
     * @return
     */
    public static ArrayList<Message> getMessage(String userId) {
        return dataBase.get(userId);
    }

    /**
     * 根据 userId 移除 离线信息（一次性移除所有离线信息）
     *
     * @param userId
     */
    public static void removeMessage(String userId) {
        dataBase.remove(userId);
    }
}
