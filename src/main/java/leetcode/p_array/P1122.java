package leetcode.p_array;
//给你两个数组，arr1 和 arr2，
//
//
// arr2 中的元素各不相同
// arr2 中的每个元素都出现在 arr1 中
//
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。
//
//
//
// 示例：
//
//
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
//
//
//
//
// 提示：
//
//
// 1 <= arr1.length, arr2.length <= 1000
// 0 <= arr1[i], arr2[i] <= 1000
// arr2 中的元素 arr2[i] 各不相同
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中
//
// Related Topics 排序 数组
// 👍 166 👎 0

public class P1122 {

    public static void main(String[] args) {
        P1122 sou = new P1122();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr2 = {2, 1, 4, 3, 9, 6};
        for (int num : sou.relativeSortArray(arr1, arr2)) {
            System.out.println(num);
        }
    }


    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[1001];
        for (int num : arr1) {
            arr[num]++;
        }
        int t = 0;
        for (int i = 0, j = 0; i < arr2.length; i++) {
            int num = arr2[i];
            while (arr[num]-- > 0) {
                arr1[j++] = num;
            }
            t = j;
        }
        System.out.println("t:" + t);
        for (int i = 0, j = t; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                arr1[j++] = i;
            }
        }

        return arr1;
    }

}

