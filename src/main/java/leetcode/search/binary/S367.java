package leetcode.search.binary;

//367. 有效的完全平方数
//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
//
//说明：不要使用任何内置的库函数，如  sqrt。
//
//示例 1：
//
//输入：16
//输出：True
//示例 2：
//
//输入：14
//输出：False
public class S367 {
//    二分查找法
    public boolean isPerfectSquare(int num) {
        if (num < 2){
            return true;
        }
        long l = 2, r = num/2, mid, ret;
        while (l <= r){
            mid = l + (r - l)/2;
            ret = mid * mid;
            if (num == ret){
                return true;
            }
            if (ret > num){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return  false;
    }
//    牛顿迭代法
    public boolean isPerfectSquare1(int num){
        if (num < 2){
            return true;
        }
        long x = num / 2;
        while ( x * x > num){
            x = (x + num/x )/2;
        }
        return (x * x == num);
    }



    public static void main(String[] args){
        S367 sou = new S367();
        int num = 808201;
        boolean flag = sou.isPerfectSquare1(num);
        System.out.println(flag);


    }
    
}
