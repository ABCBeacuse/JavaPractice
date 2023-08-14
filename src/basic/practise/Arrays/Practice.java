package basic.practise.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Practice {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘20年", 5);
        books[3] = new Book("java从入门到放弃", 300);

        Arrays.sort(books, new Comparator<Book>() {
            // 这里必须返回的 int ，否则不构成重写。
            // 如果价格是 Double 类型的值，可以使用 double priceD 来接收价格的差值。
            // 然后根据 double 的正负来 return -1 ; return 1; return 0。
            // 因为 Arrays.sort 底层是根据 compare() 返回的 int 值的正负 来进行排序的。
            @Override
            public int compare(Book o1, Book o2) {
                int p1 = o1.getPrice();
                int p2 = o2.getPrice();
                return p2 - p1; // p1 - p2 升序 ; p2 - p1 降序
            }
        });
        System.out.println(Arrays.toString(books));
    }
}

class Book {
    private String name;
    private Integer price;

    public Book(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
