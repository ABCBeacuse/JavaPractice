package basic.practise.TemplateTest.improve;

public class BB extends Template{

    public BB(String name) {
        super(name);
    }

    @Override
    public void job() {
        int sum = 0;
        for (int i = 1; i <= 900000; i++) {
            sum += i;
        }
    }
}
