package leetcode.p_array;
//给定一个二进制数组， 计算其中最大连续 1 的个数。
//
//
//
// 示例：
//
//
//输入：[1,1,0,1,1,1]
//输出：3
//解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
//
//
//
//
// 提示：
//
//
// 输入的数组只包含 0 和 1 。
// 输入数组的长度是正整数，且不超过 10,000。
//
// Related Topics 数组
// 👍 225 👎 0


import java.util.ArrayList;
import java.util.List;

public class P485 {

    public static void main(String[] args) {
        P485 sou = new P485();
        int[] nums = {1,1,0,1,1,1};
        System.out.println(sou.findMaxConsecutiveOnes(nums));

    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length < 1){
            return 0;
        }
        int ans = 0, tmp = 0, n = nums.length;
        for (int i = 0; i < n; i++){
            if (nums[i] == 1){
                tmp++;
            }else{
                ans = Math.max(ans, tmp);
                tmp = 0;
            }
        }
        return Math.max(ans, tmp);
    }
}

