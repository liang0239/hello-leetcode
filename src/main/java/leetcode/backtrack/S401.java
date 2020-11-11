package leetcode.backtrack;
//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
//
// 每个 LED 代表一个 0 或 1，最低位在右侧。
//
//
//
// 例如，上面的二进制手表读取 “3:25”。
//
// 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
//
//
//
// 示例：
//
// 输入: n = 1
//返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "
//0:32"]
//
//
//
// 提示：
//
//
// 输出的顺序没有要求。
// 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
// 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
// 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
//
// Related Topics 位运算 回溯算法
// 👍 185 👎 0

import java.util.LinkedList;
import java.util.List;

public class S401 {
    int[] nums = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
    public List<String> readBinaryWatch(int num) {
        List<String> dataList = new LinkedList<>();
        int[] visited = new int[10];

        dfs(dataList, num, 0, 0, visited);

        for (String tmp : dataList) {
            System.out.println(tmp);
        }

        return dataList;
    }

    private void dfs(List<String> dataList, int num, int step, int start, int[] visited) {
        if (num == step){//满足条件，退出
            String result = getResult(visited);
            if (null != result){//不合法的排除掉
                dataList.add(result);
            }
            return;
        }
        for (int i=start; i<visited.length; i++){
            visited[i] = 1;//设置
//          TODO  检查是否合法，不合法回退，合法则继续
            dfs(dataList, num, step+1, i+1, visited);
            visited[i] = 0;//恢复
        }

    }

    private String getResult(int[] visited) {
        int hour = 0;
        int mins = 0;
        for (int i=0; i<visited.length; i++){
            if (visited[i]==0){
                continue;
            }
            if (i<4){
                hour += nums[i];
            }else {
                mins += nums[i];
            }
        }
        if (hour > 11){
            return null;
        }else if (mins > 59){
            return null;
        }else if (mins < 10){
            return hour+":0"+mins;
        }else {
            return hour+":"+mins;
        }

    }

    public static void main(String[] args){
        S401 s401 = new S401();
        s401.readBinaryWatch(2);
    }
}
