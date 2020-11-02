package leetcode;
//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics 树 深度优先搜索
// 👍 627 👎 0




import java.util.*;

public class S108 {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        S108 s108 = new S108();
        s108.sortedArrayToBST(nums);

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (null==nums || nums.length==0){
            return null;
        }
        return buildBST(nums,0, nums.length-1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start>end){
            return null;
        }

//        int mid = (left + right) / 2; // 总是选择中间位置左边的数字作为根节点
//        int mid = (left + right + 1) / 2;// 总是选择中间位置右边的数字作为根节点
//        int mid = (left + right + rand.nextInt(2)) / 2; // 选择任意一个中间位置数字作为根节点

        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = buildBST(nums, start, mid-1);
        node.right = buildBST(nums, mid+1, end);
        return node;
    }

    private List<TreeNode> buildAllTree(int[] nums, int start, int end) {
        List<TreeNode> allTree = new ArrayList<>();
        if (start>end){
            allTree.add(null);
            return allTree;
        }
        //      枚举可行根节点
        for (int i=start; i<=end; i++){
            //            获取所有可用左子树
            List<TreeNode> allLeftTree = buildAllTree(nums, start, i-1);
            //            获取所有可用右子树
            List<TreeNode> allRightTree = buildAllTree(nums, i+1, end);
            //            从左子树中取出一个子树，再从右子树中取一颗作为右节点，然后和根拼接起来
            for (TreeNode leftTree :
                    allLeftTree) {
                for (TreeNode rightTree :
                        allLeftTree) {
                    TreeNode node = new TreeNode(nums[i]);
                    node.left = leftTree;
                    node.right = rightTree;
                    allTree.add(node);
                }
            }
        }

        return allTree;
    }
}
