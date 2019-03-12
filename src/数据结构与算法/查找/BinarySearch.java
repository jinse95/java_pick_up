package 数据结构与算法.查找;

/**
 * 二分查找
 * 适用于有序数组的查找
 * 注意:数据量过大或者过小都不适合用二分查找
 * 过小 可以直接顺序查找
 * 过大 内存无法申请过大的连续空间
 * created on 2019/3/8.
 *
 * @author J
 **/
public class BinarySearch {

    public int search(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) { // <=
            //不直接相加除2 防止溢出
            int mid = low + (high - low) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;//+1
            } else {
                high = mid - 1;//-1
            }
        }

        return -1;
    }

}
