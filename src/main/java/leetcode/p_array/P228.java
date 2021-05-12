package leetcode.p_array;
//给定一个无重复元素的有序整数数组 nums 。
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 num
//s 的数字 x 。
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出：
//
//
// "a->b" ，如果 a != b
// "a" ，如果 a == b
//
//
//
//
// 示例 1：
//
//
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
//
//
// 示例 2：
//
//
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
//
//
// 示例 3：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 4：
//
//
//输入：nums = [-1]
//输出：["-1"]
//
//
// 示例 5：
//
//
//输入：nums = [0]
//输出：["0"]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 20
// -231 <= nums[i] <= 231 - 1
// nums 中的所有值都 互不相同
// nums 按升序排列
//
// Related Topics 数组
// 👍 152 👎 0

import java.util.ArrayList;
import java.util.List;

public class P228 {

    public static void main(String[] args) {
        P228 sou = new P228();
        int[] nums = {0,2,3,4,6,8,9};
        System.out.println(sou.summaryRanges(nums));

    }


    public List<String> summaryRanges(int[] nums) {
        List<String> anz = new ArrayList<>();
        if (nums == null || nums.length < 1){
            return anz;
        }
        int n = 0;
        StringBuilder builder = new StringBuilder(nums[0]+"");
        for (int i = 1; i < nums.length; i++){
            if (nums[i] - nums[i - 1] == 1){
                n++;
                continue;
            }
            if (n > 0){
                builder.append("->"+nums[i - 1]);
                n = 0;
            }
            anz.add(builder.toString());
            builder = new StringBuilder(nums[i]+"");
        }
        if (builder.length() > 0){
            if (n > 0){
                builder.append("->"+nums[nums.length - 1]);
            }
            anz.add(builder.toString());
        }
        return anz;
    }
}

