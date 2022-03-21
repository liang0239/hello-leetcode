package leetcode.easy;

//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
// 示例 1:
//
// 输入: a = "11", b = "1"
//输出: "100"
//
// 示例 2:
//
// 输入: a = "1010", b = "1011"
//输出: "10101"
//
//
//
// 提示：
//
//
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。
//
// Related Topics 位运算 数学 字符串 模拟
// 👍 687 👎 0


/**
 * @author LH
 * @create 2021-10-14 17:42
 * @description
 **/
public class S67 {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder builder = new StringBuilder();
        int num = 0;
        while (i >= 0 || j >= 0){
            if (i >= 0){
                if ('1'==a.charAt(i)){
                    num += 1;
                }
                i--;
            }
            if (j >= 0){
                if ('1'==b.charAt(j)){
                    num += 1;
                }
                j--;
            }
            if (num <= 1){
                builder.append(num);
                num = 0;
            }else {
                builder.append(num - 2);
                num = 1;
            }
        }
        if (num > 0){
            builder.append(num);
        }
        if (builder.length() > 0){
            return builder.reverse().toString();
        }
        return null;
    }
    public String addBinary1(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

    public static void main(String[] args){
        S67 sou = new S67();
        String a = "11", b = "1";
        System.out.println(sou.addBinary(a, b));


    }
}
