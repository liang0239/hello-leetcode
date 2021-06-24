package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class HelloWorld {
    public static void main(String[] args) {

//        int num = 10;
//        String str = Integer.toBinaryString(num);
//        System.out.println(str);
//
//        String s = "";
//        for (int n = num; n > 0; n /= 2) {
//            s = (n % 2) + s;
//        }
//        System.out.println(s);
//
//        int numZero = trailingZerores(10);
//        System.out.println(numZero);

    }

    //    输入一个非负整数 n，请你计算阶乘 n! 的结果末尾有几个 0。
//    n! 最多可以分解出多少个因子 5？
    public static int trailingZerores(int n) {
        int res = 0;
        long divisor = 5;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }

    // 逻辑不变，数据类型全部改成 long
    long trailingZeroes(long n) {
        long res = 0;
        for (long d = n; d / 5 > 0; d = d / 5) {
            res += d / 5;
        }
        return res;
    }

    //    现在是给你一个非负整数 K，问你有多少个 n，使得 n! 结果末尾有 K 个 0。
    /* 主函数 */
    long preimageSizeFZF(int K) {
        // 左边界和右边界之差 + 1 就是答案
        return right_bound(K) - left_bound(K) + 1;
    }

    /* 搜索 trailingZeroes(n) == K 的左侧边界 */
    long left_bound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    /* 搜索 trailingZeroes(n) == K 的右侧边界 */
    long right_bound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo - 1;
    }


    // 返回区间 [2, n) 中有几个素数
    // 比如 countPrimes(10) 返回 4
    // 因为 2,3,5,7 是素数
    int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++)
            if (isPrim[i])
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }

    //    LeetCode 372 题 Super Pow，让你进行巨大的幂运算，然后求余数。
//    对乘法的结果求模，等价于先对每个因子都求模，然后对因子相乘的结果再求模。
    int base = 1337;

    // 计算 a 的 k 次方然后与 base 求模的结果
    int mypow(int a, int k) {
        // 对因子求模
        a %= base;
        int res = 1;
        for (int _ = 0; _ < k; _++) {
            // 这里有乘法，是潜在的溢出点
            res *= a;
            // 对乘法结果求模
            res %= base;
        }
        return res;
    }

    int superPow(int a, LinkedList<Integer> list) {
        if (list.isEmpty()) return 1;
        int last = list.pollLast();

        int part1 = mypow(a, last);
        int part2 = mypow(superPow(a, list), 10);
        // 每次乘法都要求模
        return (part1 * part2) % base;
    }

    //    如何高效求幂
    int mypow1(int a, int k) {
        if (k == 0) return 1;
        a %= base;

        if (k % 2 == 1) {
            // k 是奇数
            return (a * mypow1(a, k - 1)) % base;
        } else {
            // k 是偶数
            int sub = mypow1(a, k / 2);
            return (sub * sub) % base;
        }
    }

}
