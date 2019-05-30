import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
//        String formatPattern = "yyyyMMdd";
//        Date date = new Date();
//        String dateStr = DateFormatUtils.format(date, formatPattern);
//        try {
//            date = DateUtils.parseDate(dateStr, new String[]{formatPattern});
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(DateUtils.addDays(date, 30));


        String contentStr = "nihaonullnull";


        System.out.println(contentStr.replace("null",""));
    }
}
