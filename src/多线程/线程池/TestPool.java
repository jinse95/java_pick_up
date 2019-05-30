package 多线程.线程池;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * created on 2018/11/26.
 *
 * @author J
 **/
public class TestPool {


    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 7,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build(),
                new ThreadPoolExecutor.AbortPolicy()
        );
//        String[] seArray = {"1", "2"};
        String[] seArray = new String[3];
        int len = seArray.length;
//        for (String seItem : seArray) {
//            ClickTask clickTask = new ClickTask(seItem);
//            executor.execute(clickTask);
//        }
        try {
            for (int i = 0; i < len; i++) {
                ClickTask clickTask = new ClickTask(String.valueOf(i));
                executor.execute(clickTask);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        while (true) {
            Thread.sleep(1000L);
            if (ClickTask.getCounter() == len) {
                System.out.println("ok");
                break;
            } /*else {
                System.out.println("wait ok");
            }*/
        }
        executor.shutdown();
        System.out.println("finish");
    }
}
