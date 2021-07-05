package leetcode.tree;
//给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
//
// 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
//
// 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿
//的周长。
//
//
//
// 示例 1：
//
//
//
//
//输入：grid = [
// [0,1,0,0],
// [1,1,1,0],
// [0,1,0,0],
// [1,1,0,0]
// ]
//输出：16
//解释：它的周长是上面图片中的 16 个黄色的边
//
// 示例 2：
//
//
//输入：grid = [[1]]
//输出：4
//
//
// 示例 3：
//
//
//输入：grid = [[1,0]]
//输出：4
//
//
//
//
// 提示：
//
//
// row == grid.length
// col == grid[i].length
// 1 <= row, col <= 100
// grid[i][j] 为 0 或 1
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵
// 👍 415 👎 0


public class S463 {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};

//    迭代
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int sum = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 1){
                    int cnt = 0;
                    for (int k = 0; k < 4; k++){
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if (tx < 0 || tx >= rows  || ty < 0 || ty >= cols || grid[tx][ty] == 0){
                            cnt++;
                        }
                    }
                    sum += cnt;
                }

            }
        }

        return sum;
    }

//    深度优先搜索
    public int islandPerimeter1(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int sum = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){

                if (grid[i][j] == 1){
                    sum += dfs(i, j, grid, rows, cols);
                }
            }
        }

        return sum;
    }

    private int dfs(int x, int y, int[][] grid, int rows, int cols) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == 0){
            return 1;
        }
        if (grid[x][y] == 2){//防止重复
            return 0;
        }
        grid[x][y] = 2;
        int res = 0;
        for (int i = 0; i < 4; i++){
            int tx = x + dx[i];
            int ty = y + dy[i];
            res += dfs(tx, ty, grid, rows, cols);
        }

        return res;
    }

    public static void main(String[] args) {
        S463 sou = new S463();
        int[][] grid = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        System.out.println(sou.islandPerimeter1(grid));
    }

}
