package basic.practise.collection;

import java.util.*;

public class CollectionHomeWork {
    public static void main(String[] args) {
        Map map = new HashMap();

        Worker jack = new Worker("jack", 650);
        Worker tom = new Worker("tom", 1200);
        Worker smith = new Worker("smith", 2900);

        map.put(jack.getName(), jack.getSal());
        map.put(tom.getName(), tom.getSal());
        map.put(smith.getName(), smith.getSal());

        // 将 jack 的工资改为 2600
        map.put("jack", 2600);
        Set set = map.entrySet();
        for (Object o : set) {
            Map.Entry entry = (Map.Entry) o;
            entry.setValue((Integer) entry.getValue() + 100);
        }

        // 遍历集合中所有的工资
        Collection values = map.values();
        Iterator iterator = values.iterator();
        while (iterator.hasNext()) {
            Object sal = iterator.next();
            System.out.print(sal + " ");
        }

        // 遍历集合中所有的员工
        Set workers = map.keySet();
        for (Object o : workers) {
            System.out.print(o + " ");
        }

        // 遍历 K-v
        for (Object o : set) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}

class Worker {
    private String name;
    private int sal;

    public Worker(String name, int sal) {
        this.name = name;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }
}

