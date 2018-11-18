package leetcode;

/**
 * @Description 动态规划问题
 * @author J
 * @Date 2018/9/30 14:54
 **/
public class _213_打家劫舍 {

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        return Math.max(
                //选了0就不能选择最后一个
                robPart(nums, 0, length - 1),
                //选最后一个不能选第0个
                robPart(nums, 1, length)
        );
    }

    /**
     * 思路: sum(i) = max{ sum(i-1), sum(i-2) + nums(i) }
     * 注意,这里的长度是指 [start,end) 的长度
     * 数组长度 = 3 , nums[2] 是否取到,
     * --  若取不到, 即等于长度为2时的最大值,
     * --  若取到, 表示 nums[1] 取不到,即等于长度为1时的最大值 + nums[2]
     * 数组长度 = 4 , nums[3] 是否取到,
     * --  若取不到,即等于长度为2时的最大值,
     * --  若取到, 表示 nums[2] 取不到, 即等于长度为2时的最大值 + nums[3]
     * .....
     */
    private static int robPart(int[] nums, int start, int end) {
        int sum = 0;
        int beforeSum = 0;
        for (int i = start; i < end; i++) {
            int tmp = sum;
            sum = Math.max(beforeSum + nums[i], sum);
            beforeSum = tmp;
        }
        return sum;
    }


    /**
     * 198 打家劫舍
     * f(n) = max( f(n-2) + nums[2] , f(n-1) )
     * @param nums
     * @return
     */
    public int rob198(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return Math.max(nums[0],nums[1]);
        }

        int sum = Math.max(nums[0],nums[1]);
        int beforeSum = nums[0];

        for (int i = 2; i < len; i++) {
            int tmp = sum;
            sum = Math.max(beforeSum + nums[i], sum);
            beforeSum = tmp;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 100};
        System.out.println(rob(a));
    }
}
