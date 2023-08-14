package basic.practise.TemplateTest.improve;

public class AA extends Template{

    public AA(String name) {
        super(name);
    }

    @Override
    public void job() {
        int sum = 0;
        for (int i = 1; i <= 80000; i++) {
            sum += i;
        }
    }
}
