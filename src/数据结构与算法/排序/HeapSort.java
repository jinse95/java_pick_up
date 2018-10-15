package 数据结构与算法.排序;

import utils.BaseUtils;

import java.util.Arrays;

/**
 * @author J
 * @time 2018/10/7 14:44
 * @description 堆排序
 **/
public class HeapSort {
    public static void heapSort(int[] array) {
        int len = array.length;
        for (int i = len / 2; i >= 0; i--) {
            heapAdjust(array, i, len);
        }

        for (int i = len - 1; i > 0; i--) {
            BaseUtils.swap(array, i, 0);
            heapAdjust(array, 0, i - 1);
        }
    }

    /**
     * 调整大顶堆
     * @param array
     * @param start
     * @param end
     */
    public static void heapAdjust(int[] array, int start, int end) {
        //父节点
        int parent = array[start];

        // 将i初始化为 start 的子节点
        for (int i = start * 2 + 1; i < end; i = i * 2 + 1) {
            //存在左右子节点 且 右 > 左
            if (i + 1 < end && array[i] < array[i + 1]) {
                i++;
            }

            //父节点大于子节点
            if (parent >= array[i]) {
                break;
            }

            //子节点上浮
            array[start] = array[i];
            start = i;
        }
        //父节点下沉
        array[start] = parent;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{12, 33, 4, 5, 6, 3, 53, 7, 893, 893, 22, 66, 88, 22, 457, 3};
        heapSort(ar);
        System.out.println(Arrays.toString(ar));
    }
}

