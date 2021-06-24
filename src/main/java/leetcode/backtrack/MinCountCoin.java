package leetcode.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//result = []
//def backtrack(路径, 选择列表):
//    if 满足结束条件:
//        result.add(路径)
//        return
//
//    for 选择 in 选择列表:
//        做选择
//        backtrack(路径, 选择列表)
//        撤销选择
public class MinCountCoin {



    public static void main(String[] args) {
        MinCountCoin backtrack = new MinCountCoin();
        int[] nums = {1,2,3};

    }

    //    自底向上求解
    int getMinCounts1(int k, int[] values){
        int[] memo = new int[k + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;//初始化状态

        for (int v = 1; v <= k; v++){
            int minCount = k + 1;//模拟无穷大
            for (int i = 0; i < values.length; i++){
                int currentValue = values[i];

                if (currentValue > v){
                    continue;//如果当前面值大于剩余硬币总额，那么跳过
                }
                int rest = v - currentValue;
                int restCount = memo[rest];
                if (restCount == -1){
                    continue;//说明组合不可信，跳过
                }
                int kCount = 1 + restCount;//保留最小总额
                if(kCount < minCount){
                    minCount = kCount;
                }

            }

            if (minCount != k + 1){
//                如果是可用组合，记录结果
                memo[v] = minCount;
            }
        }
        return memo[k];
    }

    int getMinCounts(int k, int[] values){
        int[] memo = new int[k + 1];//备忘录
        memo[0] = 0;//初始化状态
        for (int i = 1; i < k + 1; i++){
            memo[i] = k + 1;
        }

        for (int i = 1; i < k + 1; i++){
            for (int coin: values){
                if (i - coin < 0){
                    continue;
                }
                memo[i] = Math.min(memo[i], memo[i - coin] + 1);
            }
        }

        return memo[k] == k + 1 ? -1 : memo[k];
    }
}