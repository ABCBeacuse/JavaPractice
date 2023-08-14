package basic.practise.Date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTime_ {
    public static void main(String[] args) {
        // LocalDateTime 包含了 日期和时间，如果仅想获得日期，则使用 LocalDate.now()；如果仅想获得时间，则使用 LocalTime.now()
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now); // 2023-07-05T23:31:53.638
        System.out.println("年= " + now.getYear());
        System.out.println("月= " + now.getMonth()); // 获取英文的月
        System.out.println("月= " + now.getMonthValue()); // 获取数字的月
        System.out.println("日= " + now.getDayOfMonth());
        System.out.println("时= " + now.getHour());
        System.out.println("分= " + now.getMinute());
        System.out.println("秒= " + now.getSecond());

        // DateTimeFormatter 格式化 LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(now);
        System.out.println(format);
    }
}
