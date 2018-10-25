package leetcode;

import java.util.ArrayList;
import java.util.Collections;
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
        int len2 = nums2.length;
        int lenK2 = k < len2 ? k : len2;

        List<int[]> kNum = new ArrayList<>();
        if (lenK == 0 || lenK2 == 0) {
            return kNum;
        }

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

        for (int i = 0; i < lenK2; i++) {
            int min = i;
            for (int j = i + 1; j < len2; j++) {
                if (nums2[j] < nums2[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums2[i];
                nums2[i] = nums2[min];
                nums2[min] = temp;
            }
        }

        for (int i = 0; i < lenK; i++) {
            for (int j = 0; j < lenK2; j++) {
                kNum.add(new int[]{nums1[i], nums2[j]});
            }
        }
        Collections.sort(kNum, (o1, o2) -> o1[0] + o1[1] - o2[0] - o2[1]);
        k = k < kNum.size() ? k : kNum.size();
        return kNum.subList(0, k);
    }


    public List<int[]> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int lenK = k < len1 ? k : len1;
        int len2 = nums2.length;
        int lenK2 = k < len2 ? k : len2;

        List<int[]> kNum = new ArrayList<>();
        if (lenK == 0 || lenK2 == 0) {
            return kNum;
        }

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                kNum.add(new int[]{nums1[i], nums2[j]});
            }
        }
        Collections.sort(kNum, (o1, o2) -> o1[0] + o1[1] - o2[0] - o2[1]);
        k = k < kNum.size() ? k : kNum.size();
        return kNum.subList(0, k);
    }
}
