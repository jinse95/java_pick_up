import 设计模式.单例.Singleton1;

/**
 * @Description
 * @Author J
 * @Date 2018/8/30 10:25
 **/
public class temp {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(temp.class.getClassLoader().getClass().getName());
    }
}
