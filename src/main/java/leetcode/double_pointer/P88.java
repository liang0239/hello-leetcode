package leetcode.double_pointer;
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//
//
// 示例 2：
//
//
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//
//
//
//
// 提示：
//
//
// nums1.length == m + n
// nums2.length == n
// 0 <= m, n <= 200
// 1 <= m + n <= 200
// -109 <= nums1[i], nums2[i] <= 109
//
// Related Topics 数组 双指针
// 👍 803 👎 0

import leetcode.tree.S103;

public class P88 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (null == nums2 || nums2.length < 1){
            return;
        }
        int len = m + n;
        while (len > 0){
            if (n > 0 && m>0){
                if (nums1[m - 1] > nums2[n - 1]){
                    nums1[len - 1] = nums1[m - 1];
                    m--;
                }else {
                    nums1[len - 1] = nums2[n - 1];
                    n--;
                }
            }else if (n > 0){
                nums1[len - 1] = nums2[n - 1];
                n--;
            }else{
                nums1[len - 1] = nums1[m - 1];
                m--;
            }
            len--;

        }

    }


    public static void main(String[] args) {
        P88 p88 = new P88();
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        p88.merge(nums1, 3, nums2, 3);
        for (int tmp : nums1) {
            System.out.println(tmp);
        }

    }
}
