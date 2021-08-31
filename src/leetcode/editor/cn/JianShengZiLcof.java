 //给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 290 👎 0

  package leetcode.editor.cn;
  
  public class JianShengZiLcof{
      public static void main(String[] args) {

          Solution solution = new JianShengZiLcof().new Solution();
          System.out.println(solution.cuttingRope(3));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int cuttingRope(int n) {
        // i 为当前的绳子长，j 为剪去的绳子长
        //（j==1 时，对乘积增加没有作用，所以不考虑）
        // 状态转移方程如下:
        // dp[k] 表示长度为 k 的绳子被剪后乘积的最大值
        // j 表示被减去长度为 j 的段
        // dp[i] = max( dp[i] , max( j*(i-j) ,j*dp[i-j] ))
        // dp[2]=1  dp[1]=1
        int[] dp = new int[n + 1];
        dp[1]=1;
        dp[2]=1;
        for (int i = 3; i <=n ; i++) {
            for (int j = 2; j <=i-1; j++) { // 可以减去的长度，无论是 j，还是减去后剩下的长度，都应该大于1，不然没有意义
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
