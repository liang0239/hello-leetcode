package leetcode.tree;
//给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
//
// 二叉搜索树保证具有唯一的值。
//
//
//
// 示例 1：
//
// 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
//输出：32
//
//
// 示例 2：
//
// 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
//输出：23
//
//
//
//
// 提示：
//
//
// 树中的结点数量最多为 10000 个。
// 最终的答案保证小于 2^31。
//
// Related Topics 树 递归
// 👍 143 👎 0

import java.util.ArrayList;
import java.util.List;

public class S938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> dataList = new ArrayList<>();
        inorder(root, dataList);
        int sum = 0;
        for (int num : dataList) {
            if (num >= low && num <= high){
                sum += num;
            }
        }
        return sum;
    }

    private void inorder(TreeNode root, List<Integer> dataList) {
        if (root==null){
            return;
        }
        inorder(root.left, dataList);
        dataList.add(root.val);
        inorder(root.right, dataList);
    }
    int sum = 0;
    public int rangeSumBST1(TreeNode root, int low, int high) {
        if (root==null){
            return sum;
        }
        sum = rangeSumBST1(root.left, low, high);
        if (root.val>=low && root.val<=high){
            sum += root.val;
        }
        sum = rangeSumBST1(root.right, low, high);

        return sum;
    }

}
