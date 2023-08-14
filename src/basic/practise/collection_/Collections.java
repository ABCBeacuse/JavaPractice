package basic.practise.collection_;

import java.util.ArrayList;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("张三丰");
        list.add("贾宝玉");

        // void add ( int index, Object o );	在 index 位置插入 o 元素。
        list.add(1, "韩顺平");
        System.out.println("list = " + list);

        // Boolean add ( int index, Collection eles );	在 index 位置开始将 eles 中的所有元素添加进来。
        ArrayList list1 = new ArrayList();
        list1.add("jack");
        list1.add("tom");
        list.addAll(1, list1);
        System.out.println("list = " + list);

        // int indexOf ( Object obj ); 返回 obj 在当前集合中首次出现的位置。
        int i = list.indexOf("jack");
        System.out.println("jack index = " + i);

        // Object remove ( int index );	移除指定 index 位置的元素，并返回此元素。
        list.remove(2);
        System.out.println("list = " + list);

        // Object set ( int index, Object obj ); 	设置指定 index 位置的元素为 obj，相当于是替换。
        list.set(1, "tom");
        System.out.println("list = " + list);

        // List subList ( int fromIndex, int toIndex ); 	返回从 fromIndex 到 tolndex 位置的子集合。【fromIndex, toIndex）
        List subList = list.subList(1, 3);
        // [1, 3)
        System.out.println("subList = " + subList);
    }
}
