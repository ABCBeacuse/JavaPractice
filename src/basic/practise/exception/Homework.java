package basic.practise.exception;

public class Homework {
    public static void main(String[] args) {
        try {
            if (args.length < 2) {
                throw new ArrayIndexOutOfBoundsException("参数不足两个");
            }
            int first = Integer.parseInt(args[0]);
            int second = Integer.parseInt(args[1]);
            double result = cal(first, second);
            System.out.println("计算结果为 " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("除数为 0");
        }
    }

    static double cal(int n1, int n2) {
        return n1 / n2;
    }
}
