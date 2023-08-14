package basic.practise.File_.modifier;

/**
 * 处理流（包装流）
 */
public class BufferedRead_ extends Reader_ {

    // 属性是 Reader_ 类型
    private Reader_ reader;

    // 接收 Reader_ 子类对象
    public BufferedRead_(Reader_ reader) {
        this.reader = reader;
    }

    // 也可以调用原始的方法
    @Override
    public void readFile() {
        reader.readFile();
    }

    // 让方法更加灵活，多次读取文件，或者加缓冲 byte[] ... 或者 缓冲 char[] ...
    public void readFiles(int num) {
        for (int i = 0; i < num; i++) {
            reader.readFile();
        }
    }

    // 扩展 readString，批量处理字符串数据
    public void readStrings(int num) {
        for (int i = 0; i < num; i++) {
            reader.readString();
        }
    }

}
