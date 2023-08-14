package basic.practise;

public class PC extends Computer {

    /**
     * 品牌
     */
    private String brand;

    // 这里 IDEA 根据继承的规则，自动把构造器的调用写好
    // 这里也体现：继承设计的基本思想，父类的构造器完成父类属性的初始化
    // 子类的构造器完成子类属性的初始化
    public PC(String cpu, int memory, int disk, String brand) {
        super(cpu, memory, disk);
        this.brand = brand;
    }

    // PC信息
    public void printInfo() {
        // 调用父类的 getDetails 方法，得到 父类 的相关属性信息。
        System.out.println(getDetails() + " brand=" + brand);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
