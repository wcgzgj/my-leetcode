 //给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1248 👎 0

  
  package leetcode.editor.cn;

 import java.util.ArrayList;
 import java.util.List;

 public class CombinationSum{
      public static void main(String[] args) {
           Solution solution = new CombinationSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          /**
           * 选择范围：
           *    当前的数列循环递归，每层，每个数都选
           * 边界：
           *    当当前数加上以前的数，刚好等于target
           * 剪枝：
           *    当当前数加上以前的数，超过target
           */
          List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length==0) return res;
        List<Integer> track = new ArrayList<>();
        dfs(0,track,candidates,target,0);
        return res;
    }

    public void dfs(int trackSum,List<Integer> track,int[] nums,int target,int begin) {
        if (trackSum>target) return;
        if (trackSum==target) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            track.add(nums[i]);
            dfs(trackSum+nums[i],track,nums,target,i);
            track.remove(track.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
