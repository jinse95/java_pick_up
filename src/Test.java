import java.io.UnsupportedEncodingException;

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
        System.out.println(new Test().member.name);
        Object a = 1;
    }
}

