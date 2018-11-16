package javalang.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @Author J
 * @Date 2018/11/16 13:50
 * @Description
 **/
public class ChannelDemo {
    public static void main(String args[]) throws IOException {
        String relativelyPath = System.getProperty("user.dir");
        System.out.println(relativelyPath);

        long start = System.currentTimeMillis();
        FileInputStream input = new FileInputStream(relativelyPath + "/testin.txt");
        FileOutputStream output = new FileOutputStream(relativelyPath + "/testout-n.txt");
//        ReadableByteChannel source = input.getChannel();
//        WritableByteChannel destination = output.getChannel();
//        copyData(source, destination);

        copyData(input.getChannel(), output.getChannel());
        output.close();
        input.close();
        System.out.println("NIO 花费: " + (System.currentTimeMillis() - start));
        System.out.println("NIO Copy Data finished.");


        start = System.currentTimeMillis();
        FileInputStream input1 = new FileInputStream(relativelyPath + "/testin.txt");
        FileOutputStream output1 = new FileOutputStream(relativelyPath + "/testout.txt");
        copyData(input1, output1);
        output1.close();
        input1.close();
        System.out.println("IO 花费: " + (System.currentTimeMillis() - start));
        System.out.println("IO Copy Data finished.");

    }

    private static void copyData(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 10);
        while (src.read(buffer) != -1) {
            // The buffer is used to drained
            buffer.flip();
            // keep sure that buffer was fully drained
            while (buffer.hasRemaining()) {
                dest.write(buffer);
            }
            buffer.clear(); // Now the buffer is empty, ready for the filling
        }
        src.close();
        dest.close();
    }

    private static void copyData(FileChannel src, FileChannel dest) throws IOException {
        long size = src.size();
        src.transferTo(0, size, dest);
        src.close();
        dest.close();
    }


    private static void copyData(FileInputStream src, FileOutputStream dest) throws IOException {
        byte[] buf = new byte[1024 * 10];
        int len = 0;
        while ((len = src.read(buf)) != -1) {
            dest.write(buf, 0, len);
        }
    }
}
