package leetcode.easy;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串
// 👍 1815 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LH
 * @create 2021-10-14 17:42
 * @description
 **/
public class S14 {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length < 1){
            return "";
        }

        String ans = strs[0];
        while (ans.length() > 0){
            int i = 0;
            for (String str : strs) {
                if (!str.startsWith(ans)){
                    break;
                }
                i++;
            }
            if (i == strs.length){
                return ans;
            }
//            System.out.println(ans.length());
            ans = ans.substring(0, ans.length() - 1);
        }

        return ans;
    }

    public static void main(String[] args){
        S14 sou = new S14();
        String[] strs = {"flower","flow","flight"};

        System.out.println(sou.longestCommonPrefix(strs));

    }
}
