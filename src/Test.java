import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;

/**
 * @author J
 **/
@Slf4j
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
        try {
            fun1();
        } catch (Throwable e) {
            //sl4j + logback
            //打印 StackTrace
            log.error("你好1，{}和{}, :", "aaa", "1111", e);
            //打印 StackTrace，但是最后一个占位符是多余的
            log.error("你好2，{}和{}, : {}", "aaa", "2222", e);
            //不打印 StackTrace
            log.error("你好3，{}和{}, :", "aaa", e, "3333");
        }
    }

    public static int fun1() {
        return fun1();
    }
}

