 //给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1251 👎 0

  
  package leetcode.editor.cn;

 import java.util.ArrayList;
 import java.util.List;

 public class Permutations{
      public static void main(String[] args) {
           Solution solution = new Permutations().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

          /**
           * 选择范围：
           *    剩下的还没被选中的数字
           * 边界条件：
           *    深度，等于数组长度
           * 剪枝：
           *    全部遍历，无法剪枝
           * @param nums
           * @return
           */
          List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length==0) return res;
        List<Integer> track = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(track,0,nums,used);
        return res;
    }

    public void dfs(List<Integer> track,int depth,int[] nums,boolean[] used) {
        //边界
        if (depth==nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i]=true;
                track.add(nums[i]);
                dfs(track,depth+1,nums,used);
                used[i]=false;
                track.remove(track.size()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
