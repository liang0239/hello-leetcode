package leetcode.p_array;
//有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
//
// 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
//
// 示例 1:
//
//
//输入:
//bits = [1, 0, 0]
//输出: True
//解释:
//唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
//
//
// 示例 2:
//
//
//输入:
//bits = [1, 1, 1, 0]
//输出: False
//解释:
//唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
//
//
// 注意:
//
//
// 1 <= len(bits) <= 1000.
// bits[i] 总是0 或 1.
//
// Related Topics 数组
// 👍 174 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P717 {

    public static void main(String[] args) {
        P717 sou = new P717();
        int[] nums = {1, 1, 1, 0};
        System.out.println(sou.isOneBitCharacter(nums));
    }


    public boolean isOneBitCharacter(int[] bits) {
        if (null == bits || bits.length < 2){
            return true;
        }
        int n = bits.length, i = 0;
        while (i < n){
            if (bits[i] == 1){
                i += 2;
            }else {
                i++;
            }
            if (n - i == 1){
                return true;
            }
        }

        return false;
    }

}

