package 多线程.线程池;

/**
 * created on 2018/11/26.
 *
 * @author J
 **/
public class TestNew {

    public static void main(String[] args) {
        ClickTask clickTask1 = new ClickTask("1");
        ClickTask clickTask2 = new ClickTask("2");

        Thread thread1 = new Thread(clickTask1);
        Thread thread2 = new Thread(clickTask2);

        thread1.start();
        thread2.start();
    }
}
