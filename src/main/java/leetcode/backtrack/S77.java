package leetcode.backtrack;

import java.util.*;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法
// 👍 434 👎 0
public class S77 {


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        List<Integer> path = new ArrayList<>();
        Set<String> bset = new HashSet<>();
        backtrack(bset, visited, path, k);
        for (String tmp : bset) {
            path = new ArrayList<>();
            for (int i = 0; i < tmp.length(); i++){
                if ('1' == tmp.charAt(i)){
                    path.add(i);
                }
            }
            ans.add(path);
        }
        return ans;
    }

    private void backtrack(Set<String> bset, boolean[] visited, List<Integer> path, int k) {
        if (path.size() == k){
            StringBuilder builder = new StringBuilder();
            for (boolean bool : visited) {
                if (bool){
                    builder.append(1);
                }else {
                    builder.append(0);
                }
            }
            bset.add(builder.toString());
            return;
        }
        for (int i=1; i<visited.length; i++){
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            path.add(i);
            backtrack(bset, visited, path, k);
            path.remove(path.size() -1);
            visited[i] = false;
        }
    }



    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine1(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }

    public static void main(String[] args) {
        S77 s77 = new S77();
        List<List<Integer>> datalist = s77.combine1(4,2);
        for (List<Integer> list: datalist){
            System.out.println(list);
        }


    }
}
