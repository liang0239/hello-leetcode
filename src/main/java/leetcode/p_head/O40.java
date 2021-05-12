package leetcode.p_head;
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
//
//
// 示例 1：
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
//
//
// 示例 2：
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0]
//
//
//
// 限制：
//
//
// 0 <= k <= arr.length <= 10000
// 0 <= arr[i] <= 10000
//
// Related Topics 堆 分治算法
// 👍 219 👎 0




import java.util.PriorityQueue;

public class O40 {

    public static void main(String[] args) {
        O40 sou = new O40();
        int[] arr = {3,2,1};
        int k = 2;
        int[] ret = sou.getLeastNumbers(arr, k);
        for (int tmp : ret) {
            System.out.println(tmp);
        }

    }


    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int tmp : arr) {
            pq.offer(tmp);
        }
        int[] ret = new int[k];
        for(int i = 0; i < k; i++){
            ret[i] = pq.poll();
        }
        return ret;
    }
}

