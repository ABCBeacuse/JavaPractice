package basic.practise.Date;

import java.time.Instant;
import java.util.Date;

public class Instant_ {
    public static void main(String[] args) {
        //1. 通过静态方法 now() 获取当前时间戳的对象
        Instant now = Instant.now();
        System.out.println(now); // 2023-07-05T16:07:28.354Z

        //2. 通过 Date 的静态方法 将 Instant 实例对象转换为 Date
        Date date = Date.from(now);
        //3. 通过 date 的 toInstant 方法 可以把 Date 对象转换为 Instant 对象
        Instant now1 = date.toInstant();
    }
}
