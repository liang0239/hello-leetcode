package leetcode.double_pointer;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串
// 👍 348 👎 0



public class P125 {


    public boolean isPalindrome(String s) {
        if (null == s || s.isEmpty()){
            return true;
        }
        s = s.toLowerCase();
        int j = s.length();
        int i = 0;
        while (i < j){
            char c1 = s.charAt(i);
            if ( !(Character.isDigit(c1) || Character.isLetter(c1)) ){
                i++;
                continue;
            }
            char c2 = s.charAt(j - 1);
            if ( !(Character.isDigit(c2) || Character.isLetter(c2)) ){
                j--;
                continue;
            }
            if (c1 != c2 ){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }



    public static void main(String[] args) {
        P125 sou = new P125();
        String str = "A man, a plan, a canal: Panama";
//        str = "race a car";
        boolean flag = sou.isPalindrome(str);
        System.out.println(flag);

    }
}
