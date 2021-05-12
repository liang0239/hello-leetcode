package leetcode.p_array;
//给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
//
// 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
//
//
// arr.length >= 3
// 在 0 < i < arr.length - 1 条件下，存在 i 使得：
//
// arr[0] < arr[1] < ... arr[i-1] < arr[i]
// arr[i] > arr[i+1] > ... > arr[arr.length - 1]
//
// 示例 1：
//
//
//输入：arr = [2,1]
//输出：false
//
//
// 示例 2：
//
//
//输入：arr = [3,5,5]
//输出：false
//
//
// 示例 3：
//
//
//输入：arr = [0,3,2,1]
//输出：true
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 104
// 0 <= arr[i] <= 104
//
// Related Topics 数组
// 👍 140 👎 0


public class P941 {

    public static void main(String[] args) {
        P941 sou = new P941();
        int[] deck = {0,3,1};
        int[] arr = {1,7,9,5,4,1,2};
        System.out.println(sou.validMountainArray(deck));
    }


    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        if (len < 3){
            return false;
        }
        if (arr[1] <= arr[0]){
            return false;
        }
        int top = -1, i = 1;
        while (i < len  && arr[i - 1] < arr[i]){
            i++;
        }
        top = arr[i - 1];
        if (top <= arr[len - 1]){
            return false;
        }
        while (i < len - 1 && arr[i] > arr[i + 1] ){
            i++;
        }

        return i == len - 1;
    }

}

