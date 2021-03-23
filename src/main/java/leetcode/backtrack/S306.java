package leetcode.backtrack;
//累加数是一个字符串，组成它的数字可以形成累加序列。
//
// 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
//
// 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
//
// 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
//
// 示例 1:
//
// 输入: "112358"
//输出: true
//解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
//
//
// 示例 2:
//
// 输入: "199100199"
//输出: true
//解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
//
// 进阶:
//你如何处理一个溢出的过大的整数输入?
// Related Topics 回溯算法
// 👍 117 👎 0


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class S306 {
    public boolean isAdditiveNumber(String num) {
        List<BigInteger> res = new ArrayList<>();
        boolean flag = dfs(num, res);
        System.out.println(res);
        return flag;
    }

    private boolean dfs(String num, List<BigInteger> res) {
        int len = num.length();
        int size = res.size();
        if (size > 2 && res.get(size - 1).compareTo(res.get(size - 2).add(res.get(size - 3))) != 0) {
            return false;
        }
        if (len == 0 && size >= 3) {
            //上两行不能交换，若先判断2，那么111 这个样例就会返回true；
            return true;
        }
        for (int i = 0; i < len; i++) {
            if (num.charAt(0) == '0' && i > 0) {
                break;//可以单个为0，但是不能是以0为开头的多位数字。
            }
            BigInteger a = new BigInteger(num.substring(0, i + 1));
            res.add(a);
            if (dfs(num.substring(i + 1), res)) {
                return true;
            }
            res.remove(res.size() - 1);
        }

        return false;
    }

    /**
     * 思路：
     * 字符串逐位相加，需要进位则进位处理，考虑两个问题：
     * 1、char怎么转换为integer, 减去'0'即可
     * 2、怎么处理对应位相加?反转字符串相加，正确处理进位即可，
     * 这样个位对应个位，十位对应十位，剩余的直接追加
     */
    public String add(String str1, String str2) {
        // 一个字符串为空 直接返回另外一个
        if (str1 == null || "".equals(str1)) {
            return str2;
        }
        if (str2 == null || "".equals(str2)) {
            return str1;
        }

        StringBuilder sb = new StringBuilder();

        // 字符串都不为空时
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int idx1 = arr1.length - 1;
        int idx2 = arr2.length - 1;

        // 缓存是否需要进位
        boolean carry = false;
        // 遍历两个字符串 处理元素相加
        while (idx1 >= 0 && idx2 >= 0) {
            char cur1 = arr1[idx1];
            char cur2 = arr2[idx2];
            // 相加
            int sum = cur1 - '0' + cur2 - '0';
            // 上一次运算是否有进位
            sum = carry ? sum + 1 : sum;
            // 是否需要进位
            carry = sum >= 10 ? true : false;
            // 相加结果 取个位数->字符类型
            sb.append((char) ((sum % 10) + '0'));
            // 索引递减
            idx1--;
            idx2--;
        }

        // 处理剩余的元素
        while (carry || idx1 >= 0 || idx2 >= 0) {
            if (idx1 >= 0) {
                // 当前元素处理
                int sum = arr1[idx1] - '0' + (carry ? 1 : 0);
                // 下次是否需要进位
                carry = sum >= 10 ? true : false;
                // 添加到结果
                sb.append((char) ((sum % 10) + '0'));
                idx1--;
            } else if (idx2 >= 0) {
                // 当前元素处理
                int sum = arr2[idx2] - '0' + (carry ? 1 : 0);
                // 下次是否需要进位
                carry = sum >= 10 ? true : false;
                // 添加到结果
                sb.append((char) ((sum % 10) + '0'));
                idx2--;
            } else {
                sb.append('1');
                carry = false;
            }
        }

        // 反转sb 后返回
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        S306 sou = new S306();
        String num = "199100199";
        boolean flag = sou.isAdditiveNumber(num);
        System.out.println(flag);
        System.out.println(sou.add("1", "9"));


    }
}
