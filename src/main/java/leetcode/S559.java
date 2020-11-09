package leetcode;
//给定一个 N 叉树，找到其最大深度。
//
// 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 我们应返回其最大深度，3。
//
// 说明:
//
//
// 树的深度不会超过 1000。
// 树的节点总不会超过 5000。
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 131 👎 0

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S559 {
    public int maxDepth(Node root) {
        if (null == root){
            return 0;
        }
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for (int i=0; i<size; i++){
                Node  node = queue.poll();
                if (node.children!=null){
                    for (Node tmp :
                            node.children) {
                        queue.offer(tmp);
                    }
                }
            }
        }

        return depth;
    }

    public int maxDepth1(Node root){
        if (root==null){
            return 0;
        }else if (root.children.isEmpty()){
            return 1;
        }else {
            List<Integer> heights = new LinkedList<>();
            for (Node item : root.children) {
                heights.add(maxDepth1(item));
            }
            return Collections.max(heights)+1;
        }
    }
}
