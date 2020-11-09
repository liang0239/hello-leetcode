package leetcode;
//给定一个 N 叉树，返回其节点值的后序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其后序遍历: [5,6,3,2,4,1].
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树
// 👍 110 👎 0

import java.util.ArrayList;
import java.util.List;

public class S590 {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (null == root){
            return ans;
        }

        for (Node node : root.children) {
            ans.addAll(postorder(node));
        }
        ans.add(root.val);
        return ans;
    }

}
