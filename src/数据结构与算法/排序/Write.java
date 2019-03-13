package 数据结构与算法.排序;

import utils.BaseUtils;

/**
 * 手写常见排序
 * created on 2019/3/13.
 *
 * @author J
 **/
public class Write {

    /**
     * 冒泡
     */
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    BaseUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 插入
     */
    public static void insertSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int current = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (current >= arr[j]) {
                    break;
                }
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = current;
        }
    }

    /**
     * 选择
     */
    public static void selectSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len -1; i++) {
            int min = i;
            for (int j = i+1; j < len; j++) {
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            if (min != i){
                BaseUtils.swap(arr,min,i);
            }
        }
    }

    /**
     * 快排
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    public static void qSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int p = partition(arr, start, end);
        qSort(arr, start, p - 1);
        qSort(arr, p + 1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        int key = arr[start];
        while (start < end) {
            while (arr[end] > key && start < end) {
                end--;
            }
            arr[start] = arr[end];

            while (arr[start] <= key && start < end) {
                start++;
            }

            arr[end] = arr[start];
        }

        arr[start] = key;
        return start;
    }


    /**
     * 归并排序
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        mSort(arr, 0, arr.length - 1);
    }

    public static void mSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mSort(arr, start, mid);
        mSort(arr, mid + 1, end);
        merge(arr, start, end);
    }

    public static void merge(int[] arr, int start, int end) {
        int st = start;
        int end0 = (start + end) / 2;
        int start1 = end0 + 1;
        int[] temp = new int[end - start + 1];

        int i = 0;
        while (start <= end0 && start1 <= end) {
            if (arr[start] <= arr[start1]) {
                temp[i] = arr[start++];
            } else {
                temp[i] = arr[start1++];
            }
            i++;
        }

        //这里两个while只会进入一个
        while (start <= end0) {
            temp[i++] = arr[start++];
        }

        while (start1 <= end) {
            temp[i++] = arr[start1++];
        }

        for (int item : temp) {
            arr[st++] = item;
        }
    }

    public static void main(String[] args) {
        int[] ar = new int[]{12, 33, 4, 5, 6, 3, 53, 7, 893, 22, 66, 88, 22, 457};
        selectSort(ar);
        for (int i : ar) {
            System.out.println(i);
        }
    }
}
