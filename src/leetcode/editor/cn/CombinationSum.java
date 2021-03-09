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
// 👍 1205 👎 0

  
  package leetcode.editor.cn;

 import java.util.ArrayList;
 import java.util.LinkedList;
 import java.util.List;

 public class CombinationSum{
      public static void main(String[] args) {
           Solution solution = new CombinationSum().new Solution();
          int[] arr = {2, 3, 5};
          int target = 8;
          List<List<Integer>> lists = solution.combinationSum(arr, target);
          System.out.println(lists);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len==0) return res;

        List<Integer> track = new LinkedList<>();
        backTrack(candidates,0,track,target,0);
        return res;
    }

    public void backTrack(int[] candidates,int begin,List<Integer> track,int target,int curr) {
        //边界条件
        if (curr==target) {
            res.add(new ArrayList<>(track));
            return;
        }
        int len = candidates.length;
        for (int i = begin; i < len; i++) {
            if (curr+candidates[i]<=target) {//剪枝
                track.add(candidates[i]);
                //这里是理解重点！！！！！！  即为什么这里传入的是i，不是begin+1
                backTrack(candidates,i,track,target,curr+candidates[i]);
                track.remove(track.size()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
