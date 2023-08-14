package basic.practise.homework;

public class TestWork {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.testWork(new calculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }, 10.0, 20.2);

        cellPhone.testWork(new calculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 * n2;
            }
        },10.0, 8.0);
    }
}

class CellPhone {
    public void testWork(calculate calculate, double n1, double n2) {
        double result = calculate.work(n1, n2); // 动态绑定
        System.out.println(result);
    }
}

interface calculate {

    //运算方法
    double work(double n1, double n2);
}