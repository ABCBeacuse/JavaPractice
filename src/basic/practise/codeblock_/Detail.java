package basic.practise.codeblock_;

public class Detail {

    public static void main(String[] args) {
        Father father = new Father();
        // Father 的静态代码块被调用，表示 Father 类成功加载。
        // Father 的普通代码块被调用，表示 Father 类对象实例的创建。
        Father father1 = new Father();
        // Father 的普通代码块被调用，表示 Father 类对象实例的创建。
        String name = Father.name;
        // Father 的静态代码块被调用，表示 Father 类成功加载。
    }

}

class Father {

    public static String name = "Jack";

    static {
        System.out.println("Father 的静态代码块被调用，表示 Father 类成功加载。");
    }

    {
        System.out.println("Father 的普通代码块被调用，表示 Father 类对象实例的创建。");
    }
}
