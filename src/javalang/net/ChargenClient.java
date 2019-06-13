package javalang.net;

import java.nio.*;
import java.nio.channels.*;
import java.net.*;
import java.io.IOException;

public class ChargenClient {
    
  public static int DEFAULT_PORT = 19;

  public static String LOCAL = "127.0.0.1";
  
  public static void main(String[] args) {

    int port;
    try {
      port = Integer.parseInt(args[1]);
    } catch (RuntimeException ex) {
      port = DEFAULT_PORT;   
    }
    
    try {
      SocketAddress address = new InetSocketAddress(LOCAL, port);
      SocketChannel client = SocketChannel.open(address);
      
      ByteBuffer buffer = ByteBuffer.allocate(74);
      WritableByteChannel out = Channels.newChannel(System.out);
      
      while (client.read(buffer) != -1) {
        buffer.flip();
        out.write(buffer);
        buffer.clear();
      }     
    } catch (IOException ex) {
      ex.printStackTrace();   
    }
  }
}