package basic.practise.enum_;

public class Enumeration {
    public static void main(String[] args) {
        Season spring = new Season("春天", "温暖");
        Season summer = new Season("夏天", "炎热");
        Season autumn = new Season("秋天", "凉爽");
        Season winter = new Season("冬天", "寒冷");

        // 这样写的话，仍然可以创建额外的季节，这样不好。因为对于季节而言，他的对象（具体值），是固定的四个，不会有更多。
        Season other = new Season("轰天", "~~~");
        // 这个设计思路，不能体现出季节是固定的四个对象
        // 好的设计 ===> 枚举类[枚：一个一个，举：列举，把具体的对象一个一个列举出来的类，就称为枚举类]

    }
}
class Season {
    private String name;
    private String desc;

    public Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
