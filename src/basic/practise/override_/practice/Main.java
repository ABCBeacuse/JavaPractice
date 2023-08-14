package basic.practise.override_.practice;

public class Main {
    public static void main(String[] args) {
        Person jack = new Person("Jack", 23);
        System.out.println(jack.say());

        Student smith = new Student("Smith", 24, 001, 99.8);
        System.out.println(smith.say());
    }
}
