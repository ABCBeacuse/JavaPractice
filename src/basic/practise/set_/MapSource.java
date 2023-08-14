package basic.practise.set_;

import java.util.*;

public class MapSource {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.put("no1", "jack");
        map.put("no2", "rose");
        map.put(new Car(), new Person());

        Set set = map.entrySet();
        System.out.println(set.getClass()); // HashMap$EntrySet
        for (Object obj : set) {

            System.out.println(obj.getClass()); // HashMap$Node

            // 为了从 HashMap$Node 中取出 k-v，先做一下向下转型
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        Set keySet = map.keySet();

        // 第一组：先取出 所有的 Key，通过 Key 去出对应的 Value
        // (1) 增强 for
        System.out.println("-----第一种方式-------");
        for (Object key : keySet) {
            System.out.println(key + "-" + map.get(key));
        }
        // (2) 迭代器
        System.out.println("-----第二种方式-------");
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + "-" + map.get(key));
        }

        // 第二组：把所有的 values 取出
        Collection values = map.values();
        // 这里可以使用所有的 Collection 使用的遍历方法
        //(1) 增强 for
        System.out.println("---取出所有的 value 增强 for");
        for (Object value : values) {
            System.out.println(value);
        }
        //(2) 迭代器
        System.out.println("---取出所有的 value 迭代器---");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object value = iterator1.next();
            System.out.println(value);
        }

        Set entrySet = map.entrySet();
        System.out.println("-----第三种方式------- EntrySet 的 for 增强");
        for (Object entry : entrySet) {
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }

        System.out.println("-----第四种方式------- EntrySet 的 迭代器");
        Iterator iter = entrySet.iterator();
        while (iter.hasNext()) {
            Object entry =  iter.next();
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
    }
}

class Car {

}

class Person {

}