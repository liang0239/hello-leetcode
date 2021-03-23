package leetcode.backtrack;
//输入一个字符串，打印出该字符串中字符的所有排列。
//
//
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
//
//
// 示例:
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
//
//
//
//
// 限制：
//
// 1 <= s 的长度 <= 8
// Related Topics 回溯算法
// 👍 132 👎 0


import java.util.*;

public class O38 {


    public String[] permutation(String s) {
        List<String> res = new LinkedList<>();
        char[] chars = s.toCharArray();
        dfs(0, chars, res);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int start, char[] chars, List<String> res) {
        if (start == chars.length - 1) {
            res.add(String.valueOf(chars)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i < chars.length; i++) {
            if (set.contains(chars[i])) continue; // 重复，因此剪枝
            set.add(chars[i]);
            swap(i, start, chars); // 交换，将 c[i] 固定在第 start 位
            dfs(start + 1, chars, res); // 开启固定第 start + 1 位字符
            swap(i, start, chars); // 恢复交换
        }
    }

    void swap(int a, int b, char[] chars) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

    public static void main(String[] args) {
        O38 sou = new O38();
        String s = "abc";
        String[] strs = sou.permutation(s);
        for (String tmp : strs) {
            System.out.println(tmp);
        }

    }
}
