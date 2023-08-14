package basic.practise.TemplateTest;

public class AA {

    public void clock() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("AA 的工作时间为 " + (end - start));
    }

    public void job() {
        // 工作内容
        for (int i = 0; i < 800000; i++) {

        }
    }

}
