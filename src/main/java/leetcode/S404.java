package leetcode;
//计算给定二叉树的所有左叶子之和。
//
// 示例：
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// Related Topics 树
// 👍 251 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S404 {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        List<Integer> lefts = new ArrayList<>();
        dfs(root, false, lefts);
        for (int num :
                lefts) {
            sum += num;
        }
        return sum;
    }

    private void dfs(TreeNode root, boolean isLeft, List<Integer> lefts) {
        if (root==null){
            return;
        }
        if (root.left==null && root.right==null && isLeft){
            lefts.add(root.val);
        }
        dfs(root.left, true, lefts);
        dfs(root.right, false, lefts);
    }

//    深度优先搜索
    public int dfs(TreeNode node){
        int ans = 0;
        if (node.left!=null){
            ans += isLeafNode(node.left)?node.left.val:dfs(node.left);
        }
        if (node.right!=null && !isLeafNode(node.right)){
            ans += dfs(node.right);
        }

        return ans;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left==null && node.right==null;
    }

//    广度优先搜索
    public int sumOfLeftLeaves2(TreeNode root){
        int ans = 0;
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left != null){
                if (isLeafNode(node.left)){
                    ans += node.left.val;
                }else{
                    queue.offer(node.left);
                }
            }

            if (node.right != null){
                if (!isLeafNode(node.right)){
                    queue.offer(node.right);
                }
            }
        }

        return ans;
    }
}
