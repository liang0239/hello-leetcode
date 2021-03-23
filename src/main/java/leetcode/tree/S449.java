package leetcode.tree;
//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。
//
// 编码的字符串应尽可能紧凑。
//
//
//
// 示例 1：
//
//
//输入：root = [2,1,3]
//输出：[2,1,3]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数范围是 [0, 104]
// 0 <= Node.val <= 104
// 题目数据 保证 输入的树是一棵二叉搜索树。
//
//
//
//
// 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
// Related Topics 树
// 👍 131 👎 0


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class S449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) {
            return "";
        }
        return root.val + "#" + serialize(root.left) + "#" + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        Deque<Integer> nums = new ArrayDeque<>();
        for (String s : data.split("#")) {
            if (s.isEmpty()) {
                continue;
            }
            nums.add(Integer.valueOf(s));
        }

        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }

    private TreeNode helper(int lower, int upper, Deque<Integer> nums) {
        if (nums.isEmpty()) {
            return null;
        }
        int val = nums.getFirst();
        if (val < lower || val > upper) {
            return null;
        }
        nums.removeFirst();
        TreeNode root = new TreeNode(val);
        root.left = helper(lower, val, nums);
        root.right = helper(val, upper, nums);
        return root;
    }


    // Encodes integer to bytes string
    public String intToString(int x) {
        char[] bytes = new char[4];
        for (int i = 3; i > -1; --i) {
            bytes[3 - i] = (char) (x >> (i * 8) & 0xff);
        }
        return new String(bytes);
    }

    // Decodes bytes string to integer
    public int stringToInt(String bytesStr) {
        int result = 0;
        for (char b : bytesStr.toCharArray()) {
            result = (result << 8) + (int) b;
        }
        return result;
    }

    public static void main(String[] args) {
        S449 sou = new S449();
        String tmp = sou.intToString(10);
        int tmpint = sou.stringToInt(tmp);
        System.out.println("intToString:" + tmp + " stringToInt:" + tmpint);
    }

}
