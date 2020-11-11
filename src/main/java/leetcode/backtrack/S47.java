package leetcode.backtrack;

import java.util.*;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics 回溯算法
// 👍 521 👎 0
public class S47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(ans, visited, path, nums);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, boolean[] visited, List<Integer> path, int[] nums) {
        if (path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (visited[i] || (i>0 && nums[i]==nums[i-1] && !visited[i-1])){
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            backtrack(ans, visited, path, nums);
            visited[i] = false;
            path.remove(path.size() -1);
        }
    }


    public static void main(String[] args) {
        S47 s47 = new S47();
        int[] nums = {1,1,2};

        List<List<Integer>> data = s47.permuteUnique(nums);
        for (List<Integer> list : data) {
            System.out.println(list);
        }
    }
}
