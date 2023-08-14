package basic.practise.generic_;

import java.util.*;

public class Generic03 {
    public static void main(String[] args) {
        // 1. HashSet
        // 这里会用 Student 来替换 具体的 E
        Set<Student> set = new HashSet<>();
        // add 方法中也会明确声明需要一个 Student 对象
        set.add(new Student("john", 12));

        // 遍历（取出来默认是 Student 类型，不需要存入时向上转型为 Obejct 和 取出时再向下转型为 Student）
        for (Student t : set) {
            System.out.println(t);
        }

        // 使用泛型后，下面的语句就会报错。
        // set.add(100);
        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student);
        }

        // 2. HashMap
        HashMap<String, Student> map = new HashMap<>();

        /**
         *     public Set<Map.Entry<K,V>> entrySet() {
         *         Set<Map.Entry<K,V>> es;
         *         return (es = entrySet) == null ? (entrySet = new EntrySet()) : es;
         *     }
         *
         *      final class EntrySet extends AbstractSet<Map.Entry<K,V>> {
         *         public final int size()                 { return size; }
         *         public final void clear()               { HashMap.this.clear(); }
         *         public final Iterator<Map.Entry<K,V>> iterator() {
         *             return new EntryIterator();
         *         }
         *         public final boolean contains(Object o) {
         *             if (!(o instanceof Map.Entry))
         *                 return false;
         *             Map.Entry<?,?> e = (Map.Entry<?,?>) o;
         *             Object key = e.getKey();
         *             Node<K,V> candidate = getNode(hash(key), key);
         *             return candidate != null && candidate.equals(e);
         *         }
         */
        // 因为 EntrySet 类继承了 AbstractSet<Map.Entry<K,V>>，所以能够使用 Set<Map.Entry<String, Student>> 类型的变量接收。
        Set<Map.Entry<String, Student>> mapSet = map.entrySet();
        // return Iterator<Map.Entry<K,V>> 即 new EntryIterator();
        Iterator<Map.Entry<String, Student>> iterator1 = mapSet.iterator();

        /**
         *     final class EntryIterator extends HashIterator
         *         implements Iterator<Map.Entry<K,V>> {
         *         public final Map.Entry<K,V> next() { return nextNode(); }
         *     }
         */
        while (iterator1.hasNext()) {
            Map.Entry<String, Student> next = iterator1.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
