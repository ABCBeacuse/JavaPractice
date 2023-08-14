package basic.practise.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Arrays_ {
    public static void main(String[] args) {
        Integer[] integers = {1, -1, 7, 0, 20, 30};
        // Arrays.sort(integers); // 默认排序方法
        // 1. 可以直接使用冒泡排序，也可以直接使用 Arrays 提供的 sort 方法排序
        // 2. 因为数组是引用类型，所以通过 sort 排序后，会直接影响到 实参 arr
        // 3. sort 是重载的方法，也可以通过传入一个接口 Comparator 实现定制排序
        // 4. 调用 定制排序 时，传入两个参数 (1) 排序的数组 arr (2) 实现了 Comparator 接口的匿名内部类，要求实现 Compare 方法

        // 定制排序
        Arrays.sort(integers, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o2 - (Integer) o1; //向下转型
            }
        });
        System.out.println(Arrays.toString(integers));
    }
}
