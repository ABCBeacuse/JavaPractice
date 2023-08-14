package basic.practise.system_;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;

public class practice {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 10};
//        int[] newArr = new int[4];
        /**
         * src – the source array. 源数组
         * srcPos – starting position in the source array. 从源数组的哪个索引位置开始拷贝
         * dest – the destination array. 目标数组
         * destPos – starting position in the destination data. 把源数组的数据拷贝到 目标数组的哪个索引
         * length – the number of array elements to be copied. 从源数组拷贝多少个数据到目标数组
         */
//        System.arraycopy(arr, 0, newArr, 0, arr.length);
//        System.out.println(Arrays.toString(newArr)); // [1, 2, 3, 10]
//
//        System.arraycopy(arr, 1, newArr, 1, 2);
//        System.out.println(Arrays.toString(newArr)); // [0, 2, 3, 0]
//
////        System.arraycopy(arr, 1, newArr, 3, arr.length);
//        System.out.println(Arrays.toString(newArr)); // 当从 srcPos 开始 ，arr 中没有 length 个元素。会报 ArrayIndexOutOfBoundsException 异常。
//
//        System.out.println(System.currentTimeMillis()); // 1688528783049

        double b = 1999.1111111111111111119999999999999999999999999;
        System.out.println(b);
        BigDecimal bigDecimal = new BigDecimal("1999.11111111111111111199999999999999999999999997788");
        System.out.println(bigDecimal);

        BigDecimal bigDecimal1 = new BigDecimal("1.1");
        System.out.println(bigDecimal.add(bigDecimal1));
        System.out.println(bigDecimal.subtract(bigDecimal1));
        System.out.println(bigDecimal.multiply(bigDecimal1));
        System.out.println(bigDecimal.divide(bigDecimal1, BigDecimal.ROUND_CEILING)); // divide 可能会出现除不尽的情况，如果出现无法除尽的情况
        // 会抛出异常 java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
    }
}
