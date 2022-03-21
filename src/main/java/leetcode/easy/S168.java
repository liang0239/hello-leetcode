package leetcode.easy;

//给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
//
// 例如：
//
//
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28
//...
//
//
//
//
// 示例 1：
//
//
//输入：columnNumber = 1
//输出："A"
//
//
// 示例 2：
//
//
//输入：columnNumber = 28
//输出："AB" = 1*26 + 2*1
//
//
// 示例 3：
//
//
//输入：columnNumber = 701
//输出："ZY"
//
//
// 示例 4：
//
//
//输入：columnNumber = 2147483647
//输出："FXSHRXW"
//
//
//
//
// 提示：
//
//
// 1 <= columnNumber <= 231 - 1
//
// Related Topics 数学 字符串
// 👍 465 👎 0

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LH
 * @create 2021-10-14 17:42
 * @description
 **/
public class S168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0){
            int a0 = (columnNumber - 1) % 26 + 1;
            builder.append((char)(a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }

        return builder.reverse().toString();
    }

    public String convertToTitle1(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber != 0){
            columnNumber--;
            builder.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args){
        S168 sou = new S168();
        System.out.println(sou.convertToTitle1(28));


    }
}
