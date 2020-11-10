package leetcode.tree;

//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其自底向上的层次遍历为：
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
//
// Related Topics 树 广度优先搜索
// 👍 357 👎 0


import java.util.*;

public class S107 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null==root){
            return ans;
        }
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> child = new ArrayList<>();
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                child.add(node.val);
                if (null!=node.left){
                    queue.offer(node.left);
                }
                if (null!=node.right){
                    queue.offer(node.right);
                }
            }
            stack.push(child);
        }
        while (!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }
}
