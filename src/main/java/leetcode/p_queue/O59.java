package leetcode.p_queue;

//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
//
// 示例:
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// 提示：
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
// Related Topics 队列 Sliding Window
// 👍 223 👎 0


import java.util.LinkedList;

public class O59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0){
            return new int[0];
        }
        LinkedList<Integer> q = new LinkedList<>();
        int[] ret = new int[nums.length - k + 1];
//        未形成窗口
        for (int i = 0; i < k; i++){
            while (!q.isEmpty() && q.peekLast() < nums[i]){
                q.removeLast();
            }
            q.addLast(nums[i]);
        }
        ret[0] = q.peekFirst();
//        形成窗口
        for (int i = k; i < nums.length; i++){
            if (!q.isEmpty() && q.peekFirst() == nums[i - k]){
                q.removeFirst();
            }
            while (!q.isEmpty() && q.peekLast() < nums[i]){
                q.removeLast();
            }
            q.addLast(nums[i]);
            ret[i - k + 1] = q.peekFirst();
        }

        return ret;
    }

    public static void main(String[] args) {
        O59 sou = new O59();
        int[] nums = {};
        int k = 0;
        int[] res = sou.maxSlidingWindow(nums, k);
        for (int tmp : res) {
            System.out.println(tmp);
        }

    }
}
