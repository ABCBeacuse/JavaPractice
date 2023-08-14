package basic.practise.poly.arr;

public class PolyArr {
    public static void main(String[] args) {

        // 父类的引用可以指向子类的对象
        Person[] persons = new Person[5];
        persons[0] = new Person("jack", 20);
        persons[1] = new Student("jack", 18, 100);
        persons[2] = new Student("smith", 19, 30.1);
        persons[3] = new Teacher("scott", 30, 20000);
        persons[4] = new Teacher("king", 50, 25000);

        for (Person person : persons) {
            // 这里调用时存在 动态绑定机制。
            // person[i] 编译类型是 Person，运行类型是根据实际情况由JVM来判断。
//            System.out.println(person.say());
            // 1. 20岁的jack说
            // 2. 18岁的jack说我的分数是100
            // 3. 19岁的smith说我的分数是30.1
            // 4. 30岁的scott说我的工资是20000
            // 5. 50岁的king说我的工资是25000

            if (person instanceof Student) {
                Student student = (Student) person; // 向下转型
                System.out.println(student.study());
            }else if (person instanceof Teacher){
                Teacher teacher = (Teacher) person;
                System.out.println(teacher.teach());
            }
        }
    }
}
