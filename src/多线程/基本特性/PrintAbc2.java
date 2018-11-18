package 多线程.基本特性;

/**
 * @Description 交替打印ABC
 * @author J
 * @Date 2018/5/28 10:36
 **/
public class PrintAbc2 {
    static class Print implements Runnable {

        private String name;
        private String next;

        public Print(String name, String next) {
            this.name = name;
            this.next = next;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                //先获自身的锁
                synchronized (name) {
                    //再获取下一个的锁
                    synchronized (next) {
                        System.out.println(name);
                        count--;
                        //唤醒等待队列中的线程竞争
                        next.notifyAll();
                    }
                    /**
                     * next 的锁代码块结束 释放next的锁
                     */

                    try {
                        if (count == 0) {
                            // 如果count==0,表示这是最后一次打印操作，通过notifyAll操作释放对象锁。
                            name.notifyAll();
                        } else {
                            // 立即释放name锁，当前线程休眠，等待唤醒
                            name.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String a = "A";
        String b = "B";
        String c = "C";

        Runnable ra = new Print(a, b);
        Runnable rb = new Print(b, c);
        Runnable rc = new Print(c, a);

        Thread ta = new Thread(ra);
        Thread tb = new Thread(rb);
        Thread tc = new Thread(rc);

        ta.start();
        // 保证初始ABC的启动顺序
        Thread.sleep(100);
        tb.start();
        Thread.sleep(100);
        tc.start();
        Thread.sleep(100);
    }

}
