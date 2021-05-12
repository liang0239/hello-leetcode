package leetcode.p_array;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找
// 👍 866 👎 0


import java.util.PriorityQueue;

public class P35 {

    public static void main(String[] args) {
        P35 sou = new P35();
        int[] nums = {1,3,5,6};
        int target = 2;
        int ret = sou.searchInsert(nums, target);
        System.out.println(ret);

    }


    public int searchInsert(int[] nums, int target) {
        if (null == nums || target < nums[0]){
            return 0;
        }

        int left = 0, right = nums.length;
        if (target > nums[right - 1]){
            return right;
        }

        while (left < right){
            int mid = left + (right - left)/2 ;
            if (target == nums[mid]){
                return mid;
            }else if (target > nums[mid]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}

