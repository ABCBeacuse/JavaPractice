package basic.practise.enum_;

public class Test {
    public static void main(String[] args) {
        SeasonEnum Autumn = SeasonEnum.AUTUMN;

        // toString：Enum 类已经重写过了，返回的是当前对象名，子类可以重写该方法（Enum 中不是final），用于返回对象的属性信息
        System.out.println(Autumn.toString()); // SeasonEnum{name='秋天', des='凉爽'} （ tip：子类重写了 toString 方法 ）

        // name：返回当前对象名（常量名），子类中不能重写（Enum 中是 final）
        System.out.println(Autumn.name()); // AUTUMN

        // ordinal：返回当前对象的位置号，默认从 0 开始
        System.out.println(Autumn.ordinal()); // 2

        // values：返回当前枚举类中所有的常量，javap 反编译 枚举类的 class 文件时，可以看到隐藏的 static values 方法
        // public static basic.practise.enum_.SeasonEnum[] values();
        System.out.println(SeasonEnum.values()); // [Lbasic.practise.enum_.SeasonEnum;@1b6d3586 返回的是数组对象

        System.out.println("================");
        for (SeasonEnum season : SeasonEnum.values()) {
            System.out.println(" " + season + " ");
        }
        System.out.println("===========");
        // SeasonEnum{name='春天', des='温暖'}  SeasonEnum{name='夏天', des='炎热'}  SeasonEnum{name='秋天', des='凉爽'}  SeasonEnum{name='冬天', des='寒冷'}  SeasonEnum{name='null', des='null'} SeasonEnum{name='夏天', des='炎热'}

        // valueOf：将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常，javap 反编译 枚举类的 class 文件时，可以看到隐藏的 static valueOf 方法
        // 1. 根据输入的 "AUTUMN" 到 SeasonEnum 的枚举对象去查找
        // 2. 如果找到了，就返回，如果没有找到，就报错
        SeasonEnum autumn = SeasonEnum.valueOf("AUTUMN");
        System.out.println(autumn); // SeasonEnum{name='夏天', des='炎热'}，tip：没有重写就是 SUMMER
        System.out.println(autumn == Autumn); // true ，因为是 static 的，所以是同一个对象

        // compareTo：比较两个枚举常量，比较的就是位置号
        System.out.println(Autumn.compareTo(SeasonEnum.SUMMER)); // 1   2 - 1 = 1
    }
}
