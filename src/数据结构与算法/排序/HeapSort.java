package 数据结构与算法.排序;

import java.util.Arrays;

/**
 * @author J
 * @time 2018/10/7 14:44
 * @description 堆排序
 **/
public class HeapSort {
    public static void heapSort(int[] array) {
        int len = array.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapAdjust(array, i, len);
        }

        for (int i = len - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            heapAdjust(array, 0, i - 1);
        }
    }

    public static void heapAdjust(int[] array, int start, int end) {
        int rc = array[start];
        for (int i = start * 2 + 1; i < end; i = i * 2 + 1) {
            if (i + 1 < end && array[i] < array[i + 1]) {
                i++;
            }
            if (rc >= array[i]) {
                break;
            }

            array[start] = array[i];
            start = i;
        }
        array[start] = rc;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{12, 33, 4, 5, 6, 3, 53, 7, 893, 893, 22, 66, 88, 22, 457, 3};
        heapSort(ar);
        System.out.println(Arrays.toString(ar));
    }
}
