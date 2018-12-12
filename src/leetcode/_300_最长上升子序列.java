package leetcode;

/**
 * 动态规划
 * created on 2018/12/12.
 *
 * @author J
 **/
public class _300_最长上升子序列 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        int[] tail = new int[len];
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {

            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        _300_最长上升子序列 o = new _300_最长上升子序列();
        System.out.println(o.lengthOfLIS(new int[]
                {2, 5, 1, 2 , 3, 4, 7, 101, 18}
                ));
    }


}
