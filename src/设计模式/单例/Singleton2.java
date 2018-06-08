package 设计模式.单例;

/**
 * @Description 该单例实现在第一次调用实例的时候初始化,
 * 但为了保证线程安全getSingleton 需用 synchronized修饰
 * @Author J
 * @Date 2018/6/8 10:13
 **/
public class Singleton2 {
    private static Singleton2 singleton = null;


    private Singleton2() {
        System.out.println("创建实例");
    }


    public static synchronized Singleton2 getSingleton() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
