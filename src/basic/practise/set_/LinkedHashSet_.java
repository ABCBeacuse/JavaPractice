package basic.practise.set_;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class LinkedHashSet_ {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
        set.add(new String("AA"));
        set.add(456);
        set.add(456); // 重复，添加失败
        set.add(123);
        set.add("HSP");
    }
}
