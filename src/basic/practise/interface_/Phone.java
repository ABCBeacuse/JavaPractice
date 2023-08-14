package basic.practise.interface_;

public class Phone implements UsbInterface{ // 实现接口，就是把接口方法实现
    @Override
    public void start() {
        System.out.println("手机开始工作..");
    }

    @Override
    public void stop() {
        System.out.println("手机停止工作..");
    }
}
