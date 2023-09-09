package basic.reflection.question;

public class ClassLoad2 {
    public static void main(String[] args) {
        // 直接使用类的静态资源也会导致类的加载
        System.out.println(B.num);
        /**
         * B 类加载过程
         *
         * 1. 加载 B 类，并生成 B 的 Class 对象
         * 2. 连接阶段（中的准备阶段）会将 num 初始化，并赋值 0
         * 3. 初始化阶段，依次自动 按顺序 收集所有的对静态变量的赋值操作和静态代码块中的语句，并合并
         *
         * clinit() {
         *     System.out.println("B 静态代码块被执行");
         *     // num = 300; // 无效，会被忽略
         *     num = 100;
         * }
         */
    }
}

class B {
    static {
        System.out.println("B 静态代码块被执行");
        num = 300;
    }

    public static int num = 100;

    public B() {

    }
}
