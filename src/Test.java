import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author J
 **/
public class Test {



    String name = "name";
    public Test member;
    /**
     * key
     */
    public static final int KEY = 1;

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(new Test().member.name);
    }
}
