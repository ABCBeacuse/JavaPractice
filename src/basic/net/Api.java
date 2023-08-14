package basic.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Api {
    public static void main(String[] args) throws UnknownHostException {

        // 1. 获取本机的 InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost); // DESKTOP-VEAM1P3/172.23.240.1

        // 2. 根据指定主机名 获取 InetAddress 对象
        InetAddress byName = InetAddress.getByName("DESKTOP-VEAM1P3");
        System.out.println(byName); // DESKTOP-VEAM1P3/172.23.240.1
        
        // 3. 根据域名返回 InetAddress 对象
        InetAddress byDomainName = InetAddress.getByName("www.bilibili.com");
        System.out.println(byDomainName); // www.bilibili.com/123.234.3.166

        // 4. 通过 InetAddress 对象，获取响应的地址
        String hostAddress = byDomainName.getHostAddress();
        System.out.println(hostAddress); // 123.234.3.166

        // 5. 通过 InetAddress 对象，获取相应的主机名 / 或者域名
        String hostName = byDomainName.getHostName();
        System.out.println(hostName); // www.bilibili.com
    }
}
