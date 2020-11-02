package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
//
//
//
// 示例：
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
//
//
//
// 提示：
//
//
// 0 <= n <= 8
//
// Related Topics 树 动态规划
// 👍 684 👎 0
public class S95 {
    public static void main(String[] args) {
        S95 s95 = new S95();
        List<TreeNode> list = s95.generateTrees(3);
        System.out.println(list.size());
    }

    public List<TreeNode> generateTrees(int n) {
        if (n==0){
            return new ArrayList<TreeNode>();
        }

        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTree = new ArrayList<TreeNode>();
        if (start>end){
            allTree.add(null);
            return allTree;
        }
//      枚举可行根节点
        for (int i = start; i <= end; i++){
//            获取所有可用左子树
            List<TreeNode> leftTrees = generateTrees(start, i-1);
//            获取所有可用右子树
            List<TreeNode> rightTrees = generateTrees(i+1, end);
//            从左子树中取出一个子树，再从右子树中取一颗作为右节点，然后和根拼接起来
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currNode = new TreeNode(i);
                    currNode.left = left;
                    currNode.right = right;
                    allTree.add(currNode);
                }
            }

        }
        return allTree;
    }
}
