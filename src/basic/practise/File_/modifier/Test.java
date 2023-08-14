package basic.practise.File_.modifier;

public class Test {
    public static void main(String[] args) {
        BufferedRead_ bufferedRead_ = new BufferedRead_(new FileReader_());

        // 调用增强方法去读取文件，因为传递了 new FileReader_()
        bufferedRead_.readFiles(2);

        // 调用增强方法去读取字符串，因为传递了 new StringReader_()
        BufferedRead_ bufferedRead_1 = new BufferedRead_(new StringReader_());
        bufferedRead_1.readStrings(2);
    }
}

/**
 * 读取文件
 * 读取文件
 * 读取字符串
 * 读取字符串
 */
