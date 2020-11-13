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
        getAns(nums, 0, path, ans);
//        boolean[] visited = new boolean[nums.length];
//        for (int i = 0; i <= nums.length; i++) {
//            dfs(ans, path, visited, nums, 0, i);
//        }
        return ans;
    }

    private void getAns(int[] nums, int start, List<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path));

        for (int i= start; i < nums.length; i++){
            if (i > start && nums[i] == nums[i-1]){
                continue;//和上个数字相等就跳过
            }
            path.add(nums[i]);
            getAns(nums, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, boolean[] visited,
                     int[] nums, int cur, int len) {

        if (path.size() == len) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = cur; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1]) && !visited[i-1]) {
                continue;//和上个数字相等就跳过
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(ans, path, visited, nums, i + 1, len);
            path.remove(path.size() - 1);
            visited[i] = false;
        }

    }

    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());//初始化空数组
        Arrays.sort(nums);
        int start = 1;//保存新鲜的开始位置
        for (int i = 0; i < nums.length; i++){
            List<List<Integer>> ans_tmp = new ArrayList<>();
//            遍历之前所有结果
            for (int j = 0; j < ans.size(); j++){
                List<Integer> list = ans.get(j);
//                如果出现重复数字，就跳过所有旧解
                if (i > 0 && nums[i] == nums[i-1] && j < start){
                    continue;
                }
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(nums[i]);//加入新增数字
                ans_tmp.add(tmp);
            }
            start = ans.size();//更新新解的开始位置
            ans.addAll(ans_tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        S90 sou = new S90();
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = sou.subsetsWithDup1(nums);
        for (List<Integer> tmp : ans) {
            System.out.println(tmp);
        }
    }
}
