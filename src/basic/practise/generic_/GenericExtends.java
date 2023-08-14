package basic.practise.generic_;

import java.util.ArrayList;
import java.util.List;

public class GenericExtends {
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<AA> list3 = new ArrayList<>();
        List<BB> list4 = new ArrayList<>();
        List<CC> list5 = new ArrayList<>();

        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);
        printCollection1(list5);

        // ? extends AA 表示上限，可以接受 AA 或者 AA 的子类
        // printCollection2(list1); 错误
        // printCollection2(list2); 错误
        printCollection2(list3);
        printCollection2(list4);
        printCollection2(list5);

        // ? super AA 表示下限，可以接受 AA 或者 AA 的父类，不限于直接父类
        printCollection3(list1);
        // printCollection3(list2); 错误
        printCollection3(list3);
        // printCollection3(list4); 错误
        // printCollection3(list5); 错误
    }

    // 说明：List<?> 表示任意的泛型类型都可以接受
    public static void printCollection1(List<?> c) {
        for (Object obj : c) {  // 通配符，取出时，就是 Object
            System.out.println(obj);
        }
    }

    // ? extends AA 表示上限，可以接受 AA 或者 AA 的子类
    public static void printCollection2(List<? extends AA> c) {
        for (Object obj : c) {  // 通配符，取出时，就是 Object
            System.out.println(obj);
        }
    }

    // ? super AA 表示下限，可以接受 AA 或者 AA 的父类，不限于直接父类
    public static void printCollection3(List<? super AA> c) {
        for (Object obj : c) {  // 通配符，取出时，就是 Object
            System.out.println(obj);
        }
    }
}

class AA {
}

class BB extends AA {
}

class CC extends BB {
}
