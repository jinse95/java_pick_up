package 多线程.基本特性;

/**
 * @Description
 * @Author J
 * @Date 2018/8/31 15:02
 **/
public class JoinTest {
    public static void main(String[] args) {
        Object oo = new Object();
        MyThread t1 = new MyThread("线程t1--", oo);
//        MyThread t2 = new MyThread("线程t2--", oo);
//        t2.start();
        t1.start();
        try {
            System.out.println(Thread.currentThread().getName());
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束啦------------------------------");
    }

}

class MyThread extends Thread{
    private String name;
    private Object oo;
    public MyThread(String name,Object oo){
        this.name = name;
        this.oo = oo;
    }
    @Override
    public void run() {
        synchronized (oo) {
            for(int i = 0; i < 20; i++){
                System.out.println(name + i);
            }
        }
    }
}
