package leetcode.p_array;
//给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
//
// 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
//
//
//
// 示例 1:
//
//
//输入: nums = [4,2,3]
//输出: true
//解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
//
//
// 示例 2:
//
//
//输入: nums = [4,2,1]
//输出: false
//解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10 ^ 4
// - 10 ^ 5 <= nums[i] <= 10 ^ 5
//
// Related Topics 数组
// 👍 564 👎 0



public class P665 {

    public static void main(String[] args) {
        P665 sou = new P665();
        int[] nums = {5,7,1,8};
        System.out.println(sou.checkPossibility(nums));

    }


    public boolean checkPossibility(int[] nums) {
        if (null == nums || nums.length < 2){
            return true;
        }
        int len = nums.length - 1, counter = 0;
        for (int i = 0; i < len; i++){
            int x = nums[i], y = nums[i + 1];
            if (x <= y){
                continue;
            }
            counter++;
            if (counter > 1){
                return false;
            }
//            还需要保证nums[i-1] <= nums[i+1]
            if (i > 0 && y < nums[i - 1]){
                nums[i + 1] = x;
            }

        }

        return true;

    }
}

