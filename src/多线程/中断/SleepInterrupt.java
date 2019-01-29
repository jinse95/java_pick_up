package 多线程.中断;

/**
 * created on 2019/1/29.
 *
 * @author J
 **/
class SleepClass extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("running");
            this.interrupt();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("=================");
            }
        }
    }
}

public class SleepInterrupt {

    public static void main(String[] args) {
        SleepClass sleepClass = new SleepClass();
        sleepClass.start();
    }
}
