package basic.practise.generic_;

import java.util.ArrayList;

public class detail2 {
    public static void main(String[] args) {
        // 如果这个类要求你传入一个泛型，但是你没有指定泛型，默认是 Object
        ArrayList<Tiger> list = new ArrayList();
        // 等价于 ArrayList<Object> list = new ArrayList<Object>();  或者简写 ArrayList<Object> list = new ArrayList<>();

        Tiger tiger = new Tiger();
        /**
         * 等价于
         *
         * class Tiger<Object> {
         *     Object e;
         *
         *     public Tiger() {
         *     }
         *
         *     public Tiger(Object e) {
         *         this.e = e;
         *     }
         * }
         */
    }
}

class Tiger<E> {
    E e;

    public Tiger() {
    }

    public Tiger(E e) {
        this.e = e;
    }
}
