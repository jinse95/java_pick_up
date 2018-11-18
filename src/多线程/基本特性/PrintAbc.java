package 多线程.基本特性;

/**
 * @Description 交替打印ABC
 * @author J
 * @Date 2018/5/28 10:36
 **/
public class PrintAbc {
    static class Print implements Runnable {

        private String name;
        private String pre;

        public Print(String name, String pre) {
            this.name = name;
            this.pre = pre;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                //先获取前一个的锁
                synchronized (pre) {
                    //在获取自身的锁
                    synchronized (name) {
                        System.out.println(name);
                        count--;
                        //唤醒等待队列中的线程竞争
                        name.notifyAll();
                    }
                    /**
                     * name 的锁代码块结束 释放name的锁
                     */

                    try {
                        if (count == 0) {
                            // 如果count==0,表示这是最后一次打印操作，通过notifyAll操作释放对象锁。
                            pre.notifyAll();
                        } else {
                            // 立即释放prev锁，当前线程休眠，等待唤醒
                            pre.wait();
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

        Runnable ra = new Print(a, c);
        Runnable rb = new Print(b, a);
        Runnable rc = new Print(c, b);

        Thread ta = new Thread(ra);
        Thread tb = new Thread(rb);
        Thread tc = new Thread(rc);

        ta.start();
        // 保证初始ABC的启动顺序
        Thread.sleep(10);
        tb.start();
        Thread.sleep(10);
        tc.start();
        Thread.sleep(10);
    }

}
