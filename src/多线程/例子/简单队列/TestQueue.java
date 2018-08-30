package 多线程.例子.简单队列;

import java.util.Random;

/**
 * @Description
 * @Author J
 * @Date 2018/8/30 17:38
 **/
public class TestQueue {

    public static void main(String[] args) {
        SyncBlockQueue queue = new SyncBlockQueue();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 15; i++) {
                    int ProdRandom = random.nextInt(100);
                    System.out.println("put:  " + ProdRandom);
                    queue.put(ProdRandom);
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("take:   " + queue.take());
                }
            }
        });

        producer.start();
        consumer.start();

    }


}
