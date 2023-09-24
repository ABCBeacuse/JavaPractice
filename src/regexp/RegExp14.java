package regexp;

import org.junit.jupiter.api.Test;

/**
 * 使用 String.replaceAll(String regexp, String replacement)
 */
public class RegExp14 {
    public static void main(String[] args) {
        String content = "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，" +
                "几周后其获得了Apple公司Mac OS X的工业标准的支持。2001年9月24日，" +
                "J2EE1.3发布。2002年2月26日，J2SE1.4发布。自此Java的计算能力有了大幅提升，与" +
                "J2SE1.3相比，其多了近62%的类和接口。在这些新特性当中，还提供了广泛的XML支持、安全套接字（Socket）支持（通过SSL与TLS协议）、全新的I/OAPI、正则表达式";
        content = content.replaceAll("JDK1\\.(?:3|4)", "JDK");
        System.out.println(content);
    }

    @Test
    void test() {
        // 要求验证一个手机号，要求必须是以 138 139 开头的
        String content = "13888889999";
        if (content.matches("13(?:8|9)\\d{8}")) {
            System.out.println("验证成功");
        } else {
            System.out.println("验证失败");
        }
    }

    @Test
    void test1() {
        // 要求按照 # 或者 - 或者 ~ 或者 数字 来分割
        String content = "hello#abc-jack12smith~北京";
        String[] split = content.split("[#\\-*~]|\\d+");
        for (int i = 0; i < split.length; i++) {
            System.out.print(split[i] + " ");
        }
    }
}
