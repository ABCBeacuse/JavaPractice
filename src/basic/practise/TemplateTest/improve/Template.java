package basic.practise.TemplateTest.improve;

public abstract class Template {

    private String name;

    public Template(String name) {
        this.name = name;
    }

    public void clock() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println(name + "任务耗时" + (end - start));
    }

    // 定义 job 抽象方法，由子类继承实现
    public abstract void job();

}
