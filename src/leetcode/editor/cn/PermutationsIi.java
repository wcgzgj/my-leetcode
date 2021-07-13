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
// 👍 647 👎 0

  
  package leetcode.editor.cn;

 import javax.xml.transform.Source;
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.List;

 public class PermutationsIi{
      public static void main(String[] args) {
           Solution solution = new PermutationsIi().new Solution();
          int[] arr = {1, 1, 2};
          List<List<Integer>> res = solution.permuteUnique(arr);
          System.out.println(res.toString());
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          /**
           * 选择：
           *    剩下的还没被选中的数字，且当前的数字不能等于前一个数字（保证数组有序）
           * 边界：
           *    深度等于长度
           * 剪枝：
           *
           *
           */
          List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length==0) return res;
        List<Integer> track = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(track,nums,0,used);
        return res;
    }

    public void dfs(List<Integer> track,int[] nums,int depth,boolean[] used) {
        if (depth==nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //避免重复
            if (i>0 && nums[i]==nums[i-1] && !used[i-1]) {
                continue;
            }
            if (!used[i]) {
                used[i]=true;
                track.add(nums[i]);
                dfs(track,nums,depth+1,used);
                used[i]=false;
                track.remove(track.size()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
