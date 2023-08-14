package basic.practise.wrapper;

public class Integer01 {
    public static void main(String[] args) {
        int n1 = 100;

        // jdk 5 之前，需要手动装箱和手动拆箱
        // 手动装箱 (int -> Integer)
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(5);

        // 手动拆箱 (integer -> int)
        int i = integer.intValue();

        // jdk5 (包含)，之后，自动装箱和自动拆箱
        // 自动装箱 (int-> Integer)，底层仍然是 Integer.valueOf(n1)
        Integer integer2 = n1;

        /**
         *     在上方 debug，进入方法后，跳到 Integer.valueOf 方法
         *     public static Integer valueOf(int i) {
         *         if (i >= IntegerCache.low && i <= IntegerCache.high)
         *             return IntegerCache.cache[i + (-IntegerCache.low)];
         *         return new Integer(i);
         *     }
         */

        // 自动拆箱，底层仍然使用的是 intValue() 方法
        int n2 = integer2;
        /**
         *     在上方 debug，进入方法后，跳到 intValue() 方法
         *     public int intValue() {
         *         return value;
         *     }
         */
    }
}
