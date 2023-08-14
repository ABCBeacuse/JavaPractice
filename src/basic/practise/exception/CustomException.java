package basic.practise.exception;

public class CustomException {
    public static void main(String[] args)  {
        try {
            ReturnExceptionDemo.methodA(); // 处理 throw 出来的异常
        } catch (Exception e) {
            // 被捕获处理
            System.out.println(e.getMessage()); // 3 “制造异常”
        }
        ReturnExceptionDemo.methodB();
    }
}

class ReturnExceptionDemo {
    static void methodA() {
        try {
            System.out.println("进入方法 A"); // 1

            // 执行完毕 finally 中的代码块后，才会执行 throw new
            throw new RuntimeException("制造异常");
        } finally {
            // 在 throw 异常前，优先执行 finally 中的代码
            System.out.println("用A方法的finally"); // 2
        }
    }

    static void methodB() {
        try {
            System.out.println("进入方法 B"); // 4
            return;
        } finally {
            // return 前，优先执行 finally 中的代码块
            System.out.println("调用B方法的finally"); // 5
        }
    }
}
