package leetcode.tree;
//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//
// 假定 BST 有如下定义：
//
//
// 结点左子树中所含结点的值小于等于当前结点的值
// 结点右子树中所含结点的值大于等于当前结点的值
// 左子树和右子树都是二叉搜索树
//
//
// 例如：
//给定 BST [1,null,2,2],
//
//    1
//    \
//     2
//    /
//   2
//
//
// 返回[2].
//
// 提示：如果众数超过1个，不需考虑输出顺序
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
// Related Topics 树
// 👍 235 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S501 {
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> countMap = new HashMap<>();
        dfs(root, countMap);

        int maxcnt = 0;
        for (int v: countMap.values()){
            if (v > maxcnt){
                maxcnt = v;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> m: countMap.entrySet()){
            if (maxcnt == m.getValue()){
                ans.add(m.getKey());
            }
        }
        int[] tmp = new int[ans.size()];
        for (int i=0; i<ans.size();i++){
            tmp[i] = ans.get(i);
        }
        return tmp;
    }

    private void dfs(TreeNode root,  Map<Integer,Integer> map) {
        if (root==null){
            return;
        }
        dfs(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        dfs(root.right, map);
    }

}
