package 数据结构与算法.排序;

/**
 * @author J
 * @time 2018/10/6 20:13
 * @description
 **/
public class QuickSortArray {
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
        array[low] = key;
        return low;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = partition(array, low, high);
            quickSort(array, low, middle - 1);
            quickSort(array, middle + 1, high);
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
