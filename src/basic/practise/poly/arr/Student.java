package basic.practise.poly.arr;

public class Student extends Person{
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public String say() {
        return super.say() + "我的分数是 " + score;
    }

    public String study() {
        return "学生" + getName() + "正在学 Java ....";
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


}
