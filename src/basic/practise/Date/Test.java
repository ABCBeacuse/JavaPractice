package basic.practise.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");
        String s = dateFormat.format(date);

        Date parse = dateFormat.parse("2023年07月05日 17:31:29 星期三");
        System.out.println(parse);


        Date date1 = new Date(900238124);

    }
}
