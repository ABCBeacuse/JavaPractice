package basic.practise.set_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapPractice {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        Worker jack = new Worker(1, "jack", 10000.0);
        Worker rose = new Worker(2, "rose", 19000.0);
        Worker tom = new Worker(3, "tom", 20000.0);

        map.put(jack.getId(), jack);
        map.put(rose.getId(), rose);
        map.put(tom.getId(), tom);

        Set set = map.entrySet();

        for (Object o : set) {
            Map.Entry entry = (Map.Entry) o;
            Worker worker = (Worker) entry.getValue();
            if(worker != null && worker.getSal() > 18000) {
                System.out.println(worker);
            }
        }

        System.out.println("===========");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Worker worker = (Worker) entry.getValue();
            if(worker != null && worker.getSal() > 18000) {
                System.out.println(worker);
            }
        }
    }
}

class Worker {
    private int id;
    private String name;
    private double sal;

    public Worker(int id, String name, double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSal() {
        return sal;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }
}
