package leetcode.p_array;
//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
//
//
// 示例 2：
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 100
// 1 <= A[i].length <= 100
// A[i][j] 是小写字母
//
// Related Topics 数组 哈希表
// 👍 208 👎 0

import java.util.*;

public class P1002 {

    public static void main(String[] args) {
        P1002 sou = new P1002();
        String[] A = {"bella","label","roller"};
        System.out.println(sou.commonChars(A));

    }


    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word: A){
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; i++){
                char ch = word.charAt(i);
                freq[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++){
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }
        for (int i = 0; i < 26; i++){
            for (int j = 0; j < minfreq[i]; j++){
                list.add(String.valueOf( (char)(i + 'a')));
            }
        }

        return list;
    }


}

