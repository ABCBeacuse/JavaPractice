package basic.practise.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionPractice2 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("smith");
        list.add("king");
        list.add("milan");
        list.add("tom");

        // 自然排序，返回给定集合最大的元素
        System.out.println("自然排序，返回最大的" + Collections.max(list));
        // 自然排序，返回最大的tom

        // 指定排序方式，返回给定集合最大的元素
        System.out.println("指定排序，返回给定集合最大的元素" + Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // 返回长度最大的
                // return ((String)o1).length() - ((String)o2).length();

                // 返回长度最小的（比较条件一发生变化，就能得到最小的）
                return ((String) o2).length() - ((String) o1).length();
            }
        }));
        // 指定排序，返回给定集合最大的元素tom

        // 给定集合中，给定 Object 出现的次数
        System.out.println("给定 Object 出现的次数 " + Collections.frequency(list, "tom"));
        // 给定 Object 出现的次数 1

        // 将 src 中的内容复制到 dest 中。
        ArrayList dest = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            dest.add("");
        }
        // 根据查看源码，发现 dest 的 size 需要与 list.size() 相同，否则会抛出索引越界异常。
        Collections.copy(dest, list);
        System.out.println("copy 后的 dest " + dest);
        // copy 后的 dest [smith, king, milan, tom]

        // 使用新值替换 List 对象中的所有旧值。
        // 如果 list 中，有 tom 就替换成 汤姆
        Collections.replaceAll(dest, "tom", "汤姆");
        System.out.println("replaceAll 之后的 dest " + dest);
        // replaceAll 之后的 dest [smith, king, milan, 汤姆]
    }
}
