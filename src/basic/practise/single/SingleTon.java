package basic.practise.single;

public class SingleTon {
    public static void main(String[] args) {
        GirlFriend girlFriend = GirlFriend.getInstance();
        System.out.println(girlFriend);
    }
}

class GirlFriend {

    private String name;

    private static GirlFriend girlFriend = new GirlFriend("小红");

    // 如何保证我们只能创建一个 GirlFriend 对象
    // 步骤
    // 1. 将构造器私有化
    // 2. 在类的内部创建对象
    // 3. 提供一个公共的 static 方法，返回对象
    private GirlFriend(String name) {
        this.name = name;
    }

    public static GirlFriend getInstance() {
        return girlFriend;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
