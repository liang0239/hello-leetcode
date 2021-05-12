package leetcode.p_array;
//在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
//
// 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
//
// 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示
//为 [3,6] 。
//
// 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
//
// 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
//
//
//
// 示例 1：
//
//
//输入：s = "abbxxxxzzy"
//输出：[[3,6]]
//解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
//
//
// 示例 2：
//
//
//输入：s = "abc"
//输出：[]
//解释："a","b" 和 "c" 均不是符合要求的较大分组。
//
//
// 示例 3：
//
//
//输入：s = "abcdddeeeeaabbbcd"
//输出：[[3,5],[6,9],[12,14]]
//解释：较大分组为 "ddd", "eeee" 和 "bbb"
//
// 示例 4：
//
//
//输入：s = "aba"
//输出：[]
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅含小写英文字母
//
// Related Topics 数组
// 👍 109 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P830 {

    public static void main(String[] args) {
        P830 sou = new P830();
        String s = "abcdddeeeeaabbbcd";
        List<List<Integer>> ans = sou.largeGroupPositions1(s);
        for (List<Integer> list: ans){
            System.out.println(list);
        }
    }


    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        char prev = 'A';
        int count = 1, start = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (prev == c){
                count++;
                continue;
            }
            if (start < i && count >= 3){
                ans.add(Arrays.asList(start, i - 1));
            }
            start = i;
            count = 1;
            prev = c;
        }
        if (count >= 3){
            ans.add(Arrays.asList(start, s.length() - 1));
        }

        return ans;
    }

    public List<List<Integer>> largeGroupPositions1(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++){
            if (i == n -1 || s.charAt(i) != s.charAt(i + 1)){
                if (num >= 3){
                    ans.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            }else {
                num++;
            }
        }

        return ans;
    }

}

