package leetcode.easy;

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
//
//
// 示例 1：
//
//
//输入：x = 123
//输出：321
//
//
// 示例 2：
//
//
//输入：x = -123
//输出：-321
//
//
// 示例 3：
//
//
//输入：x = 120
//输出：21
//
//
// 示例 4：
//
//
//输入：x = 0
//输出：0
//
//
//
//
// 提示：
//
//
// -231 <= x <= 231 - 1
//
// Related Topics 数学
// 👍 3150 👎 0

/**
 * @author LH
 * @create 2021-10-14 17:42
 * @description
 **/
public class S7 {
    public int reverse(int x) {

        boolean flag = false;
        if (x < 0){
            flag = true;
            x = -x;
        }
        long r = 0 , t = 0;
        while (x > 0){
            t = x % 10;
            r = r * 10 + t;
            x = x / 10;
        }
        if (flag){
            r = -r;
        }
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE){
            return 0;
        }

        return (int)r;
    }

    public static void main(String[] args){
        S7 sou = new S7();
        int x = 1534236469;
        System.out.println(sou.reverse(x));
    }
}
