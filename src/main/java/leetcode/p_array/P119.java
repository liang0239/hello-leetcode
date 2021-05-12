package leetcode.p_array;
//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
//
//
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。
//
// 示例:
//
// 输入: 3
//输出: [1,3,3,1]
//
//
// 进阶：
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？
// Related Topics 数组
// 👍 273 👎 0


import java.util.ArrayList;
import java.util.List;

public class P119 {

    public static void main(String[] args) {
        P119 sou = new P119();
        System.out.println(sou.getRow1(3));

    }


    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++){
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j<=i; j++){
                if (j == 0 || j == i){
                    cur.add(1);
                }else {
                    cur.add(pre.get(j) + pre.get(j - 1));
                }
            }
            pre = cur;
        }

        return pre;
    }

    public List<Integer> getRow1(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++){
            row.add(0);
            for (int j = i; j > 0; j--){
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }



    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            List<Integer> data = new ArrayList<>();
            ret.add(data);
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    data.add(1);
                }else{
                    List<Integer> tmp = ret.get(i - 1);
                    data.add(tmp.get(j - 1) + tmp.get(j));
                }
            }
        }

        return ret;
    }
}

