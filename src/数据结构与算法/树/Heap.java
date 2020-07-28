package 数据结构与算法.树;

import utils.BaseUtils;

/**
 * 堆
 *
 * @author J
 */
public class Heap {

    private int[] datas;
    private int capacity = 0;
    private int size = 0;

    public Heap(int capacity) {

        if (capacity < 0) {
            throw new IllegalArgumentException("");
        }

        this.datas = new int[capacity + 1];
        this.capacity = capacity;
    }

    public boolean insert(int n) {
        if (size >= capacity) {
            return false;
        }
        size++;
        datas[size] = n;
        int i = size;
        while (i / 2 > 0 && datas[i] > datas[i / 2]) {
            BaseUtils.swap(datas, i, i / 2);
            i = i / 2;
        }
        
        return true;
    }

    private void heapify() {

    }
}
