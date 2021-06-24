package leetcode.backtrack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LH
 * @create 2021-05-24 16:09
 * @description 01背包问题
 **/
public class BeiBao01 {

    int dp(int[] w, int[] v, int N, int W){
//        创建备忘录
        int[][] dp = new int[N + 1][W + 1];

        for (int tn = 1; tn < N+1; tn++){
            for (int rw = 1; rw < W+1; rw++){
                if (rw < w[tn]){// 当背包容量小于第tn件物品重量时，只能放入前tn-1件
                    dp[tn][rw] = dp[tn - 1][rw];
                }else {// 当背包容量还大于第tn件物品重量时，进一步作出决策
                    dp[tn][rw] = Math.max(dp[tn - 1][rw], dp[tn - 1][rw - w[tn]] + v[tn]);
                }
            }
        }


        return dp[N][W];
    }

    public static void main(String[] args) {
        int N = 3, W = 5;// 物品的总数，背包能容纳的总重量
        int[] w = {0,3,2,1};//重量
        int[] v = {0,5,2,3};//价值
        BeiBao01 sou = new BeiBao01();
        System.out.println(sou.dp(w, v, N, W));

       
    }

}
