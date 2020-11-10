package leetcode.tree;
//实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。 示例 1: 给定二叉树 [3,9,20,nu
//ll,null,15,7]     3    / \   9  20     /  \    15   7 返回 true 。示例 2: 给定二叉树 [1,2,
//2,3,3,null,null,4,4]       1      / \     2   2    / \   3   3  / \ 4   4 返回 fal
//se 。 Related Topics 树 深度优先搜索
// 👍 33 👎 0
public class M0404 {

    public boolean isBalanced(TreeNode root) {
        if (null == root){
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);

        return Math.abs(left - right)<2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (null == root){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right)+1;
    }
}
