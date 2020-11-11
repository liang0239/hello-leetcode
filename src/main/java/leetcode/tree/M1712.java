package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

//二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉
//搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
//
// 返回转换后的单向链表的头节点。
//
// 注意：本题相对原题稍作改动
//
//
//
// 示例：
//
// 输入： [4,2,5,1,3,null,6,0]
//输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
//
//
// 提示：
//
//
// 节点数量不会超过 100000。
//
// Related Topics 树 二叉搜索树 递归
// 👍 49 👎 0
public class M1712 {

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> dataList = new ArrayList<>();
        dfs(root, dataList);
        for (int i = 0; i < dataList.size() - 1; i++) {
            TreeNode node = dataList.get(i);
            TreeNode node1 = dataList.get(i + 1);
            node.left = null;
            node.right = node1;
            node1.left = null;
            node1.right = null;
        }

        return dataList.get(0);
    }

    private void dfs(TreeNode root, List<TreeNode> dataList) {
        if (null == root) {
            return;
        }
        dfs(root.left, dataList);
        dataList.add(root);
        dfs(root.right, dataList);
    }

    //    不用辅助list直接修改
    TreeNode head = new TreeNode(-1);//为了返回单向链表的头节点而多设的一个节点
    TreeNode pre = null; //指向当前节点的前一个节点
    public TreeNode convertBiNode1(TreeNode root) {
        helper(root);
        return head.right;
    }

    private void helper(TreeNode root) {
        if (null == root){
            return;
        }
        helper(root.left);
        if (pre == null){//第一个节点
            pre = root;//记录第一个节点
            head.right = root;//它作为单链表的表头
        }else{
            pre.right = root;//前一个节点的右指针指向当前节点
            pre = root;//更新pre
        }
        root.left = null;//当前节点的左指针设为null
        helper(root.right);
    }
}
