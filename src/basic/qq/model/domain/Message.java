package basic.qq.model.domain;

import basic.qq.model.enums.MessageType;

import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = 4386800977539340028L;

    /**
     * 发送者
     */
    private String sender;

    /**
     * 接收者
     */
    private String getter;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 发送时间
     */
    private String sendTime;

    /**
     * 消息类型
     */
    private MessageType mesType;

    /**
     * 文件拓展（字节数组）
     */
    private byte[] fileBytes;

    /**
     * 文件来源路径
     */
    private String src;

    /**
     * 文件目标路径
     */
    private String dest;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public MessageType getMesType() {
        return mesType;
    }

    public void setMesType(MessageType mesType) {
        this.mesType = mesType;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }
}
