package 多线程.继承Runable;

/**
 * @Description
 * @Author J
 * @Date 2018/5/21 15:15
 **/
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("线程号 - " + Thread.currentThread().getId() + "   " + Thread.currentThread().getName());
    }
}
