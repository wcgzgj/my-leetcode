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
// 👍 200 👎 0

  
  package leetcode.editor.cn;

 import java.util.ArrayList;
 import java.util.HashSet;
 import java.util.List;
 import java.util.Set;

 public class BinaryWatch{
      public static void main(String[] args) {
           Solution solution = new BinaryWatch().new Solution();
          // List<String> res = solution.readBinaryWatch(1);
          // System.out.println(res.toString());
          String[] arr1 = {"3:00", "5:00", "9:00", "1:01", "1:02", "1:04", "1:08", "1:16", "1:32", "6:00", "10:00", "2:01", "2:02", "2:04", "2:08", "2:16", "2:32", "12:00", "4:01", "4:02", "4:04", "4:08", "4:16", "4:32", "8:01", "8:02", "8:04", "8:08", "8:16", "8:32", "0:03", "0:05", "0:09", "0:17", "0:33", "0:06", "0:10", "0:18", "0:34", "0:12", "0:20", "0:36", "0:24", "0:40", "0:48"};
          String[] arr2 = {"0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"};
          List<String> list = solution.getLeftOut(arr1, arr2);
          System.out.println(list);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      int[] hours = {1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
      int[] minutes = {0, 0, 0, 0, 1, 2, 4, 8, 16, 32};
      List<String> res = new ArrayList<>();
    public List<String> readBinaryWatch(int num) {
        dfs(num,0,0,0);
        return res;
    }

    public void dfs(int num,int index,int hour,int min) {
        //边界
        if (num==0) {
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(":");
            if (min<10) {
                sb.append("0").append(min);
            } else {
                sb.append(min);
            }
            res.add(sb.toString());
            return;
        }

        //剪枝
        if (hour>11 || min>59 || index>=10) return;


        //选择
        //因为是在函数参数中进行改变的，所以回溯不是显式的
        dfs(num-1,index+1,hour+hours[index],min+minutes[index]);

        //不选择
        dfs(num,index+1,hour,min);

    }

    /*
    解答失败: 测试用例:1
    测试结果:["1:00","2:00","4:00","8:00","0:01","0:02","0:04","0:08","0:16"]
    期望结果:["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"] stdout:
    和内函数的++问题有关
    内函数中使用++，会影响隐式的回溯
     */

         /*
         解答失败: 测试用例:2
         测试结果:["3:00","5:00","9:00","1:01","1:02","1:04","1:08","1:16","1:32","6:00","10:00","2:01","2:02","2:04","2:08","2:16","2:32","12:00","4:01","4:02","4:04","4:08","4:16","4:32","8:01","8:02","8:04","8:08","8:16","8:32","0:03","0:05","0:09","0:17","0:33","0:06","0:10","0:18","0:34","0:12","0:20","0:36","0:24","0:40","0:48"]
         期望结果:["0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"] stdout:
          */

          public List<String> getLeftOut(String[] arr1,String[] arr2) {
              Set<String> set = new HashSet<>();
              for (int i = 0; i < arr2.length; i++) {
                  set.add(arr2[i]);
              }
              List<String> list = new ArrayList<>();
              for (int i = 0; i < arr1.length; i++) {
                  if (!set.contains(arr1[i])) {
                      list.add(arr1[i]);
                  }
              }
              return list;
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
