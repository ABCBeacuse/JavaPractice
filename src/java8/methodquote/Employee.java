package java8.methodquote;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private Integer salary;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(Integer id, String name, Integer age, Integer salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1001, "马化腾", 94, 6000));
        list.add(new Employee(1002, "马云", 12, 9876));
        list.add(new Employee(1003, "刘强东", 33, 3000));
        list.add(new Employee(1004, "雷军", 26, 7657));
        list.add(new Employee(1005, "李彦宏aa", 65, 5555));
        list.add(new Employee(1006, "比尔盖茨", 42, 9500));

        return list;
    }
}
