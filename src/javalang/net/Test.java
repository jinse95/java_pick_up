package javalang.net;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9898);
        while (true) {
            Socket socket = server.accept();
            System.out.println(socket);


            InputStream in = new BufferedInputStream(
                    socket.getInputStream()
            );
            byte[] buffer = new byte[1024];

//            InputStreamReader r = new InputStreamReader(socket.getInputStream());
//            BufferedReader br = new BufferedReader(r);
//            String readLine = br.readLine();
//            while (readLine != null && !readLine.equals("")) {
//                System.out.println("获取到数据：" + readLine);
//                readLine = br.readLine();
//            }
            StringBuilder sb = new StringBuilder();
            while (true){
                int len = in.read(buffer);
                System.out.println(len);
                if (len == -1){
                    break;
                }
                sb.append(new String(buffer,0,len));
            }
            System.out.println(sb);

            String html = "http/1.1 200 ok\n\n"
                    + "\r\n"
                    + "1234111";
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println(html);
            pw.close();
        }
    }

}
