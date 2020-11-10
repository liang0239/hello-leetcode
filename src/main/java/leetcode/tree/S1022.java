package leetcode.tree;
//给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 ->
// 0 -> 1，那么它表示二进制数 01101，也就是 13 。
//
// 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
//
// 以 10^9 + 7 为模，返回这些数字之和。
//
//
//
// 示例：
//
//
//
// 输入：[1,0,1,0,1,0,1]
//输出：22
//解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
//
//
//
//
// 提示：
//
//
// 树中的结点数介于 1 和 1000 之间。
// node.val 为 0 或 1 。
//
// Related Topics 树
// 👍 78 👎 0

import java.util.ArrayList;
import java.util.List;

public class S1022 {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null){
            return 0;
        }
        List<String> dataList = new ArrayList<>();
        dfs(root, dataList, "");
        int sum = 0;
        for (String tmp : dataList) {
            System.out.println(tmp);
            sum += Integer.parseInt(tmp, 2);
        }

        return sum;
    }

    private void dfs(TreeNode root, List<String> dataList, String path) {
        if (root == null){
            return;
        }
        path += root.val;
        if (null == root.left && null==root.right){
            dataList.add(path);
            return;
        }
        dfs(root.left, dataList, path);
        dfs(root.right, dataList, path);
    }

    int ans = 0;
    public int sumRootToLeaf1(TreeNode root) {
        sumbinary(root, 0);
        return ans;
    }

    private void sumbinary(TreeNode root, int cur) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            ans += cur * 2 + root.val;
            return;
        }

        sumbinary(root.left, cur * 2 + root.val);
        sumbinary(root.right, cur * 2 + root.val);
    }

}
