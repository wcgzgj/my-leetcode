 //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 1774 👎 0

  package leetcode.editor.cn;
  
  public class ClimbingStairs{
      public static void main(String[] args) {
           Solution solution = new ClimbingStairs().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        // 方法一、空间不进行优化
        //if (n==1) return 1;
        //int[] steps = new int[n + 1];
        //steps[1]=1;
        //steps[2]=2;
        //for (int i = 3; i <= n; i++) {
        //    steps[i]=steps[i-1]+steps[i-2];
        //}
        //return steps[n];

        if (n==1) return 1;
        if (n==2) return 2;
        // 一阶台阶一种方法
        int prepre=1;
        // 两阶台阶两种方法
        int pre=2;
        // 记录当前位置的值
        int res=-1;
        for (int i = 3; i <= n; i++) {
            res = prepre + pre;
            prepre=pre;
            pre=res;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
