package basic.practise.innerclass;

public class AnonymousClassPractice {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了...");
            }
        });

        cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了...");
            }
        });
    }
}

interface Bell {
    void ring();
}

class Cellphone {
    public void alarmClock(Bell bell) { // 形参是一个接口类型
        bell.ring(); // 动态绑定，会重新回到匿名内部类的 ring 方法
    }
}