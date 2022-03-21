package leetcode.easy;

//编写一个算法来判断一个数 n 是不是快乐数。
//
// 「快乐数」定义为：
//
//
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
// 如果 可以变为 1，那么这个数就是快乐数。
//
//
// 如果 n 是快乐数就返回 true ；不是，则返回 false 。
//
//
//
// 示例 1：
//
//
//输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
//
//
// 示例 2：
//
//
//输入：n = 2
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= n <= 231 - 1
//
// Related Topics 哈希表 数学 双指针
// 👍 716 👎 0


import java.util.HashSet;
import java.util.Set;

/**
 * @author LH
 * @create 2021-11-08 17:42
 * @description
 *
 **/
public class S202 {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)){
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;

    }

    private int getNext(int n) {
        int totalNum = 0;
        while (n > 0){
            int d = n % 10;
            n = n / 10;
            totalNum += d * d;
        }
        return totalNum;
    }

    public boolean isHappy2(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner){
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }

        return fastRunner == 1;

    }


    public static void main(String[] args){
        S202 sou = new S202();
        System.out.println(sou.isHappy2(19));

    }
}
