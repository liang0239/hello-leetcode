package leetcode;

import java.util.List;

//这是 LeetCode 645 题，我来描述一下这个题目：
//给一个长度为 N 的数组 nums，其中本来装着 [1..N] 这 N 个元素，无序。但是现在出现了一些错误，
//nums 中的一个元素出现了重复，也就同时导致了另一个元素的缺失。请你写一个算法，找到 nums 中的重复元素和缺失元素的值。

//对于这种数组问题，关键点在于元素和索引是成对儿出现的，常用的方法是排序、异或、映射。
public class S645 {


    int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            // 现在的元素是从 1 开始的
            int index = Math.abs(nums[i] - 1);
            // nums[index] 小于 0 则说明重复访问
            if (nums[index] < 0)
                dup = Math.abs(nums[i]);
            else
                nums[index] *= -1;
        }

        int missing = -1;
        for (int i = 0; i < n; i++)
            // nums[i] 大于 0 则说明没有访问
            if (nums[i] > 0)
                // 将索引转换成元素
                missing = i + 1;

        return new int[]{dup, missing};
    }
}
