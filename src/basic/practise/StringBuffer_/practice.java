package basic.practise.StringBuffer_;

import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String productTitle, price;
        System.out.println("请输入商品名称：");
        productTitle = scanner.next();
        System.out.println("请输入商品价格");
        while (true) {
            try {
                String inputPrice = scanner.next();
                Double.parseDouble(inputPrice);
                price = practice.format(inputPrice);
                break;
            } catch (NumberFormatException e) {
                System.out.println("请输入正确的商品价格");
            }
        }
        System.out.println("商品    商品价格");
        System.out.println(productTitle + "    " + price);
    }

    /**
     * 生成格式 1,232,412,314,551.31241 添加 ","
     * @param s
     * @return
     */
    public static String format(String s) {
        StringBuffer buffer = new StringBuffer(s);
        for (int i = buffer.indexOf(".") - 3; i > 0; i -= 3) {
            buffer.insert(i, ",");
        }
        return buffer.toString();
    }
}
