package basic.practise.interface_;

public class InterfacePolyArr {
    public static void main(String[] args) {
        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone_();
        usbs[1] = new Camera_();


        for (int i = 0; i < usbs.length; i++) {
            // 存在动态绑定
            usbs[i].work();
            // 和前面一样，我们仍然需要进行类型的向下转型
            if(usbs[i] instanceof Phone_) { // 判断他的运行类型是 Phone_
                ((Phone_) usbs[i]).call();
            }
        }
    }
}

interface Usb {
    void work();
}

class Phone_ implements Usb {

    public void call() {
        System.out.println("手机打电话...");
    }

    @Override
    public void work() {
        System.out.println("手机在工作");
    }
}

class Camera_ implements Usb {

    @Override
    public void work() {
        System.out.println("相机在工作");
    }
}
