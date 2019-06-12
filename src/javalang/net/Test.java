package javalang.net;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress[] address = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress item : address){
            System.out.println(item);
        }
    }
}
