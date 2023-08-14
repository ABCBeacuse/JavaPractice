package basic.practise.enum_;

public class Enumeration_01 {
    public static void main(String[] args) {
        System.out.println(Season_.SPRING);
    }
}

class Season_ {
    private String name;
    private String des;

    // 定义四个常量，供外部访问。static + final 优化，访问时 不需要加载类。
    public static final Season_ SPRING = new Season_("春天","温暖");
    public static final Season_ SUMMER = new Season_("夏天","炎热");
    public static final Season_ AUTUMN = new Season_("秋天","凉爽");
    public static final Season_ WINTER = new Season_("冬天","寒冷");


    // 私有化构造器，防止外部直接创建，枚举对象数量恒定
    private Season_(String name, String des) {
        this.name = name;
        this.des = des;
    }

    // 去除 setXXX 方法，防止修改枚举对象的信息，枚举都是常量

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    @Override
    public String toString() {
        return "Season_{" +
                "name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
