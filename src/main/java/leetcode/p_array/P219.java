package leetcode.p_array;
//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。
//
//
//
// 示例 1:
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true
//
// 示例 2:
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true
//
// 示例 3:
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false
// Related Topics 数组 哈希表
// 👍 252 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P219 {

    public static void main(String[] args) {
        P219 sou = new P219();
        int[] prices = {1,2,3,1};
        System.out.println(sou.containsNearbyDuplicate(prices, 3));

    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                int j = map.get(nums[i]);
                if (i - j <= k  ){
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
}

