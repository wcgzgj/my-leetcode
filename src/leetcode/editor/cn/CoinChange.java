 //给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 952 👎 0

  
  package leetcode.editor.cn;

 import java.security.PublicKey;

 public class CoinChange{
      public static void main(String[] args) {
           Solution solution = new CoinChange().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //解法一：从上至下，再解决重复子结构
    // public int coinChange(int[] coins, int amount) {
    //     //虽然还是很慢，但是，不消除重叠子问题的话，甚至都过不了
    //     int[] memo = new int[amount + 1];
    //     int res = dp(coins, amount, memo);
    //     return res;
    // }
    //
    // public int dp(int []coins,int amount,int[] memo) {
    //     //base case
    //     if (amount==0) return 0;
    //     if (amount<0) return -1;
    //
    //     int res=Integer.MAX_VALUE;
    //     for (int coin : coins) {
    //         int subProblem=0;
    //         //子问题：如果只要凑amount-coin的钱数，需要多少枚硬币
    //         //通过记忆法，去除重叠子结构，优化时间
    //         if (amount-coin<0) continue;//提前判断子问题的条件，会不会导致数组越界（负界）
    //         if (memo[amount-coin]!=0) {
    //             subProblem=memo[amount-coin];
    //         } else {
    //             memo[amount-coin]=dp(coins, amount-coin, memo);
    //             subProblem=memo[amount-coin];
    //         }
    //         if (subProblem==-1) continue;//子问题不成立
    //         //子问题是少了一枚硬币的情况下
    //         //所以，要当前情况和子问题的结果加一的结果比较
    //         res=Math.min(res,subProblem+1);
    //     }
    //     if (res==Integer.MAX_VALUE) return -1;
    //     return res;
    // }

      //解法二：从下至上
      public int coinChange(int[] coins, int amount) {
          //下标表示钱数    值表示当前钱数（下标）下，最少需要多少枚硬币
          int[] dp = new int[amount + 1];
          for (int i = 0; i < dp.length; i++) {
              dp[i]=amount+1;
          }
          //当钱数为0的时候，肯定只要0个硬币就可以了
          dp[0]=0;
          //外层循环表示每个钱数的可能性
          for (int i = 0; i <=amount; i++) {
              //内层循环表示子问题
              for (int coin : coins) {
                  //如果当前硬币面值，比需要凑的前数还大，直接跳过
                  if (i-coin<0) continue;
                  dp[i]=Math.min(dp[i],dp[i-coin]+1);
              }
          }
          return dp[amount]==amount+1?-1:dp[amount];
      }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
