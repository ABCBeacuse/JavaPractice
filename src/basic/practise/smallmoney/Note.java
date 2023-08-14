package basic.practise.smallmoney;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {

    /**
     * 消费记录
     */
    private String detail = "";

    /**
     * 余额
     */
    private double balance;

    /**
     * 格式化输入的时间
     *
     * @param date 传入的 Date 对象
     * @return
     */
    private String getFormatDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:MM").format(date);
    }

    /**
     * 入账
     *
     * @param money 入账金额
     */
    public void enterAccount(double money) {
        balance += money;
        detail += "收益入账" + "\t+" + money + "\t" + getFormatDate(new Date()) + "\t余额:" + balance + "\n";
    }

    /**
     * 消费
     *
     * @param note  消费说明
     * @param money 消费金额
     */
    public void outAccount(String note, double money) {
        balance -= money;
        detail += note + "\t-" + money + "\t" + getFormatDate(new Date()) + "\t余额:" + balance + "\n";
    }

    /**
     * 获取消费记录
     *
     * @return
     */
    public String getDetail() {
        return detail;
    }
}
