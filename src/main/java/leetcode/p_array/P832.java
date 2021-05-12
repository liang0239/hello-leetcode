package leetcode.p_array;
//给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
//
// 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
//
// 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
//
//
//
// 示例 1：
//
//
//输入：[[1,1,0],[1,0,1],[0,0,0]]
//输出：[[1,0,0],[0,1,0],[1,1,1]]
//解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
//     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
//
//
// 示例 2：
//
//
//输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
//     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//
//
//
//
// 提示：
//
//
// 1 <= A.length = A[0].length <= 20
// 0 <= A[i][j] <= 1
//
// Related Topics 数组
// 👍 251 👎 0

public class P832 {

    public static void main(String[] args) {
        P832 sou = new P832();
        String s = "abcdddeeeeaabbbcd";
    }


    public int[][] flipAndInvertImage(int[][] image) {
        int row = image.length, col = image[0].length;
        for (int r = 0; r < row; r++){
            int left = 0, right = col - 1;
            while (left < right){
                int tmp = image[r][left];
                image[r][left] = image[r][right];
                image[r][right] = tmp;
                left++;
                right--;
            }
        }
        for (int r = 0; r < row; r++){
            for (int c = 0; c < col; c++){
                int x = image[r][c];
                if (x == 1){
                    image[r][c] = 0;
                }else if (x == 0){
                    image[r][c] = 1;
                }
            }
        }

        return image;
    }

}

