package 数据结构与算法.线性表;

/**
 * 数组队列 循环
 *
 * @author J
 */
public class ArrayQueue {

    private String[] queue;
    private int capacity;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new String[capacity];
    }

    public boolean enQueue(String str) {
        if (this.isFull()) {
            return false;
        }

        queue[tail] = str;
        tail = (tail + 1) % capacity;
        return true;
    }

    public String deQueue() {
        if (isEmpty()) {
            return null;
        }

        String result = queue[head];
        queue[head] = null;
        head = (head + 1) % capacity;
        return result;
    }

    public boolean isFull() {
        return this.head + this.tail == this.capacity;
    }

    public boolean isEmpty() {
        return this.tail == this.head;
    }

}
