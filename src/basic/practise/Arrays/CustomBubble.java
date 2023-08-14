package basic.practise.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class CustomBubble {
    public static void main(String[] args) {
        Integer[] arr = {1, -1, 0, 5, 3, 20};
        bubble(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int s1 = (Integer) o1; // 向下转型 + 自动拆箱
                int s2 = (Integer) o2; // 向下转型 + 自动拆箱
                return s2 - s1; // s2 - s1 逆序 s1 - s2 升序
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    public static void bubble(Integer[] arr, Comparator c) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
