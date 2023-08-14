package basic.practise.override_.poly.ObjectPoly;

public class Main {
    public static void main(String[] args) {
        // 体验对象多态特点

        // animal 编译类型就是 Animal，运行类型是 Dog
        Animal animal = new Dog();

        // 因为运行时，执行到该行时，animal 的运行类型是 Dog，所以 cry 就是 Dog 的 cry
        animal.cry();

    }
}
