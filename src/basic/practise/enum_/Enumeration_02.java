package basic.practise.enum_;

public class Enumeration_02 {
    public static void main(String[] args) {
        System.out.println(SeasonEnum.SUMMER);
    }
}

enum SeasonEnum {
    SPRING("春天", "温暖"),
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷");
    // what; // what() 调用无参构造器 ==> 简化为 what
    private String name;
    private String des;

    SeasonEnum() {

    }
    SeasonEnum(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    @Override
    public String toString() {
        return "SeasonEnum{" +
                "name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
