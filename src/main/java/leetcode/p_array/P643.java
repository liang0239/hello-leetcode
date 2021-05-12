package leetcode.p_array;
//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
//
//
//
// 示例：
//
//
//输入：[1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
//
//
//
//
// 提示：
//
//
// 1 <= k <= n <= 30,000。
// 所给数据范围 [-10,000，10,000]。
//
// Related Topics 数组
// 👍 178 👎 0


public class P643 {

    public static void main(String[] args) {
        P643 sou = new P643();
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(sou.findMaxAverage(nums, 4));

    }


    public double findMaxAverage(int[] nums, int k) {
        double sum = Integer.MIN_VALUE, tmp = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++){
            if (i >= k){
                sum = Math.max(tmp, sum);
                tmp -= nums[i - k];
            }
            tmp += nums[i];
        }
        sum = Math.max(tmp, sum);
        return sum / k;
    }
}

