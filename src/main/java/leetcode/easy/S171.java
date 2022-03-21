package leetcode.easy;

//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
//
//
//
// 例如，
//
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    ...
//
//
//
//
// 示例 1:
//
//
//输入: columnTitle = "A"
//输出: 1
//
//
// 示例 2:
//
//
//输入: columnTitle = "AB"
//输出: 28
//
//
// 示例 3:
//
//
//输入: columnTitle = "ZY"
//输出: 701
//
// 示例 4:
//
//
//输入: columnTitle = "FXSHRXW"
//输出: 2147483647
//
//
//
//
// 提示：
//
//
// 1 <= columnTitle.length <= 7
// columnTitle 仅由大写英文组成
// columnTitle 在范围 ["A", "FXSHRXW"] 内
//
// Related Topics 数学 字符串
// 👍 291 👎 0


/**
 * @author LH
 * @create 2021-10-14 17:42
 * @description
 **/
public class S171 {
    public int titleToNumber(String columnTitle) {
        int length = columnTitle.length();
        int num = 0;
        for (int i = 0; i < length; i++){
            int a0 = columnTitle.charAt(i) - 'A' + 1;
            num += a0 * Math.pow(26, length - i -1);
        }

        return num;
    }

    public static void main(String[] args){
        S171 sou = new S171();
        System.out.println(sou.titleToNumber("FXSHRXW"));


    }
}
