package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author J
 * @time 2018/10/21 20:51
 * @description
 **/
public class _373_查找和最小的K对数字 {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int lenK = k < len1 ? k : len1;
        for (int i = 0; i < lenK; i++) {
            int min = i;
            for (int j = i + 1; j < len1; j++) {
                if (nums1[j] < nums1[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums1[i];
                nums1[i] = nums1[min];
                nums1[min] = temp;
            }
        }

        int len2 = nums2.length;
        int lenK2 = k < len2 ? k : len2;
        for (int i = 0; i < lenK2; i++) {
            int min = i;
            for (int j = i + 1; j < len2; j++) {
                if (nums1[j] < nums1[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums1[i];
                nums1[i] = nums1[min];
                nums1[min] = temp;
            }
        }
        List<int[]> kNum = new ArrayList<>();
        while (k > 0) {
            int i = 0, j = 0;
            while (i < len1 && j < lenK2 && ) {
                k--;
                kNum.add(new int[]{nums1[i], nums2[j]});
                //todo

                if (k == 0) {
                    break;
                }
            }
        }
        return kNum;
    }
}
