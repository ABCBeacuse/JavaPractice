package basic.practise.enum_;

public enum Gender {
    // public static final Gender BOY = new Gender(); 使用 Gender类 的默认的无参构造器创建
    BOY,
    // public static final Gender GIRL = new Gender(); 使用 Gender类 的默认的无参构造器创建
    GIRL;

    // 如果自己声明了一个构造器，默认的无参构造器会失效
    private Gender(String name) {

    }

    // 需要显式的再声明一个无参构造器，否则 BOY 等，那里报错
    private Gender() {

    }
}
