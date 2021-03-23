package leetcode.search.binary;

//744. 寻找比目标字母大的最小字母
//给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
//
//在比较时，字母是依序循环出现的。举个例子：
//
//如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
//
//
//示例：
//
//输入:
//letters = ["c", "f", "j"]
//target = "a"
//输出: "c"
//
//输入:
//letters = ["c", "f", "j"]
//target = "c"
//输出: "f"
//
//输入:
//letters = ["c", "f", "j"]
//target = "d"
//输出: "f"
//
//输入:
//letters = ["c", "f", "j"]
//target = "g"
//输出: "j"
//
//输入:
//letters = ["c", "f", "j"]
//target = "j"
//输出: "c"
//
//输入:
//letters = ["c", "f", "j"]
//target = "k"
//输出: "c"
//
public class S744 {
//    方法一：记录存在的字母，从小到大循环扫描
    public char nextGreatestLetter1(char[] letters, char target) {
        boolean[] seen = new boolean[26];
        for (char c : letters) {
            seen[c - 'a'] = true;
        }
        while (true){
            target++;
            if (target > 'z'){
                target = 'a';
            }
            if (seen[target - 'a']){
                return target;
            }
        }

    }
//    方法二：线性扫描
    public char nextGreatestLetter2(char[] letters, char target) {
        for (char c :
                letters) {
            if (c > target){
                return c;
            }
        }
        return letters[0];
    }
    public char nextGreatestLetter3(char[] letters, char target) {
        int left = 0, right = letters.length;

        while (left < right){
            int mid = left + (right - left)/2;
            if (letters[mid] <= target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return letters[right % letters.length];
    }



    public static void main(String[] args){
        S744 sou = new S744();
        char[] letters = {'c', 'f', 'j'};
        char target = 'g';
        System.out.println(sou.nextGreatestLetter3(letters, target));

    }
    
}
