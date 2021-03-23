package leetcode.tree;
//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回锯齿形层次遍历如下：
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics 栈 树 广度优先搜索
// 👍 300 👎 0


import java.util.*;

public class S103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == root) {
            return ans;
        }
        int level = 0;
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> child = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0) {//左-》右
                    if (node.left != null) {
                        stack.add(node.left);
                    }
                    if (node.right != null) {
                        stack.add(node.right);
                    }
                } else {//右-》左
                    if (node.right != null) {
                        stack.add(node.right);
                    }
                    if (node.left != null) {
                        stack.add(node.left);
                    }
                }
                child.add(node.val);
            }
            while (!stack.isEmpty()) {
                queue.offer(stack.pop());
            }
            level++;
            ans.add(child);
        }

        return ans;
    }


    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        // add the root element with a delimiter to kick off the BFS loop
        LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
        node_queue.addLast(root);
        node_queue.addLast(null);

        LinkedList<Integer> level_list = new LinkedList<Integer>();
        boolean is_order_left = true;

        while (node_queue.size() > 0) {
            TreeNode curr_node = node_queue.pollFirst();
            if (curr_node != null) {
                if (is_order_left)
                    level_list.addLast(curr_node.val);
                else
                    level_list.addFirst(curr_node.val);

                if (curr_node.left != null)
                    node_queue.addLast(curr_node.left);
                if (curr_node.right != null)
                    node_queue.addLast(curr_node.right);

            } else {
                // we finish the scan of one level
                results.add(level_list);
                level_list = new LinkedList<Integer>();
                // prepare for the next level
                if (node_queue.size() > 0)
                    node_queue.addLast(null);
                is_order_left = !is_order_left;
            }
        }
        return results;
    }

    protected void DFS(TreeNode node, int level, List<List<Integer>> results) {
        if (level >= results.size()) {
            LinkedList<Integer> newLevel = new LinkedList<Integer>();
            newLevel.add(node.val);
            results.add(newLevel);
        } else {
            if (level % 2 == 0)
                results.get(level).add(node.val);
            else
                results.get(level).add(0, node.val);
        }

        if (node.left != null) DFS(node.left, level + 1, results);
        if (node.right != null) DFS(node.right, level + 1, results);
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        DFS(root, 0, results);
        return results;
    }


    public static void main(String[] args) {
        S103 sou = new S103();

    }

}
