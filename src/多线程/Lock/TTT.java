package 多线程.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @author J
 * @Date 2018/8/28 15:40
 **/
public class TTT {
    public static void main(String[] args) {

        Thread i0 = new Thread(new RunIt3());
        Thread i1 = new Thread(new RunIt3());
        i0.start();
        i1.start();

    }

}

class RunIt3 implements Runnable {

    private static Lock lock = new ReentrantLock();

    public void run() {
        try {
            //---------------------------------a
            System.out.println("state0: " + Thread.currentThread().getState());
            lock.lock();
//            lock.lockInterruptibly();

            System.out.println("state1: " + Thread.currentThread().getState());
            System.out.println(Thread.currentThread().getName() + " running");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName() + " finished");
            lock.unlock();
        } catch (InterruptedException e) {
            System.out.println("Exstate: " + Thread.currentThread().getState());

            System.out.println(Thread.currentThread().getName() + " interrupted");

        }

    }
}