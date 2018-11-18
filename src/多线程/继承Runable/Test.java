package 多线程.继承Runable;

/**
 * @Description
 * @author J
 * @Date 2018/5/22 11:30
 **/
public class Test {
    public static void main(String[] args) {
        Ticket one = new Ticket();
//        Ticket two = new Ticket();
        new Thread(one).start();
        new Thread(one).start();
        new Thread(one).start();
        new Thread(one).start();
        new Thread(one).start();

    }
}
class Ticket implements Runnable{
    private int ticket = 1000;
    @Override
    public void run() {
        boolean flag = true;
        while(flag){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+"窗口卖票..."+ ticket--);
            } else {
                flag = false;
            }
        }
    }
}