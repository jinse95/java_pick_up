import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;

/**
 * @author J
 **/
public class Test {
    /**
     * key
     */
    public static final int KEY = 1;

    public static void main(String[] args) throws UnsupportedEncodingException {
        String newData = "The new String is writing in a file ..." + System.currentTimeMillis();
        ByteBuffer bb = ByteBuffer.allocate(48);
        bb.clear();
        bb.put(newData.getBytes());
        bb.flip();
    }
}
