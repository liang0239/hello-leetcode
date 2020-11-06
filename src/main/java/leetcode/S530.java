package leetcode;
//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
//
//
//
// 示例：
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
//
//
//
//
// 提示：
//
//
// 树中至少有 2 个节点。
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
//相同
//
// Related Topics 树
// 👍 206 👎 0

import java.util.ArrayList;
import java.util.List;

public class S530 {

    public int getMinimumDifference(TreeNode root) {
        List<Integer> dataList = new ArrayList<>();
        dfs(root, dataList);
        int ans = Integer.MAX_VALUE;
        for (int i=1; i<dataList.size(); i++){
            ans = Math.min(ans, dataList.get(i) - dataList.get(i-1));
        }

        return ans;
    }

    private void dfs(TreeNode root, List<Integer> dataList ) {
        if (null == root){
            return;
        }
        dfs(root.left, dataList);
        dataList.add(root.val);
        dfs(root.right, dataList);
    }


    int pre;
    int ans;
    public int getMinimumDifference1(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }


}
