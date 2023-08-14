package basic.practise.Date;

import java.util.Calendar;

public class Calendar_ {
    public static void main(String[] args) {
        // 创建日历类对象
        Calendar c = Calendar.getInstance();
        // 获取日历对象的某个日历字段
        System.out.println("年: " + c.get(Calendar.YEAR));
        System.out.println("月: " + (c.get(Calendar.MONTH) + 1));
        System.out.println("日: " + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时: " + c.get(Calendar.HOUR_OF_DAY));
        System.out.println("分钟: " + c.get(Calendar.MINUTE));
        System.out.println("秒: " + c.get(Calendar.SECOND));

        // Calendar 没有专门的格式化方法，所以需要程序员自己来组合显示
    }
}
