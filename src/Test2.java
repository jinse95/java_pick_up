import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author J
 */
public class Test2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, "1", "2", "3");
        System.out.println(stringList);
        test(stringList);
        System.out.println(stringList);
    }

    public static void test(List<String> stringList){
        stringList.clear();
    }
}
