package basic.practise.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionPractice {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("smith");
        list.add("king");
        list.add("milan");
        list.add("tom");

        // ArrayList 添加 元素的顺序和输出的顺序 相同
        System.out.println("原数组" + list);

        // reverse 逆序 List
        Collections.reverse(list);
        System.out.println("逆序后" + list);

        // 随机排序(每次排序结果不同)
        Collections.shuffle(list);
        System.out.println("随机排序后" + list);

        // sort 自然排序
        Collections.sort(list);
        System.out.println("自然排序后" + list);

        // sort 添加自己的排序规则
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof String) || !(o2 instanceof String)) {
                    return 0;
                }
                return ((String)o2).length() - ((String)o1).length();
            }
        });
        System.out.println("自定义字符串长度逆序" + list);

        // swap 交换 List 中指定索引元素，如果下标越界会抛出 索引越界异常
        Collections.swap(list, 0, 1);
        System.out.println("swap 交换后" + list);

    }
}
