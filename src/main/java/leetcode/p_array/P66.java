package leetcode.p_array;
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//
//
// 示例 1：
//
//
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
//
//
// 示例 2：
//
//
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
//
//
// 示例 3：
//
//
//输入：digits = [0]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
// Related Topics 数组
// 👍 653 👎 0



public class P66 {

    public static void main(String[] args) {
        P66 sou = new P66();
        int[] nums = {9,9,9};
        for (int tmp: sou.plusOne(nums)) {
            System.out.println(tmp);
        }


    }


    public int[] plusOne(int[] digits) {
        int last = digits.length;
        int tmp = digits[last - 1] + 1;
        while (tmp > 9 && last > 1){
            digits[last - 1] = tmp - 10;
            last--;
            tmp = digits[last - 1] + 1;
        }
        if (tmp > 9 && last <= 1){
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            digits[0] = tmp - 10;
            for(int i = 0; i < digits.length; i++){
                ret[i + 1] = digits[i];
            }
            return ret;
        }
        digits[last - 1] = tmp;
        return digits;
    }
}

