package leetcode.easy;

//给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
//
//
//
// 示例 1：
//
//
//输入：n = 1
//输出：true
//解释：20 = 1
//
//
// 示例 2：
//
//
//输入：n = 16
//输出：true
//解释：24 = 16
//
//
// 示例 3：
//
//
//输入：n = 3
//输出：false
//
//
// 示例 4：
//
//
//输入：n = 4
//输出：true
//
//
// 示例 5：
//
//
//输入：n = 5
//输出：false
//
//
//
//
// 提示：
//
//
// -231 <= n <= 231 - 1
//
//
//
//
// 进阶：你能够不使用循环/递归解决此问题吗？
// Related Topics 位运算 递归 数学
// 👍 430 👎 0

/**
 * @author LH
 * @create 2021-11-08 17:42
 * @description
 *
 **/
public class S231 {
    static final int BIG = 1 << 30;

//    2的幂的二进制只有一个1，所以可以用是否一次性消除1来判断
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

//
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & -n) == n;
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && BIG % 2 == 0;
    }

    public boolean isPowerOfTwo3(int n){
        long num = 1;
        while (n >= num){
            if (n == num){
                return true;
            }
            num <<= 1;
        }
        return false;
    }


    public static void main(String[] args){
        S231 sou = new S231();

        int n = 4;
        System.out.println(sou.isPowerOfTwo3(n));


        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(-n));
        System.out.println((-n & n) == n);

    }
}
