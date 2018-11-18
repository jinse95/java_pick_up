package 数据结构与算法.排序;

import java.util.Arrays;

/**
 * @Description 插入排序
 * @author J
 * @Date 2018/10/16 16:27
 **/
public class InsertSort {
    public static int[] insertSort(int[] array) {
        int len = array.length;
        int key;
        for (int i = 1; i < len; i++) {
            key = array[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (array[j] <= key) {
                    break;
                }
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertSort(new int[]{12, 33, 4, 5, 6, 3, 53, 7, 893, 893, 22, 66, 88, 22, 457, 3})));
    }
}
