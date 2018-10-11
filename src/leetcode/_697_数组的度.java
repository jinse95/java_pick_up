package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author J
 * @time 2018/10/11 21:15
 * @description
 **/
public class _697_数组的度 {
    public static int findShortestSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        int du = 1;
        int len1 = 0;
        //对应的数字为key  int[] {开始index,结束index,重复次数}
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int item = nums[i];
            int[] indexs;
            if (map.containsKey(item)) {
                indexs = map.get(item);
                indexs[1] = i;
                indexs[2]++;
            } else {
                indexs = new int[]{i, i, 1};
                map.put(item, indexs);
                len1++;
            }
        }
        if (len1 == len) {
            return 1;
        }

        len1 = -1;
        for (Map.Entry<Integer, int[]> item : map.entrySet()) {
            int[] temp = item.getValue();
            if (temp[2] > du) {
                du = temp[2];
                len1 = temp[1] - temp[0];
            } else if (temp[2] == du) {
                len1 = Math.min(len1, temp[1] - temp[0]);
            }
        }

        return len1 + 1;
    }
}
