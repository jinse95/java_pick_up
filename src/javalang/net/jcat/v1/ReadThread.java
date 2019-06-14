package javalang.net.jcat.v1;

import javalang.net.jcat.HttpRequest;
import javalang.net.jcat.HttpResponse;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author J
 * @since
 */
public class ReadThread implements Runnable {

    public ReadThread(SocketChannel channel, Selector selector) {
        this.channel = channel;
        this.selector = selector;
    }

    private SocketChannel channel;

    private Selector selector;

    private HttpRequest request;

    private HttpResponse response;

    @Override
    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        try {
            while (buffer.hasRemaining() && (channel.read(buffer)) != -1) {
                buffer.flip();
                byte getByte;
                while (buffer.hasRemaining()){
                    getByte =  buffer.get();

                }

                buffer.clear();
            }
        } catch (IOException e) {

        }
    }
}
