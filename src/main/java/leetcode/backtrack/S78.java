package leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics 位运算 数组 回溯算法
// 👍 872 👎 0
public class S78 {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            dfs(ans, path, nums, 0, i);
        }
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, int[] nums, int start, int len) {
        if (path.size() == len) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(ans, path, nums, i + 1, len);
            path.remove(path.size() - 1);
        }

    }

    //    方法一：迭代法实现子集枚举
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans1 = new ArrayList<>();

    public List<List<Integer>> subsets1(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            t.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {//判断第i位是否为1
                    t.add(nums[i]);
                }
            }
            System.out.println(mask + "\t" + Integer.toBinaryString(mask) + "\t" + t);
            ans1.add(new ArrayList<>(t));
        }
        return ans1;
    }

    //    方法二：递归法实现子集枚举
    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0, nums);
        return ans1;
    }


    private void dfs(int cur, int[] nums) {
        if (cur == nums.length) {//记录答案
            ans1.add(new ArrayList<>(t));
            return;
        }
//        考虑选择当前位置
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
//        考虑不选择当前位置
        dfs(cur + 1, nums);
    }

    public static void main(String[] args) {
        S78 sou = new S78();
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = sou.subsets2(nums);
        for (List<Integer> an : ans) {
            System.out.println(an);
        }

    }
}
