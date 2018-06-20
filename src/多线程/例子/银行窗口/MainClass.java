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
        int len = 10;
        for (int i = 0; i < len; i++) {
            Consumer consumer = new Consumer("客户" + i, random.nextInt(2) == 0);
            if (i == 0 || i == len - 1) {
                consumer.setVip(true);
            }
            System.out.println(consumer);
            consumerQueue.inQueue(consumer);
        }

        Window vipWwindow = new Window("vip窗口", true, consumerQueue);
        Thread vip = new Thread(vipWwindow);
        vip.setName("vip窗口");

        Window window1 = new Window("窗口1", false, consumerQueue);
        Thread thread1 = new Thread(window1);
        thread1.setName("窗口1");

        Window window2 = new Window("窗口2", false, consumerQueue);
        Thread thread2 = new Thread(window2);
        thread2.setName("窗口2");

        Window window3 = new Window("窗口3", false, consumerQueue);
        Thread thread3 = new Thread(window3);
        thread3.setName("窗口3");

        vip.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}