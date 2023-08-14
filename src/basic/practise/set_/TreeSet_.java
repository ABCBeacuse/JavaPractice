package basic.practise.set_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class TreeSet_ {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // 字符串升序
                // return ((String)o1).compareTo((String) o2);
                // [a, jack, sp, tom]

                // 字符串逆序
                return ((String)o2).compareTo((String) o1);
                // [tom, sp, jack, a]
            }
        });


        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("sp");
        treeSet.add("a");

        // TreeSet 在未做任何处理前，也是无序的。
        System.out.println(treeSet); //[a, jack, sp, tom]
    }
}
