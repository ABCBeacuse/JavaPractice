package basic.practise.set_;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetPractice_ {
    public static void main(String[] args) {
        Set set = new HashSet();
        // 因为这是三个不同的对象，所以 hash 值都不会相同，如果 hash 值不同的化，显然都能够添加进去。
        set.add(new Employee("jack", 18));
        set.add(new Employee("jack", 10));
        set.add(new Employee("Rose", 18));
        // 根据 equals 判断，下面这个 Employee 对象不会被添加
        set.add(new Employee("jack", 18));
        System.out.println(set);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // 重写 equals 方法，用于 HashSet 添加时 重复判断。


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
