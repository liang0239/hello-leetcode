package leetcode.p_array;
//给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
//
// 每次「迁移」操作将会引发下述活动：
//
//
// 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
// 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
// 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
//
//
// 请你返回 k 次迁移操作后最终得到的 二维网格。
//
//
//
// 示例 1：
//
//
//
//
//输入：grid = [
// [1,2,3],
// [4,5,6],
// [7,8,9]], k = 1
//输出：[
// [9,1,2],
// [3,4,5],
// [6,7,8]]
//
//
// 示例 2：
//
//
//
//
//输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
//输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
//
//
// 示例 3：
//
//
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
//输出：[[1,2,3],[4,5,6],[7,8,9]]
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m <= 50
// 1 <= n <= 50
// -1000 <= grid[i][j] <= 1000
// 0 <= k <= 100
//
// Related Topics 数组
// 👍 45 👎 0


import java.util.ArrayList;
import java.util.List;

public class P1260 {

    public static void main(String[] args) {
        P1260 sou = new P1260();
        int[][] grip = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        for (List<Integer> tmp : sou.shiftGrid(grip, 1)) {
            System.out.println(tmp);
        }

    }


    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int rows = grid.length, cols = grid[0].length;
        for (int n = 1; n <= k; n++){
            int[][] newGrid = new int[rows][cols];
            // 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
            for (int r = 0; r < rows; r++){
                for (int c = 0; c < cols - 1; c++){
                    newGrid[r][c + 1] = grid[r][c];
                }
            }
            // 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
            for (int r = 0; r < rows - 1; r++){
                newGrid[r + 1][0] = grid[r][cols - 1];
            }
            // 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
            newGrid[0][0] = grid[rows - 1][cols - 1];

            grid = newGrid;

        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int[] arr: grid){
            List<Integer> data = new ArrayList<>();
            for (int tmp: arr){
                data.add(tmp);
            }
            ans.add(data);
        }

        return ans;
    }

}

