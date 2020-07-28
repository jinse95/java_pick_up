package 数据结构与算法.排序;

import java.util.Stack;

/**
 * @author J
 * @time 2018/10/6 20:13
 * @description 非递归实现
 **/
public class QuickSortArray2 {
    public static int partition(int[] array, int low, int high) {
        int key = array[low];
        while (low < high) {
            while (low < high && array[high] >= key) {
                high--;
            }
            array[low] = array[high];

            while (low < high && array[low] <= key) {
                low++;
            }
            array[high] = array[low];
        }
        //此时low = high
        array[low] = key;
        return low;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        Stack<int[]> stack = new Stack<>();
        int middle = partition(array, low, high);
        if (middle - 1 > low) {
            stack.push(new int[]{low, middle - 1});
        }
        if (middle + 1 < high) {
            stack.push(new int[]{middle + 1, high});
        }
        while (!stack.isEmpty()) {
            int[] item = stack.pop();
            middle = partition(array, item[0], item[1]);
            if (middle - 1 > item[0]) {
                stack.push(new int[]{item[0], middle - 1});
            }
            if (middle + 1 < item[1]) {
                stack.push(new int[]{middle + 1, item[1]});
            }
        }
    }


    public static void main(String[] args) {
        int[] ar = new int[]{12, 33, 4, 5, 6, 3, 53, 7, 893, 22, 66, 88, 22, 457};
        quickSort(ar, 0, ar.length - 1);
        for (int i : ar) {
            System.out.println(i);
        }
    }
}
