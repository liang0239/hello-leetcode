package leetcode.tree;
//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。示例: 给定有序数组: [-10,-3,0,5,9], 一个可能
//的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：           0          / \        -3
//  9        /   /      -10  5 Related Topics 树 深度优先搜索
// 👍 59 👎 0

public class M0402 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums || nums.length<1){
            return null;
        }
        int left = 0, right = nums.length-1;

        return buildTree(nums, left, right);

    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left>right){
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, left, mid-1);
        node.right = buildTree(nums, mid+1, right);

        return node;
    }


}
