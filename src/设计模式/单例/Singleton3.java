package 设计模式.单例;

/**
 * @Description 同时拥有前两种方式的优点。
 * 首先getInstance()方法中没有锁，这使得在高并发环境下性能优越。
 * 其次，只有在getInstance()方法被第一次调用时，StaticSingleton的实例才会被创建。
 * 因为这种方法巧妙地使用了内部类和类的初始化方式。内部类SingletonHolder被申明为private，这使得我们不可能在外部访问并初始化它。
 * 而我们只可能在getInstance()内部对SingletonHolder类进行初始化，利用虚拟机的类初始化机制创建单例
 * @Author J
 * @Date 2018/6/8 10:35
 **/
public class Singleton3 {
    private Singleton3() {
        System.out.println("创建实例");
    }

    public static Singleton3 getSingleton() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static Singleton3 instance = new Singleton3();
    }
}
