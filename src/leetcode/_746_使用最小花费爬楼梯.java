package leetcode;

/**
 * @author J
 * @time 2018/10/14 10:30
 * @description
 **/
public class _746_使用最小花费爬楼梯 {
    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len == 2) {
            return Math.min(cost[1], cost[0]);
        }
        int c_1 = 0, c_2 = 0;
        for (int i = 2; i < len + 1; i++) {
            int temp = c_1;
            c_1 = Math.min(c_1 + cost[i - 1], c_2 + cost[i - 2]);
            c_2 = temp;
        }
        return c_1;
    }


    public static void main(String[] args) {
        int[] cost = {0, 1, 3, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
