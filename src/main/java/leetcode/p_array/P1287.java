package leetcode.p_array;
//给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
//
// 请你找到并返回这个整数
//
//
//
// 示例：
//
//
//输入：arr = [1,2,2,6,6,6,6,7,10]
//输出：6
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 10^4
// 0 <= arr[i] <= 10^5
//
// Related Topics 数组
// 👍 42 👎 0


public class P1287 {

    public static void main(String[] args) {
        P1287 sou = new P1287();
        int[] nums = {1,2,2,6,6,6,6,7,10};
        System.out.println(sou.findSpecialInteger1(nums));

    }


    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        int cur = arr[0], cnt = 0;
        for (int i = 0; i < len; i++){
            if (arr[i] == cur){
                cnt++;
                if (cnt * 4 > len){
                    return cur;
                }
            }else {
                cur = arr[i];
                cnt = 1;
            }
        }

        return -1;
    }

    public int findSpecialInteger1(int[] arr) {
        int n = arr.length;
        int span = n / 4 + 1;
        for (int i = 0; i < n; i += span){
            int cur = arr[i], cnt = 0, j = i;
            while (j < n && cur == arr[j++] ){
                cnt++;
            }
            if (cnt > span){
                return cur;
            }
            j = i - 1;
            while (j > 0 && arr[j--] == cur){
                cnt++;
            }
            if (cnt > span){
                return cur;
            }
        }

        return -1;
    }
}

