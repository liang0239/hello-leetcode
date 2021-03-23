package leetcode.double_pointer;
//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。
//
// 示例:
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
//
// 说明:
//
//
// A.length == n + m
//
// Related Topics 数组 双指针
// 👍 100 👎 0


public class M1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        int len = n + m;
        while (len > 0){
            if (n > 0 && m > 0){
                if (A[m - 1] >= B[n - 1]){
                    A[len - 1] = A[m - 1];
                    m--;
                }else {
                    A[len - 1] = B[n - 1];
                    n--;
                }
            }else if (m > 0){
                A[len - 1] = A[m - 1];
                m--;
            }else {
                A[len - 1] = B[n - 1];
                n--;
            }
            len--;
        }

    }

    public static void main(String[] args) {
        M1001 sou = new M1001();
        int[] A = {1}, B = {};
        int m = 1, n = 0;
        sou.merge(A, m, B, n);


    }
}
