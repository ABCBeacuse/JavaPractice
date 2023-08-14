package basic.practise.generic_;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class GenericPractice {
    public static void main(String[] args) {
        Employee jack = new Employee("jack", 10000.0, new MyDate(2022, 11, 12));
        Employee rose = new Employee("jack", 20000.0, new MyDate(2022, 11, 10));
        Employee tom = new Employee("tom", 15000.0, new MyDate(1997, 8, 10));

        ArrayList<Employee> list = new ArrayList<>();
        list.add(jack);
        list.add(rose);
        list.add(tom);
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int res = o1.getName().compareTo(o2.getName());
                if (res == 0) {
                    return o1.getBirth().compareTo(o2.getBirth());
                }
                return res;
            }
        });
        System.out.println(list);
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate o;

    public Employee(String name, double sal, MyDate o) {
        this.name = name;
        this.sal = sal;
        this.o = o;
    }

    public String getName() {
        return name;
    }

    public double getSal() {
        return sal;
    }

    public MyDate getBirth() {
        return o;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", o=" + o +
                '}' + "\n";
    }
}

// 注意 Comparable 接口可以传递 泛型
class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public int compareTo(MyDate o) {
        int yearMinus = year - o.year;
        if (yearMinus != 0) {
            return yearMinus;
        }
        int monthMinus = month - o.month;
        if (monthMinus != 0) {
            return monthMinus;
        }
        return day - o.day;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}