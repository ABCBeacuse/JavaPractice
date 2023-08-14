package basic.practise.override_.practice;

public class Student extends Person{

    private int id;

    private double score;

    public Student(String name, int age, int id, double score) {
        super(name, age); // 自动调用
        this.id = id;
        this.score = score;
    }

    // 方法重写
    public String say() {
        return super.say() + " id=" + id + " score=" + score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
