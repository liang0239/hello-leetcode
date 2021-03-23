package leetcode.double_pointer;
//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100]
//
// 示例 2：
//
//
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums 已按 非递减顺序 排序
//
//
//
//
// 进阶：
//
//
// 请你设计时间复杂度为 O(n) 的算法解决本问题
//
// Related Topics 数组 双指针
// 👍 215 👎 0



public class P977 {
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1;
        int k = r;
        int[] ret = new int[nums.length];
        while (l <= r){
            int num1 = nums[l] * nums[l];
            int num2 = nums[r] * nums[r];
            if (num1 > num2){
                ret[k] = num1;
                l++;
            }else {
                ret[k] = num2;
                r--;
            }
            k--;
        }
        return ret;
    }

    public static void main(String[] args) {
        P977 sou = new P977();
        int[] nums = {-7,-3,2,3,11};
        int[] ret = sou.sortedSquares(nums);
        for (int tmp : ret) {
            System.out.println(tmp);
        }

    }
}
