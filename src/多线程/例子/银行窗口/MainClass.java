package 多线程.例子.银行窗口;

import java.util.Random;

/**
 * @Description
 * @Author J
 * @Date 2018/6/19 16:51
 **/
public class MainClass {
    public static void main(String[] args) {
        ConsumerQueue consumerQueue = new ConsumerQueue();
        Random random = new Random();
        int len = 30;
        for (int i = 0; i < len; i++) {
            Consumer consumer = new Consumer("客户" + i, random.nextInt(2) == 0);
//            if (i == 0 || i == len - 1) {
//                consumer.setVip(true);
//            }
            System.out.println(consumer);
            consumerQueue.inQueue(consumer);
        }

        Window vipWindow1 = new Window("vip窗口1", true, consumerQueue);
        Thread vip1 = new Thread(vipWindow1);
        vip1.setName("vip窗口1");

        Window vipWindow2 = new Window("vip窗口2", true, consumerQueue);
        Thread vip2 = new Thread(vipWindow2);
        vip2.setName("vip窗口2");

        Window window1 = new Window("窗口1", false, consumerQueue);
        Thread thread1 = new Thread(window1);
        thread1.setName("窗口1");

        Window window2 = new Window("窗口2", false, consumerQueue);
        Thread thread2 = new Thread(window2);
        thread2.setName("窗口2");

        Window window3 = new Window("窗口3", false, consumerQueue);
        Thread thread3 = new Thread(window3);
        thread3.setName("窗口3");

        Window window4 = new Window("窗口4", false, consumerQueue);
        Thread thread4 = new Thread(window4);
        thread4.setName("窗口4");

        Window window5 = new Window("窗口5", false, consumerQueue);
        Thread thread5 = new Thread(window5);
        thread5.setName("窗口5");

        vip1.start();
        vip2.start();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}