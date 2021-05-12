package leetcode.p_array;
//给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
//
// 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
//
// 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
//
//
//
// 示例 1：
//
//
//输入：nums = [-3,2,-3,4,2]
//输出：5
//解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
//                累加求和
//                startValue = 4 | startValue = 5 | nums
//                  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
//                  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
//                  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
//                  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
//                  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
//
//
// 示例 2：
//
//
//输入：nums = [1,2]
//输出：1
//解释：最小的 startValue 需要是正数。
//
//
// 示例 3：
//
//
//输入：nums = [1,-2,-3]
//输出：5
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// -100 <= nums[i] <= 100
//
// Related Topics 数组
// 👍 22 👎 0


import java.util.Arrays;
import java.util.Map;

public class P1413 {

    public static void main(String[] args) {
        P1413 sou = new P1413();
        int[] nums = {-22,-29,-21,0,-4,-26,10,-11,-14,-11};

        System.out.println(sou.minStartValue(nums));

    }


    public int minStartValue(int[] nums) {
        int n = nums.length, ret = 0;
        for (int tmp : nums) {
            if (tmp < 0){
                ret += tmp;
            }else {
                break;
            }
        }
        boolean flag = true;
        System.out.println(ret);
        for (int i = Math.abs(ret); i <= 1000000; i++){
            ret = i;
            flag = true;
            for (int j = 0; j < n; j++){
                ret += nums[j];
                if (ret < 1){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return i;
            }
        }

        return -1;
    }
}

