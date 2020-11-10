package leetcode.tree;
//给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
// Related Topics 树 深度优先搜索
// 👍 393 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S257 {
//    深度优先遍历
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        helper(root, paths, "");
        return paths;
    }

    private void helper(TreeNode root, List<String> paths, String path) {
        if (root!=null){
            StringBuilder builder = new StringBuilder(path);
            builder.append(root.val);
            if (root.left == null && root.right==null){ // 当前节点是叶子节点
                paths.add(builder.toString()); // 把路径加入到答案中
            }else {
                builder.append("->");// 当前节点不是叶子节点，继续递归遍历
                helper(root.left, paths, builder.toString());
                helper(root.right, paths, builder.toString());
            }
        }
    }

    private void dfs(TreeNode root, StringBuilder cur, List<String> paths) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            paths.add(cur.toString() + root.val);
            return;
        }
        int sz = cur.length();
        cur.append(root.val).append("->");
        dfs(root.left, cur, paths);
        dfs(root.right, cur, paths);
        cur.delete(sz, cur.length());
    }

//    广度优先遍历
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root==null){
            return paths;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();

        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));
        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();

            if (node.left==null && node.right==null){
                paths.add(path);
            }else {
                if (node.left!=null){
                    nodeQueue.offer(node.left);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
                }
                if (node.right!=null){
                    nodeQueue.offer(node.right);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
                }
            }
        }
        return paths;
    }
}
