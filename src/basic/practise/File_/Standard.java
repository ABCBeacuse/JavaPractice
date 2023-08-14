package basic.practise.File_;

/**
 * 标准输入输出流
 */
public class Standard {
    public static void main(String[] args) {

        /**
         *  System.java 中  public final static InputStream in = null;
         *  System.in 的编译类型时 InputStream，运行类型时 BufferedInputStream（是一个包装流、处理流、字节流）
         *  表示的是标准输入 --- 键盘
         */
        System.out.println(System.in.getClass());


        /**
         * System.java 中 public final static PrintStream out = null;
         * System.out 的编译类型是 PrintStream，运行类型是 PrintStream（是一个包装流、处理流、字符流）
         * 表示的是标准输出 --- 显示器
         */
        System.out.println(System.out.getClass());
    }
}
