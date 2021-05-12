package leetcode.p_array;
//给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
//
//
//
// 示例 1：
//
//
//输入：[1, 2, 2, 3, 1]
//输出：2
//解释：
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
//
//
// 示例 2：
//
//
//输入：[1,2,2,3,1,4,2]
//输出：6
//
//
//
//
// 提示：
//
//
// nums.length 在1到 50,000 区间范围内。
// nums[i] 是一个在 0 到 49,999 范围内的整数。
//
// Related Topics 数组
// 👍 333 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P697 {

    public static void main(String[] args) {
        P697 sou = new P697();
        int[] nums = {1,2,2,3,1,4,2};
        System.out.println(sou.findShortestSubArray(nums));
    }


    public int findShortestSubArray(int[] nums) {
        int minlen = Integer.MAX_VALUE, len = nums.length, maxcnt = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++){
            set.add(nums[i]);
        }
        for (int tmp: set){
            int l = -1, r = -1, count = 0;
            for (int i = 0; i < len; i++){
                if (tmp == nums[i]){
                    count++;

                    if (l == -1){
                        l = i;
                        r = i;

                    }else {
                        r = i;
                    }
                }
            }
            int tmplen = r - l + 1;
            if (count > maxcnt){
                maxcnt = count;
                minlen = tmplen;
            }else if (count == maxcnt){
                if (tmplen < minlen){
                    minlen = tmplen;
                }
            }
            System.out.println(tmp +"\t"+ count +"\t"+(r - l + 1));
        }

        return minlen;
    }
    public int findShortestSubArray1(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            int x = nums[i];
            if (map.containsKey(x)){
                map.get(x)[0]++;
                map.get(x)[2] = i;
            }else {
                map.put(x, new int[]{1, i, i});
            }
        }
        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry: map.entrySet()){
            int[] arr = entry.getValue();
            if (maxNum < arr[0]){
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]){
                if (minLen > arr[2] - arr[1]){
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }

}

