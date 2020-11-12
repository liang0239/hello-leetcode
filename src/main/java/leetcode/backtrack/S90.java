package leetcode.backtrack;
//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
// Related Topics 数组 回溯算法
// 👍 340 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i <= nums.length; i++) {
            dfs(ans, path, visited, nums, 0, i);
        }
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, boolean[] visited,
                     int[] nums, int cur, int len) {

        if (path.size() == len) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = cur; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1]) && !visited[i-1]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(ans, path, visited, nums, i + 1, len);
            path.remove(path.size() - 1);
            visited[i] = false;
        }

    }

    public static void main(String[] args) {
        S90 sou = new S90();
        int[] nums = {1, 2, 2};
        List<List<Integer>> ans = sou.subsetsWithDup(nums);
        for (List<Integer> tmp : ans) {
            System.out.println(tmp);
        }
    }
}
