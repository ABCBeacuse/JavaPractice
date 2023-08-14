package basic.practise.poly.exercise;

public class Main {
    public static void main(String[] args) {
        Person[] arr = new Person[3];
        arr[0] = new Person("smith", 12, "teacher");
        arr[1] = new Person("jack", 8, "worker");
        arr[2] = new Person("tom", 10, "cleaner");

        Person temp;
        // 冒泡排序 从小到大 排序 Person 数组。
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i].getAge() > arr[i + 1].getAge()) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        for(Person person : arr) {
            System.out.println(person);
        }
    }
}
