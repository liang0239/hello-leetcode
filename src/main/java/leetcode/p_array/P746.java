package leetcode.p_array;
//数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
//
// 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
//
// 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
//
//
//
// 示例 1：
//
//
//输入：cost = [10, 15, 20]
//输出：15
//解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
//
//
// 示例 2：
//
//
//输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//输出：6
//解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
//
//
//
//
// 提示：
//
//
// cost 的长度范围是 [2, 1000]。
// cost[i] 将会是一个整型数据，范围为 [0, 999] 。
//
// Related Topics 数组 动态规划
// 👍 536 👎 0

import java.util.Map;

public class P746 {

    public static void main(String[] args) {
        P746 sou = new P746();
        int[] nums = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(sou.minCostClimbingStairs1(nums));
    }


    public int minCostClimbingStairs(int[] cost) {
        if (null == cost || cost.length < 2){
            return 0;
        }
        int len = cost.length + 1;
        int[] ans = new int[len];
        for (int i = 2; i < len; i++){
            ans[i] = Math.min(ans[i -2]+cost[i - 2],  ans[i -1] + cost[i -1]);
        }

        return ans[len - 1];
    }

    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++){
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }

        return curr;
    }

}

