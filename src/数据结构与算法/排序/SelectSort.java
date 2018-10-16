package 数据结构与算法.排序;

import utils.BaseUtils;

import java.util.Arrays;

/**
 * @Description 选择排序
 * @Author J
 * @Date 2018/10/16 13:08
 **/
public class SelectSort {
    public static int[] selectSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                BaseUtils.swap(array, i, min);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectSort(new int[]{12, 33, 4, 5, 6, 3, 53, 7, 893, 893, 22, 66, 88, 22, 457, 3})));
    }
}
