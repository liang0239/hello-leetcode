package leetcode.p_array;
//给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
//
// 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
//
//
//
// 示例 1：
//
//
//
//
//输入：mat = [[1,2,3],
//            [4,5,6],
//            [7,8,9]]
//输出：25
//解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
//请注意，元素 mat[1][1] = 5 只会被计算一次。
//
//
// 示例 2：
//
//
//输入：mat = [[1,1,1,1],
//            [1,1,1,1],
//            [1,1,1,1],
//            [1,1,1,1]]
//输出：8
//
//
// 示例 3：
//
//
//输入：mat = [[5]]
//输出：5
//
//
//
//
// 提示：
//
//
// n == mat.length == mat[i].length
// 1 <= n <= 100
// 1 <= mat[i][j] <= 100
//
// Related Topics 数组
// 👍 30 👎 0

public class P1572 {

    public static void main(String[] args) {
        P1572 sou = new P1572();
        int[][] mat = {
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1}
        };

        System.out.println(sou.diagonalSum(mat));

    }


    public int diagonalSum(int[][] mat) {
        int rows = mat.length, cols = mat[0].length, sum = 0;
        int r = 0, c = 0;
        while (r < rows && c < rows){
            sum += mat[r++][c++];
        }
        r = rows - 1;
        c = 0;
        while (r >= 0 && c < cols){
            sum += mat[r--][c++];
        }
        if (rows % 2 != 0){
            r = rows / 2;
            c = cols / 2;
            sum -= mat[r][c];
        }

        return sum;
    }
}

