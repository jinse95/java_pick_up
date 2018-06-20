package 多线程.例子.银行窗口;

/**
 * @Description
 * @Author J
 * @Date 2018/6/19 15:13
 **/
public class Window implements Runnable {

    String name;
    boolean isVip;
    ConsumerQueue consumerQueue;
    boolean working = true;

    public Window(String name, boolean isVip, ConsumerQueue consumerQueue) {
        this.name = name;
        this.isVip = isVip;
        this.consumerQueue = consumerQueue;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }


    @Override
    public void run() {
        while (working) {
            if (this.isVip) {
//                System.out.println("vip窗口: " + this.name + "空闲中");
            } else {
                System.out.println(this.name + "空闲中");
            }

            this.dealBiz();

            if (consumerQueue.isEmpty()) {
                working = false;
            }
        }
    }

    /**
     * 模拟业务处理
     */
    private void dealBiz() {
        try {
//            System.out.println("正在分配窗口.......");
            if (this.isVip) {
                Consumer consumer = consumerQueue.outVip();
                if (consumer == null) {
                    return;
                }
                System.out.println(this.name + "处理中, 当前vip客户: " + consumer.getName());
            } else {
                Consumer consumer = consumerQueue.outQueue();
                if (consumer == null) {
                    return;
                }
                if (consumer.isVip) {
                    System.out.println(this.name + "处理中,当前vip客户: " + consumer.getName());
                } else {
                    System.out.println(this.name + "处理中,当前客户: " + consumer.getName());
                }
            }

            Thread.sleep(2000L);

            if (this.isVip) {
                System.out.println(this.name + "处理完成");
            } else {
                System.out.println(this.name + "处理完成");
            }
//            this.consumerQueue.printQueue();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
