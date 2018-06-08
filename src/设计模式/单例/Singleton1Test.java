package 设计模式.单例;

/**
 * @Description
 * @Author J
 * @Date 2018/6/7 17:56
 **/
public class Singleton1Test {
    public static void main(String[] args) {
        System.out.println("main");
        System.out.println(Singleton1.FLAG);
        System.out.println("----------");
        Singleton1.getSingleton();
    }
}
