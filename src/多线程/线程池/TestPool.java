package 多线程.线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * created on 2018/11/26.
 *
 * @author J
 **/
public class TestPool {


    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 7, 1, TimeUnit.HOURS
                , new ArrayBlockingQueue<>(20));
//        String[] seArray = {"1", "2"};
        String[] seArray = new String[20];
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
            if (ClickTask.getCounter() == len) {
                System.out.println("ok");
                break;
            }
        }
    }
}
