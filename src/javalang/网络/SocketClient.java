package javalang.网络;

import java.io.OutputStream;
import java.net.Socket;

/**
 * created on 2019/2/13
 *
 * @author J
 **/
public class SocketClient {
    public static void main(String args[]) throws Exception {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        // 与服务端建立连接
        Socket socket = new Socket(host, SocketServer.port+1);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message="你好  我发了一条消息";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        outputStream.close();
        socket.close();
    }
}
