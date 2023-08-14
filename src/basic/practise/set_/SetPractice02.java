package basic.practise.set_;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetPractice02 {
    public static void main(String[] args) {
        Employeee jack = new Employeee("jack", new MyDate(2023, 1, 5), 10000);
        Employeee rose = new Employeee("rose", new MyDate(2022, 1, 5), 13000);
        Employeee jack1 = new Employeee("jack", new MyDate(2023, 1, 5), 12000);

        Set set = new HashSet();
        set.add(jack);
        set.add(rose);
        set.add(jack1);

        System.out.println(set);
    }
}

class Employeee {
    private String name;
    private MyDate birthday;
    private double sal;

    public Employeee(String name, MyDate birthday, double sal) {
        this.name = name;
        this.birthday = birthday;
        this.sal = sal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employeee employeee = (Employeee) o;
        /**
         *     public static boolean equals(Object a, Object b) {
         *         return (a == b) || (a != null && a.equals(b));
         *     }
         *     String 已重写 equals 方法
         *     所以这里也需要重写 MyDate 的 equals 方法，保证 hash 相同后的 HashMap 中 table add 元素的下一步 equals 判断。
         */
        return Objects.equals(name, employeee.name) && Objects.equals(birthday, employeee.birthday);
    }

    @Override
    public int hashCode() {
        // 这里会用到 传入参数的每个 Object o 的 hashcode
        // name 是 String 类型，String 已重写 hashcode 方法

        // 所以我们需要重写 MyDate 的 hashcode，保证 年月日 相同的 MyDate 对象返回一致的 hashcode。

        // 为了满足 HashSet 底层的 HashMap 从 hash 值获取索引值时，能推出相同的索引。
        // 只要推出的索引相同，就会放到 HashSet 底层 HashMap 的 table 表中的相同位置，才会有下一步的 equals 比较。
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employeee{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", sal=" + sal +
                '}';
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
