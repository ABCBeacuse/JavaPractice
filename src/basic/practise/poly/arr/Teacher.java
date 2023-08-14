package basic.practise.poly.arr;

public class Teacher extends Person {
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public String say() {
        return super.say() + "我的工资是 " + salary;
    }

    public String teach() {
        return "老师" + getName() + "正在授课";
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
