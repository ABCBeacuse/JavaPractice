package basic.practise.interface_;

public class Computer {
    // 计算机接入了一个接口，开放了一个接口插槽
    // 1. 形参是接口类型 UsbInterface
    // 2. 可以接收 实现了 UsbInterface 接口的类的对象实例
    public void work(UsbInterface usbInterface) {
        // 通过接口，来调用方法
        usbInterface.start();
        usbInterface.stop();
    }
}
