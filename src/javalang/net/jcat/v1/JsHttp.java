package javalang.net.jcat.v1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author J
 */
public class JsHttp {


    private final static Logger logger = LoggerFactory.getLogger(JsHttp.class);

    public static int PORT = 8080;

    public static void main(String[] args) {
        ServerSocketChannel serverChannel = null;
        Selector selector = null;
        try {
            serverChannel = ServerSocketChannel.open();
            ServerSocket ss = serverChannel.socket();
            InetSocketAddress address = new InetSocketAddress(PORT);
            ss.bind(address);
            serverChannel.configureBlocking(false);
            selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_READ);
        } catch (IOException ex) {
            logger.error("启动失败", ex);
            if (selector != null && selector.isOpen()) {
                try {
                    selector.close();
                } catch (IOException e) {
                    logger.error("启动失败-关闭select失败", e);
                }
            }

            if (serverChannel != null && serverChannel.isOpen()) {
                try {
                    serverChannel.close();
                } catch (IOException e) {
                    logger.error("启动失败-关闭serverChannel失败", e);
                }
            }
            return;
        }


        logger.info("monitor start: {}", PORT);

        while (true) {
            try {
                selector.select();
            } catch (IOException ex) {
                ex.printStackTrace();
                break;
            }

            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                try {
                    if (key.isReadable()) {

                    } else if (key.isWritable()) {
                        throw new IOException();
                    }
                } catch (IOException ex) {
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException closeChanelEx) {
                        logger.error("关闭通道异常", closeChanelEx);
                    }
                } finally {
                    iterator.remove();
                }
            }
        }

    }

}
