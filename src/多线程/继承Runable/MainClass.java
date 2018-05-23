package 多线程.继承Runable;

/**
 * @Description
 * @Author J
 * @Date 2018/5/21 15:20
 **/
public class MainClass {
    public static void main(String[] args) {
        System.out.println("主线程号 - " + Thread.currentThread().getId() + "   " + Thread.currentThread().getName());
        System.out.println("-----------------------------------");

        RunnableImpl runnable = new RunnableImpl();
        Thread thread = new Thread(runnable);
        thread.setName("aaa");
        thread.start();
    }
}
