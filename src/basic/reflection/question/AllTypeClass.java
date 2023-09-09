package basic.reflection.question;

import java.io.Serializable;

/**
 * 哪些数据类型有 Class 对象
 */
public class AllTypeClass {
    public static void main(String[] args) {

        Class<String> cls1 = String.class; // 外部类
        Class<Serializable> cls2 = Serializable.class; // 接口
        Class<Thread.State> cls3 = Thread.State.class; // 枚举
        Class<Void> cls4 = void.class; // void 数据类型
        Class<Integer[]> cls5 = Integer[].class; // 数组
        Class<float[][]> cls6 = float[][].class; // 二维数组
        Class<Deprecated> cls7 = Deprecated.class; // 注解
        Class<Long> cls8 = long.class; // 基本数据类型

        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);
    }
}
