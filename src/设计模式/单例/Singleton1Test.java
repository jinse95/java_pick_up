package 设计模式.单例;

/**
 * @Description
 * @author J
 * @Date 2018/6/7 17:56
 **/
public class Singleton1Test {
    static {
        //给变量赋值可以正常编译通过
        i = 0;
        //这句编译器会提示"非法向前引用"
        //System.out.println(i);
    }

    static int i = 1;

    public static void main(String[] args) {
        System.out.println("main");
        System.out.println(Singleton1.FLAG);
        System.out.println("----------");
        Singleton1.getSingleton();
    }
}
