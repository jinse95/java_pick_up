package javalang.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingleFileHTTPServer {

    private static final Logger logger = Logger.getLogger("SingleFileHTTPServer");

    private final byte[] content;
    private final byte[] header;
    private final int port;
    private final String encoding;

    public SingleFileHTTPServer(String data, String encoding,
                                String mimeType, int port) throws UnsupportedEncodingException {
        this(data.getBytes(encoding), encoding, mimeType, port);
    }

    public SingleFileHTTPServer(
            byte[] data, String encoding, String mimeType, int port) {
        this.content = data;
        this.port = port;
        this.encoding = encoding;
        String header = "HTTP/1.0 200 OK\r\n"
                + "Server: OneFile 2.0\r\n"
                + "Content-length: " + this.content.length + "\r\n"
                + "Content-type: " + mimeType + "; charset=" + encoding + "\r\n\r\n";
//    header = "\r\n\r\n";
        this.header = header.getBytes(Charset.forName("UTF-8"));
    }

    public void start() {
        ExecutorService pool = Executors.newFixedThreadPool(100);
        try (ServerSocket server = new ServerSocket(this.port)) {
            logger.info("Accepting connections on port " + server.getLocalPort());
            logger.info("Data to be sent:");
            logger.info(new String(this.content, encoding));

            while (true) {
                try {
                    Socket connection = server.accept();
                    System.out.println("一个新的连接");
                    pool.submit(new HTTPHandler(connection));
                } catch (IOException ex) {
                    logger.log(Level.WARNING, "Exception accepting connection", ex);
                } catch (RuntimeException ex) {
                    logger.log(Level.SEVERE, "Unexpected error", ex);
                }
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not start server", ex);
        }
    }

    private class HTTPHandler implements Callable<Void> {
        private final Socket connection;

        HTTPHandler(Socket connection) {
            this.connection = connection;
        }

        @Override
        public Void call() throws IOException {
            try {
                OutputStream out = new BufferedOutputStream(
                        connection.getOutputStream()
                );
                InputStream in = new BufferedInputStream(
                        connection.getInputStream()
                );

                // read the first line only; that's all we need
                StringBuilder request = new StringBuilder(10000);
                System.out.println(Thread.currentThread().getName() + "call");
                byte[] buffer = new byte[128];
                int index;
                String twoLine = System.lineSeparator() + System.lineSeparator();
                while (true) {
                    int c = in.read(buffer);
                    System.out.println(Thread.currentThread().getName() + "___________" + c);
                    request.append(new String(buffer, 0, c));

                    //todo break条件判断优化
                    int tempIndex = request.indexOf(twoLine);
                    if (tempIndex > -1) {
                        index = tempIndex;
                        break;
                    }
                }

                System.out.println(Thread.currentThread().getName() + "_request read_");

                String[] lines = request.toString().substring(0, index).split(System.lineSeparator());
                for (String line : lines) {
                    System.out.println(line);
                }

                // If this is HTTP/1.0 or later send a MIME header
                if (request.toString().indexOf("HTTP/") != -1) {
                    out.write(header);
                    out.write(content);
                } else {
                    out.write(1);
                }
                out.flush();
                System.out.println(Thread.currentThread().getName() + "_flush_" + out);

            } catch (IOException ex) {
                logger.log(Level.WARNING, "Error writing to client", ex);
            } finally {
                connection.close();
                System.out.println(Thread.currentThread().getName() + "_close_" + connection.toString());
            }
            return null;
        }
    }

    public static void main(String[] args) {

        // set the port to listen on
        int port;
        try {
            port = Integer.parseInt(args[1]);
            if (port < 1 || port > 65535) {
                port = 800;
            }
        } catch (RuntimeException ex) {
            port = 800;
        }

        String encoding = "UTF-8";
        if (args.length > 2) {
            encoding = args[2];
        }

        try {
            String fileName = "test.html";
            Path path = Paths.get(fileName);
            byte[] data = Files.readAllBytes(path);

            String contentType = URLConnection.getFileNameMap().getContentTypeFor(fileName);
            SingleFileHTTPServer server = new SingleFileHTTPServer(data, encoding,
                    contentType, port);
            server.start();

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(
                    "Usage: java SingleFileHTTPServer filename port encoding");
        } catch (IOException ex) {
            logger.severe(ex.getMessage());
        }
    }
}