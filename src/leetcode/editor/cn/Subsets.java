 //给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1042 👎 0

  
  package leetcode.editor.cn;

 import java.util.ArrayList;
 import java.util.List;

 public class Subsets{

      public static void main(String[] args) {
           Solution solution = new Subsets().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(0,nums,track);
        return res;
    }

    public void backtrack(int begin,int[] nums,List<Integer>track) {
        if (begin==nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        track.add(nums[begin]);
        backtrack(begin+1,nums,track);
        track.remove(track.size()-1);

        // 考虑不加入i的情况
        backtrack(begin+1,nums,track);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
