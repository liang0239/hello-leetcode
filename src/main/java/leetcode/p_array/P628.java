package leetcode.p_array;
//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：6
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3,4]
//输出：24
//
//
// 示例 3：
//
//
//输入：nums = [-1,-2,-3]
//输出：-6
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 104
// -1000 <= nums[i] <= 1000
//
// Related Topics 数组 数学
// 👍 290 👎 0

import java.util.Arrays;

public class P628 {

    public static void main(String[] args) {
        P628 sou = new P628();
        int[] nums = {1,2,3,4};

        System.out.println(sou.maximumProduct(nums));

    }


    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        return Math.max(nums[0]*nums[1]*nums[n-1], nums[n-3]*nums[n-2]*nums[n-1]);
    }

    public int maximumProduct1(int[] nums) {
//        最小2个数字
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
//        最大3个数字
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int x : nums) {
            if (x < min1){
                min2 = min1;
                min1 = x;
            }else if (x < min2){
                min2 = x;
            }

            if (x > max1){
                max3 = max2;
                max2 = max1;
                max1 = x;
            }else if (x > max2){
                max3 = max2;
                max2 = x;
            }else if (x > max3){
                max3 = x;
            }

        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);

    }
}

