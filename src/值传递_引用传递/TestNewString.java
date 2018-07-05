package 值传递_引用传递;

/**
 * @author J
 * @time 2018/3/11 23:27
 * @description
 **/
public class TestNewString {
    public static void main(String[] args) {

        String str = new String("hello");
        StringBuilder sb = new StringBuilder("hello");
        String after_str = new String("hello");

        System.out.println(str + after_str);

    }
}
