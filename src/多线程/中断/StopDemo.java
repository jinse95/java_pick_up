
package 多线程.中断;


public class StopDemo {
        // 线程终止标志位
        volatile boolean terminated = false;
        boolean started = false;
        // 采集线程
        Thread rptThread;
        // 启动采集功能
        synchronized void start(){
            // 不允许同时启动多个采集线程
            if (started) {
                return;
            }
            started = true;
            terminated = false;
            rptThread = new Thread(()->{
                while (!terminated){
                    // 省略采集、回传实现
                    System.out.println("回传数据");
                    // 每隔两秒钟采集、回传一次数据
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e){
                        System.out.println("中断了");
                        // 重新设置线程中断状态
                        Thread.currentThread().interrupt();
                    }
                    System.out.println();
                }
                // 执行到此处说明线程马上终止
                started = false;
            });

            rptThread.start();
        }
        // 终止采集功能
        synchronized void stop(){
            // 设置中断标志位
            terminated = true;
            // 中断线程 rptThread
            rptThread.interrupt();
        }

    public static void main(String[] args) throws InterruptedException {
        StopDemo stopDemo =  new StopDemo();
        stopDemo.start();

        Thread.sleep(800);
        stopDemo.stop();
    }
}
