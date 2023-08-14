package basic.practise.exception;

public class Homework2 {
    public static void main(String[] args) {
        if (args[4].equals("john")) { // 如果没有输入 5 个参数，就会出现空指针异常 NLP
            System.out.println("AA");
        } else {
            System.out.println("BB");
        }
        Object o = args[2]; // 向上转型 运行类型 String -> Object
        Integer integer = (Integer) o; // 运行类型 String -> Integer 会出现 ClassCast 类型转化异常
    }
}

