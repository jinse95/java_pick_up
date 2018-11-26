package 多线程.线程池;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * created on 2018/11/26.
 *
 * @author J
 **/
public class ClickTask implements Runnable {

    private static AtomicInteger counter = new AtomicInteger(0);

    private String se;

    public ClickTask(String se) {
        this.se = se;
    }

    @Override
    public void run() {
        if ("1".equals(se)) {
            this.clickSe1();
        } else if ("2".equals(se)) {
            this.clickSe2();
        } else {
            clickSe();
        }
        counter.getAndIncrement();
    }

    public void clickSe1() {
        synchronized (ClickTask.class) {
            System.out.println("se1  step1");
        }
        this.sleepS(5);
        synchronized (ClickTask.class) {
            System.out.println("se1  step2");
        }
    }

    public void clickSe2() {
        synchronized (ClickTask.class) {
            System.out.println("se2  step1");
        }

        this.sleepS(5);

        synchronized (ClickTask.class) {
            System.out.println("se2  step2");
        }
    }


    public void clickSe() {
        synchronized (ClickTask.class) {
            System.out.println("se" + se + "  step1");
        }

        this.sleepS(3);

        synchronized (ClickTask.class) {
            System.out.println("se" + se + "  step2");
        }
    }


    private void sleepS(int s) {
        try {
            Thread.sleep(s * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static int getCounter() {
        return counter.get();
    }
}
