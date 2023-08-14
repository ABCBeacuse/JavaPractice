package basic.practise.map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMap_ {
    public static void main(String[] args) {

        // 使用默认的构造器，创建 TreeMap
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                // 按照字符串逆序
                // return ((String)o2).compareTo((String) o1);

                // 按照字符串长度(逆序)
                // return ((String)o2).length() - ((String)o1).length();

                return ((String) o1).length() - ((String) o2).length();
            }
        });

        treeMap.put("tom", "汤姆");
        treeMap.put("smith", "史密斯");
        treeMap.put("jack", "杰克");
        treeMap.put("kristina", "克瑞斯提诺");
        treeMap.put("hsp", "hsp");

        System.out.println(treeMap);
    }
}

class A {
    private int number;

    public A(int number) {
        this.number = number;
    }
}