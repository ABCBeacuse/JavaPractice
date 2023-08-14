package basic.practise.Arrays;

import java.util.Arrays;
import java.util.List;

public class OtherMethods {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 5, 10, 25, 30};
        System.out.println(Arrays.binarySearch(arr, 33)); // -8
        // return -(low + 1) 其中 low 是 33 如果存在的话，应该在的位置( 30 后面，索引为 7 ) => 即 low = 7.

        // 从 arr 中 copy arr.length 个元素到新数组 newArr 中。
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        System.out.println(Arrays.toString(newArr));

        int[] arr1 = new int[]{1, 2, 3, 4};
        Arrays.fill(arr1, 9);
        System.out.println(Arrays.toString(arr1));

        List list = Arrays.asList(arr1);
        System.out.println(list.getClass());
    }
}
