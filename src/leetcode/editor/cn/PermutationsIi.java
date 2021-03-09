 //给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 621 👎 0

  
  package leetcode.editor.cn;

 import sun.security.util.Length;

 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.LinkedList;
 import java.util.List;

 public class PermutationsIi{
      public static void main(String[] args) {
           Solution solution = new PermutationsIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        //这种剪枝方法，只适合排好序的数组
        Arrays.sort(nums);
        if (len==0) return res;
        boolean[] used = new boolean[len];
        List<Integer> track = new LinkedList<>();
        backTrack(nums,track,used);
        return res;
    }

    public void backTrack(int[] nums,List<Integer>track,boolean[] used) {
        //结束条件
        if (track.size()==nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {//当前元素没有使用过
                //如果当前元素的前一个元素，与当前元素相等，且没有使用过
                if (i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
                track.add(nums[i]);
                used[i]=true;
                backTrack(nums,track,used);
                track.remove(track.size()-1);
                used[i]=false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
