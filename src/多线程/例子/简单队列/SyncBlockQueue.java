package 多线程.例子.简单队列;

/**
 * @Description
 * @Author J
 * @Date 2018/8/30 17:37
 **/
public class SyncBlockQueue {

    Object[] objectArray = new Object[10];

    int takeIndex;

    int putIndex;

    int count;

    /**
     * 入队
     */
    public synchronized void put(Object o) {
        while (count == objectArray.length) {
            System.out.println("满了");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        objectArray[putIndex] = o;
        putIndex = (putIndex + 1) % 10;
        count++;
        this.notify();
    }

    /**
     * 出队
     */
    public synchronized Object take() {
        while (count == 0) {
            System.out.println("空了");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object o = objectArray[takeIndex];
        objectArray[takeIndex] = null;
        takeIndex = (takeIndex + 1) % 10;
        count--;
        this.notify();
        return o;
    }
}