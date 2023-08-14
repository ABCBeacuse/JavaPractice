package basic.practise.generic_;

import org.junit.jupiter.api.Test;

import java.util.*;

public class HomeWork {
    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        DAO<User> userDAO = new DAO<>();

        userDAO.save("001", new User(1, 20, "jack"));
        userDAO.save("002", new User(2, 18, "tom"));
        userDAO.delete("001");
        System.out.println(userDAO.list());

        System.out.println(userDAO.get("002"));
    }
}

class DAO<T> {
    Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        return new ArrayList<>(map.values());
    }

    public void delete(String id) {
        map.remove(id);
    }

}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
