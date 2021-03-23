package leetcode.double_pointer;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 998 👎 0


public class P283 {


    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length < 2) {
            return;
        }
        int i = 0;
        int j = 1;
        int len = nums.length;
        while (i < len) {

            while (i < len && nums[i] != 0) {//           find 0
                i++;
            }
            if (i == len){
                break;
            }

            j = i + 1;
            while (j < len && nums[j] == 0) {//           find n
                j++;
            }

            if (j == len) {
                break;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j++;
        }

    }


    public static void main(String[] args) {
        P283 sou = new P283();
        int[] nums = {2,1};
        sou.moveZeroes(nums);
        for (int tmp : nums) {
            System.out.println(tmp);
        }

    }
}
