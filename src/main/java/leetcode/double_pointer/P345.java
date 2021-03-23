package leetcode.double_pointer;
//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
//
//
//
// 示例 1：
//
// 输入："hello"
//输出："holle"
//
//
// 示例 2：
//
// 输入："leetcode"
//输出："leotcede"
//
//
//
// 提示：
//
//
// 元音字母不包含字母 "y" 。
//
// Related Topics 双指针 字符串
// 👍 148 👎 0




public class P345 {


    public String reverseVowels(String s) {
//        A、E、I、O、U通常都是元音字母
        String yuanYin = "AEIOUaeiou";
        if (null == s || s.isEmpty()){
            return s;
        }
        char[] strs = s.toCharArray();
        int len = s.length();
        int l = 0, r = len - 1;
        while (l < r){
            while (l < len && !isYuanYin(strs[l], yuanYin)){
                l++;
            }
            if (l == len){
                break;
            }
            while (r < len && !isYuanYin(strs[r], yuanYin)){
                r--;
            }
            if (r < l){
                break;
            }
            System.out.println("l:"+l+"\t"+strs[l]);
            System.out.println("r:"+r+"\t"+strs[r]);
            char tmp = strs[l];
            strs[l] = strs[r];
            strs[r] = tmp;
            l++;
            r--;
        }

        return new String(strs);
    }

    private boolean isYuanYin(char c, String yuanYin) {
        String tmp = ""+c;
        if (yuanYin.contains(tmp)){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        P345 sou = new P345();
        String s = "leetcode";
        System.out.println(sou.reverseVowels(s));


    }
}
