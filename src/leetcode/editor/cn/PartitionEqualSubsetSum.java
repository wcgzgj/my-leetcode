 //给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 701 👎 0

  
  package leetcode.editor.cn;
  public class PartitionEqualSubsetSum{
      public static void main(String[] args) {
           Solution solution = new PartitionEqualSubsetSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          //方法1：回溯
          //回溯是个好东西，怎么能不用呢？
          //虽然能跑出部分答案
          //但是一旦超过一定阈值，就会超时
    //       boolean res=false;
    // public boolean canPartition(int[] nums) {
    //     if (nums.length<=1) {
    //         return false;
    //     }
    //     int sum=0;
    //     for (int i = 0; i < nums.length; i++) {
    //         sum+=nums[i];
    //     }
    //     dfs(sum,0,nums,0);
    //     return res;
    // }
    //
    // public void dfs(int sum,int track,int[] nums,int depth) {
    //     //如果可分，立马返回true
    //     if (track==sum-track) {
    //         res=true;
    //         return;
    //     }
    //     if (depth==nums.length) {
    //         return;
    //     }
    //     //选
    //     dfs(sum,track+nums[depth],nums,depth+1);
    //     //不选
    //     dfs(sum,track,nums,depth+1);
    // }

      //方法2：动态规划
      //还是跑不掉的，回溯铁定会超时
    public boolean canPartition(int[] nums) {
        return false;

    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
