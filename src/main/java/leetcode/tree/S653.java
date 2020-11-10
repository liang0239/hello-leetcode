package leetcode.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
//
// 案例 1:
//
//
//输入:
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 9
//
//输出: True
//
//
//
//
// 案例 2:
//
//
//输入:
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 28
//
//输出: False
//
//
//
// Related Topics 树
// 👍 195 👎 0
public class S653 {
    public boolean findTarget(TreeNode root, int k) {
        if (null == root){
            return false;
        }
        List<Integer> nums = new ArrayList<>();
        dfs(root, nums);
        int left = 0;
        int right = nums.size()-1;
        while (left < right){
            int sum = nums.get(left) + nums.get(right);
            if (k == sum ){
                return true;
            }else if (k > sum){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }

    private void dfs(TreeNode root, List<Integer> nums) {
        if (root == null){
            return;
        }
        dfs(root.left, nums);
        nums.add(root.val);
        dfs(root.right, nums);
    }

//    使用hashset
    public boolean findTarget2(TreeNode root, int k){
        Set<Integer> set = new HashSet<>();
        return find(root, k ,set);
    }

    private boolean find(TreeNode root, int k, Set<Integer> set) {
        if (null == root){
            return false;
        }
        if (set.contains(k - root.val)){
            return true;
        }
        set.add(root.val);

        return find(root.left, k, set) || find(root.right, k, set);

    }
}
