package leetcode;
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

public class S257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null){
            return paths;
        }
        LinkedList<Integer> path = new LinkedList<>();
        helper(root, paths, path);
        return paths;
    }

    private void helper(TreeNode root, List<String> paths, LinkedList<Integer> path) {
        path.add(root.val);
        if (null==root.left && null==root.right){
            StringBuilder builder = new StringBuilder();
            for (int val : path) {
                builder.append("->"+val);
            }
            paths.add(builder.substring(2));
            return;
        }
        if (null!=root.left){
            helper(root.left, paths, path);
        }
        if (null!=root.right){
            helper(root.right, paths, path);
        }

    }
}
