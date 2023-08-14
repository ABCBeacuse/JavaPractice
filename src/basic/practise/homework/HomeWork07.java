package basic.practise.homework;

public class HomeWork07 {
    public static void main(String[] args) {
        Car car = new Car(-2);
        car.check();
    }
}

class Car {
    private int temperature;

    private Air air = new Air();

    public Car(int temperature) {
        this.temperature = temperature;
    }

    class Air {
        public void flow() {
            if (temperature < 0) {
                System.out.println("吹暖气");
            } else if (temperature > 40) {
                System.out.println("吹冷气");
            } else {
                System.out.println("关闭空调");
            }
        }
    }

    public void check() {
        air.flow();
    }
}
