 //给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 动态规划 
// 👍 248 👎 0

  
  package leetcode.editor.cn;
  public class NumberOfLongestIncreasingSubsequence{
      public static void main(String[] args) {
           Solution solution = new NumberOfLongestIncreasingSubsequence().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length==0) return 0;
        int[] dp = getDp(nums);
        int max=Integer.MIN_VALUE;
        for (int i : dp) {
            max=Math.max(max,i);
        }
        //说明所有的元素都是一样的
        if (max==1) return nums.length;
        // // int count=0;
        // // for (int i : dp) {
        // //     if (i==max) count++;
        // // }
        // // return count;
        //
        // /**
        //  * 这道题，找的，应该是第二大的个数
        //  */
        // int second=Integer.MIN_VALUE;
        // for (int i : dp) {
        //     if (i<max && i>second) second=i;
        // }
        // int count=0;
        // for (int i : dp) {
        //     if (i==second) count++;
        // }
        // return count;
        int[] arr = new int[max+1];
        for (int i : dp) {
            arr[i]++;
        }
        int res=1;
        for (int i = 1; i <=max; i++) {
            res*=arr[i];
        }
        return res;
    }

          /**
           * 这个获取最长递增子序列长度的方法
           * 是没有问题的
           * 具体的推导，可以看算法小抄 P96
           * @param nums
           * @return
           */
    public int[] getDp(int[] nums) {
        //dp[i]表示，当前位置截止，最长递归子序列的长度
        int[] dp = new int[nums.length];
        if (nums.length==0) return dp;
        dp[0]=1;//第一个位置，最长递增子序列的值，永远是1
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]) {//起码要保证是递增的
                    //为的是找寻在自己之前的，最长的递增子序列长度
                    //dp[i]，即自己，其实就是充当一个Max的角色
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
