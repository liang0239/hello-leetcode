package leetcode.double_pointer;
//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
//
// 注意：如果对空文本输入退格字符，文本继续为空。
//
//
//
// 示例 1：
//
//
//输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
//
//
// 示例 2：
//
//
//输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
//
//
// 示例 3：
//
//
//输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
//
//
// 示例 4：
//
//
//输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。
//
//
//
// 提示：
//
//
// 1 <= S.length <= 200
// 1 <= T.length <= 200
// S 和 T 只含有小写字母以及字符 '#'。
//
//
//
//
// 进阶：
//
//
// 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
//
//
//
// Related Topics 栈 双指针
// 👍 273 👎 0


import javafx.beans.binding.Bindings;

public class P844 {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, skipS = 0;
        int j = T.length() - 1, skipT = 0;

        while (i >= 0 || j >= 0) {

            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    i--;
                    skipS++;
                } else if (skipS > 0) {
                    i--;
                    skipS--;
                } else {
                    break;
                }

            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    j--;
                    skipT++;
                } else if (skipT > 0) {
                    j--;
                    skipT--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }


        return true;
    }

    public boolean backspaceCompare1(String S, String T) {

        return build(S).equals(build(T));
    }

    private String build(String s) {
        StringBuffer buffer = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch != '#') {
                buffer.append(ch);
            } else {
                if (buffer.length() > 0) {
                    buffer.deleteCharAt(buffer.length() - 1);
                }
            }
        }
        return buffer.toString();
    }


    public static void main(String[] args) {
        P844 sou = new P844();
        String S = "ab#c", T = "ad#c";
        boolean flag = sou.backspaceCompare(S, T);
        System.out.println(flag);

    }
}
