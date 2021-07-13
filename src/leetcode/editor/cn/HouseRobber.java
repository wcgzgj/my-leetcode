 //你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1305 👎 0

  
  package leetcode.editor.cn;
  public class HouseRobber{
      public static void main(String[] args) {
           Solution solution = new HouseRobber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //方法一：动态规划  带dp数组
    // public int rob(int[] nums) {
    //     if(nums.length<1) return 0;
    //     int len = nums.length;
    //     //因为包含 0~n的所有元素，所以长度是 n+1
    //     int[] dp = new int[len + 1];
    //
    //     //初始化
    //     dp[0]=0;
    //     dp[1]=nums[0];
    //
    //     //状态转移方程：`dp[i]=max{dp[i-1],dp[i-2]+Vi}`
    //     for (int i = 2; i < len + 1; i++) {
    //         //这里要注意，因为nums是从0开始，dp是从1开始，所以nums要提前减1
    //         dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
    //     }
    //
    //     //输出
    //     return dp[len];
    // }

    //方法二：动态规划  不使用dp数组
    // public int rob(int[] nums) {
    //     if (nums.length<1) return 0;
    //     if (nums.length==1) return nums[0];
    //
    //     int len = nums.length;
    //
    //     int prepre=0;
    //     int pre=nums[0];
    //
    //     for (int i = 1; i < len; i++) {
    //         int tmp=Math.max(prepre+nums[i],pre);
    //         prepre=pre;
    //         pre=tmp;
    //     }
    //     return pre;
    // }

      //方法3：回溯
          int max=-1;
      public int rob(int[] nums) {
          if (nums.length==0) return 0;
          //选第一个
          dfs(nums,true,nums[0],1);
          //不选第一个
          dfs(nums,false,0,1);
          return max;
      }

      public void dfs(int[] nums,boolean hasPre,int track,int depth) {
          if (depth==nums.length) {
              if (track>max) {
                  max=track;
              }
              return;
          }
          //如果前一个没有选过
          //当前可选可不选
          if (!hasPre) {
              //选
              dfs(nums,true,track+nums[depth],depth+1);
              //不选
              dfs(nums,false,track,depth+1);
              //参数若要使用隐式的回溯，千万记住，不能使用++
          } else {//如果前一个已经选过了，那当前只能不选
              dfs(nums,false,track,depth+1);
          }
      }
      /*
        时间复杂度是O(2^n)，高的吓人
        但是好歹能跑出部分数据（因为题目性质，无法减枝）
        总算能体会回溯算法的万用性了
       */

}
//leetcode submit region end(Prohibit modification and deletion)

  }
