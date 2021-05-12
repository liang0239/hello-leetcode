package leetcode.p_array;
//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
//
// 你可以返回任何满足上述条件的数组作为答案。
//
//
//
// 示例：
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
//
//
//
//
// 提示：
//
//
// 2 <= A.length <= 20000
// A.length % 2 == 0
// 0 <= A[i] <= 1000
//
//
//
// Related Topics 排序 数组
// 👍 201 👎 0

public class P922 {

    public static void main(String[] args) {
        P922 sou = new P922();
        int[] deck = {4,2,5,7};

        for (int tmp : sou.sortArrayByParityII(deck) ) {
            System.out.print(tmp);
        }
    }


    public int[] sortArrayByParityII(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int a = 0, b = 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                ans[a] = num;
                a += 2;
            } else {
                ans[b] = num;
                b += 2;
            }
        }
        return ans;
    }

}

