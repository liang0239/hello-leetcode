package leetcode.p_array;
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
//
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。
//
// 示例:
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// Related Topics 数组
// 👍 468 👎 0

// [1],
// [1,1],
// [1,2,1],
// [1,3,3,1],
// [1,4,6,4,1]

import java.util.ArrayList;
import java.util.List;

public class P118 {

    public static void main(String[] args) {
        P118 sou = new P118();
        List<List<Integer>> ret = sou.generate(5);
        for (List<Integer> list: ret ){
            System.out.println(list);
        }

    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            List<Integer> data = new ArrayList<>();
            ret.add(data);
            for (int j = 0; j < i+1; j++){
                System.out.println(i+"\t"+j);
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

