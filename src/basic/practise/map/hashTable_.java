package basic.practise.map;

import java.util.Hashtable;

public class hashTable_ {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("john", 100); // ok
        hashtable.put(null, 100);  // 空指针异常
        hashtable.put("john", null); // 空指针异常
        hashtable.put("lucy", 100); // ok
        hashtable.put("lic", 100); // ok
        hashtable.put("lic", 88); // 替换
    }
}
