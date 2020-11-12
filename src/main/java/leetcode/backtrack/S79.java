package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例:
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false
//
//
//
// 提示：
//
//
// board 和 word 中只包含大写和小写英文字母。
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// 1 <= word.length <= 10^3
//
// Related Topics 数组 回溯算法
// 👍 680 👎 0

public class S79 {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                boolean flag = dfs(board, visited, i, j, word, 0, row, col);
                if (flag){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int r, int c, String word, int w, int row, int col) {
        if (board[r][c] != word.charAt(w)){
            return false;
        }else if (w == word.length() - 1){
            return true;
        }
        visited[r][c] = true;
        boolean result = false;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            int newr = r + dir[0], newc = c + dir[1];
            if (newr >= 0 && newr < row && newc >= 0 && newc < col){
                if (!visited[newr][newc]){
                    boolean flag = dfs(board, visited, newr, newc, word, w+1, row, col);
                    if (flag){
                        result = true;
                        break;
                    }
                }
            }
        }

        visited[r][c] = false;
        return result;
    }


//    dfs + 回溯
    public boolean exist1(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
            return false;
        }

        if (word.charAt(k) != board[i][j]) {
            return false;
        }
        char t = board[i][j];
        board[i][j] = '0';
        boolean res = dfs(board, word, i + 1, j, k + 1) ||
                dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) ||
                dfs(board, word, i, j - 1, k + 1);
        board[i][j] = t;
        return res;
    }


    public static void main(String[] args) {
        S79 sou = new S79();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";

        boolean flag = sou.exist1(board, word);
        System.out.println(flag);

    }
}
