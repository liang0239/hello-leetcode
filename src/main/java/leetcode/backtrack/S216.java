package leetcode.backtrack;
//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
// 说明：
//
//
// 所有数字都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1:
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
//
//
// 示例 2:
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//
// Related Topics 数组 回溯算法
// 👍 225 👎 0

import java.util.ArrayList;
import java.util.List;

public class S216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(ans, path, 1, k, n);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, int start, int num, int target) {
        if (path.size() == num){
            if (target == 0){
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        if (target - start < 0){
            return;
        }
        for (int i=start; i<10; i++){
            path.add(i);
            dfs(ans, path, i+1, num, target - i);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        S216 sou = new S216();
        int k = 3, n = 9;
        List<List<Integer>> ans = sou.combinationSum3(k, n);
        for (List<Integer> tmp : ans) {
            System.out.println(tmp);
        }

    }
}
