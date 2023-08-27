package basic.qq.model.enums;

/**
 * 消息类型的枚举
 */
public enum MessageType {
    MESSAGE_LOGIN_SUCCEED("1", "登录成功"), MESSAGE_LOGIN_FAIL("2", "登录失败"),
    MESSAGE_COMM_MES("3", "普通信息包"), MESSAGE_GET_ONLINE_FRIEND("4", "要求返回在线用户列表"),
    MESSAGE_RET_ONLINE_FRIEND("5", "返回在线用户列表"), MESSAGE_CLIENT_EXIT("6", "客户端请求退出"),
    MESSAGE_TO_ALL_MES("7", "群发消息"), MESSAGE_FILE_MES("8", "文件消息")
    ;

    /**
     * 不同的常量值，表示不同的消息类型
     */
    private String code;
    private String mes;

    MessageType(String code, String mes) {
        this.code = code;
        this.mes = mes;
    }

    public String getCode() {
        return code;
    }

    public String getMes() {
        return mes;
    }
}
