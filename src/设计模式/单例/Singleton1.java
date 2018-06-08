package 设计模式.单例;

/**
 * @Description 该单例模式实例在类初始化的时候被创建
 * @Author J
 * @Date 2018/6/7 17:54
 **/
public class Singleton1 {

    private static Singleton1 singleton = new Singleton1();

    public static int FLAG = 1;

    private Singleton1(){
        System.out.println("创建实例");
    }

    public static Singleton1 getSingleton() {
        return singleton;
    }
}
