package basic.practise.TemplateTest;

public class BB {

    public void clock() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("BB 的工作时间为 " + (end - start));
    }

    public void job() {
        // 工作内容
        for (int i = 0; i < 1000000; i++) {

        }
    }

}
