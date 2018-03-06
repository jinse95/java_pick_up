package 数据结构与算法.排序;

import java.util.ArrayList;
import java.util.List;

/**
 * @author J
 * @time 2018/3/5 23:08
 * @description 快速排序
 **/
public class QuickSort {

    @SuppressWarnings("unchecked")
    public static int partition(List<? extends Comparable> list, Integer low, Integer high) {
        Comparable key = list.get(low);
        while (low < high) {

            while (low < high && list.get(high).compareTo(key) >= 0) {
                high--;
            }
            swapList(list, low, high);
            while (low < high && list.get(low).compareTo(key) <= 0) {
                low++;
            }
            swapList(list, low, high);
        }
        return low;
    }

    @SuppressWarnings("unchecked")
    public static void swapList(List list, Integer i, Integer j) {
        Object tempKey = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tempKey);
    }

    public static void quickSort(List<? extends Comparable> list, Integer low, Integer high) {
        if (low < high) {
            int middle = partition(list, low, high);
            quickSort(list, low, middle - 1);
            quickSort(list, middle + 1, high);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(89);
        list.add(1);

        quickSort(list, 0, list.size() - 1);

        System.out.println(list);
    }
}

