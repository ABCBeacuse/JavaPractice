package basic.practise.homework;

public class HomeWork06 {
    public static void main(String[] args) {
        Person person = new Person("唐僧", new Horse());
        person.passRiver();
        person.common();
    }
}

interface Vehicles {
    String work();
}

class Horse implements Vehicles {
    @Override
    public String work() {
        return "一般骑着马";
    }
}

class Boat implements Vehicles {
    @Override
    public String work() {
        return "过河开着船";
    }
}

class Factory {

    // 一直骑同一个马
    private static Horse horse = new Horse();

    // 私有化构造器，防止外部创建
    private Factory() {}

    public static Horse getHorseObj() {
        // 始终使用的是同一个 Horse 对象
        return horse;
    }

    public static Boat getBoatObj() {
        return new Boat();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver() {
        if (!(vehicles instanceof Boat)){
            vehicles = Factory.getBoatObj();
        }
        System.out.println(name + vehicles.work()); // 动态绑定
    }

    public void common() {
        if(!(vehicles instanceof Horse)) {
            vehicles = Factory.getHorseObj();
        }
        System.out.println(name + vehicles.work()); // 动态绑定
    }
}
