package 多线程.继承Runable;

/**
 * @Description
 * @author J
 * @Date 2018/5/21 15:20
 **/
public class MainClass {
    public static void main(String[] args) {
        System.out.println("主线程号 - " + Thread.currentThread().getId() + "   " + Thread.currentThread().getName());
        System.out.println("-----------------------------------");

        RunnableImpl runnable = new RunnableImpl();
        Thread thread = new Thread(runnable);
        thread.setName("aaa");
        Thread thread2 = new Thread(runnable);
        thread.setName("bbb");
        Thread thread3 = new Thread(runnable);
        thread.setName("ccc");

        thread.start();
        thread2.start();
        thread2.interrupt();
        thread3.start();

    }
}
