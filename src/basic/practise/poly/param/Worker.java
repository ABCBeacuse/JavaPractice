package basic.practise.poly.param;

public class Worker extends Employee {

    public Worker(String name, double salary) {
        super(name, salary);
    }

    public void work() {
        System.out.println(getName() + "员工工作");
    }

    // 因为普通员工没有其他收入，直接调用父类方法就可以了。
    public double getAnnual() {
        return super.getAnnual();
    }
}
