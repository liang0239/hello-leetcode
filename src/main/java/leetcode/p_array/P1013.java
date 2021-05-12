package leetcode.p_array;
//给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
//
// 形式上，如果可以找出索引 i+1 < j 且满足 A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... +
//A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1] 就可以将数组三等分。
//
//
//
// 示例 1：
//
// 输入：[0,2,1,-6,6,-7,9,1,2,0,1]
//输出：true
//解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
//
//
// 示例 2：
//
// 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
//输出：false
//
//
// 示例 3：
//
// 输入：[3,3,6,5,-2,2,5,1,-9,4]
//输出：true
//解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
//
//
//
//
// 提示：
//
//
// 3 <= A.length <= 50000
// -10^4 <= A[i] <= 10^4
//
// Related Topics 数组
// 👍 137 👎 0


public class P1013 {

    public static void main(String[] args) {
        P1013 sou = new P1013();
        int[] nums = {0,0,0,0};
        System.out.println(sou.canThreePartsEqualSum(nums));

    }


    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum % 3 != 0){
            return false;
        }
        int avg = sum / 3, len = arr.length, count = 0;
        for (int i = 0; i < len; i++){
            avg -= arr[i];
            if (avg == 0){
                count++;
                avg = sum / 3;
            }
        }

        return count >= 3;
    }


}

