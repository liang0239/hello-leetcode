package leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
//
// 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
//
// 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
//
//
//
// 示例 1：
//
//
// 输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
//
//
// 示例 2：
//
//
// 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
//
//
// 示例 3：
//
//
//
// 输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false
//
//
//
// 提示：
//
//
// 二叉树的节点数介于 2 到 100 之间。
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。
//
//
//
// Related Topics 树 广度优先搜索
// 👍 106 👎 0
public class S993 {

    //    广度优先
    public boolean isCousins(TreeNode root, int x, int y) {
        if (null == root) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            TreeNode xP = null, yP = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.val == x) {
                        xP = node;
                    } else if (node.left.val == y) {
                        yP = node;
                    }
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    if (node.right.val == x) {
                        xP = node;
                    } else if (node.right.val == y) {
                        yP = node;
                    }
                }

            }
            if (xP != null && yP != null && xP != yP) {
                return true;
            }
        }
        return false;
    }

    //    深度优先
    Map<Integer, Integer> depth;
    Map<Integer, TreeNode> parent;

    public boolean isCousins1(TreeNode root, int x, int y) {
        depth = new HashMap<>();
        parent = new HashMap<>();
        dfs(root, null);
        return (depth.get(x) == depth.get(y)) && parent.get(x) != parent.get(y);
    }

    private void dfs(TreeNode root, TreeNode par) {
        if (root != null) {
            depth.put(root.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(root.val, par);

            dfs(root.left, root);
            dfs(root.right, root);
        }

    }
}
