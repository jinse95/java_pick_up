package 多线程.继承Runable;

/**
 * @Description
 * @author J
 * @Date 2018/5/21 15:15
 **/
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("线程号 - " + Thread.currentThread().getId() + "开始");
            synchronized (this){
                System.out.println("线程号 - " + Thread.currentThread().getId() + "锁住");
                Thread.sleep(10000L);
                System.out.println("线程号 - " + Thread.currentThread().getId() + "   " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            System.out.println("线程号 - " + Thread.currentThread().getId() + "异常");
        }

    }
}
