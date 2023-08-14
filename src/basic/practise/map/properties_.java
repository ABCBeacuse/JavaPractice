package basic.practise.map;

import java.util.Properties;

public class properties_ {
    public static void main(String[] args) {

        // 1. Properties 继承 HashTable，实现了 Map 接口。
        // 2. 可以通过 k-v 存放数据，key 和 value 不能为 null，否则会抛出空指针异常。
        Properties p = new Properties();

        p.put("john", 100); // k-v
        p.put("lucy", 100);
        p.put("lic", 100);
        p.put("lic", 88); // 如果有相同的 key，value 被替换

        // 底层仍然是 数组 + 链表，先根据 hash 确定 索引 后添加，所以仍然是无序的。
        System.out.println(p);
        // {john=100, lic=88, lucy=100}

        // 通过 k 获取对应值
        System.out.println(p.get("lucy"));
        // 100

        // 删除
        p.remove("lic");
        System.out.println(p);
        // {john=100, lucy=100}

        // 修改，即是替换
        p.put("john", "约翰");
        System.out.println(p);
        // {john=约翰, lucy=100}
    }
}
