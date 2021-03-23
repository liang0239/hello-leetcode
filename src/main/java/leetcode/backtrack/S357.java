package leetcode.backtrack;
//给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
//
// 示例:
//
// 输入: 2
//输出: 91
//解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
//
// Related Topics 数学 动态规划 回溯算法
// 👍 101 👎 0


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S357 {
    public int countNumbersWithUniqueDigits(int n) {
        double size = Math.pow(10,n);
        int num = 0;
        for (int i=0; i< size; i++){
            if (isSame(i)){
                continue;
            }
            num++;
        }
        return num;
    }

    private boolean isSame(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        if (len < 2){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++){
            int tmp = str.charAt(i) - '0';
            if (set.contains(tmp)){
                return true;
            }
            set.add(tmp);
        }
        return false;
    }


    public static void main(String[] args) {
        S357 sou = new S357();
//1、10、91、739、5275
        System.out.println(sou.countNumbersWithUniqueDigits(4));

    }
}
