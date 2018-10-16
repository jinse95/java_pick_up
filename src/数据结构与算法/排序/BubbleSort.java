package 数据结构与算法.排序;

import utils.BaseUtils;

import java.util.Arrays;

/**
 * @Description 冒泡排序
 * @Author J
 * @Date 2018/10/16 13:04
 **/
public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    BaseUtils.swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{12, 33, 4, 5, 6, 3, 53, 7, 893, 893, 22, 66, 88, 22, 457, 3})));
    }
}
