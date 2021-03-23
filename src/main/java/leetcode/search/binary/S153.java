package leetcode.search.binary;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
//
// 请找出其中最小的元素。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,4,5,1,2]
//输出：1
//
//
// 示例 2：
//
//
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5000
// -5000 <= nums[i] <= 5000
// nums 中的所有整数都是 唯一 的
// nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
//
// Related Topics 数组 二分查找
// 👍 303 👎 0


public class S153 {


    public int findMin(int[] nums) {
        if (nums == null || nums.length==0){
            return -1;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[0]){//没旋转
            return nums[0];
        }
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[mid + 1]){//原升序数组的转折点
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]){
                return nums[mid];//原升序数组的转折点
            }
            if (nums[mid] > nums[left]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        S153 sou = new S153();
        int[] nums = {3,1,2};
        int target = 0;
        int ret = sou.findMin(nums);
        System.out.println(ret);
    }
    
}
