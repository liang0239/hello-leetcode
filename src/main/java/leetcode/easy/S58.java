package leetcode.easy;

//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
//
//
//
// 示例 1：
//
//
//输入：s = "Hello World"
//输出：5
//
//
// 示例 2：
//
//
//输入：s = "   fly me   to   the moon  "
//输出：4
//
//
// 示例 3：
//
//
//输入：s = "luffy is still joyboy"
//输出：6
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅有英文字母和空格 ' ' 组成
// s 中至少存在一个单词
//
// Related Topics 字符串
// 👍 389 👎 0

/**
 * @author LH
 * @create 2021-10-14 17:42
 * @description
 **/
public class S58 {
    public int lengthOfLastWord(String s) {
//        String[] strs = s.split(" ");
//        if (strs.length < 1){
//            return 0;
//        }
//
//        return strs[strs.length - 1].length();

        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;

        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;

        return end - start;
    }

    public static void main(String[] args){
        S58 sou = new S58();
        String s = "   fly me   to   the moon  ";

        System.out.println(sou.lengthOfLastWord(s));


    }
}
