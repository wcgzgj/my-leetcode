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
// 👍 1186 👎 0

  
  package leetcode.editor.cn;

 import java.util.ArrayList;
 import java.util.LinkedList;
 import java.util.List;

 public class Permutations{
      public static void main(String[] args) {
           Solution solution = new Permutations().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len==0) return res;
        //记录路径，别忘了到边界的时候，撤回
        List<Integer> track = new LinkedList<>();
        //记录当前位置是否被使用过
        boolean[] used = new boolean[len];

        dfs(track,0,used,nums);
        return res;
    }

      /**
       * 回溯
       * @param track
       * @param depth 记录深度
       * @param used
       * @param nums
       */
    public void dfs(List<Integer>track,int depth,boolean[] used,int[] nums) {
        //结束条件
        if (depth==used.length) {
            //这里一定要使用新的内存空间，不然，所有答案都会是一样的
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //用used数组替代contains函数，使得时间复杂度由O(n)->O(1)
            if (!used[i]) {
                used[i]=true;
                track.add(nums[i]);
                dfs(track,depth+1,used,nums);
                //撤销操作
                used[i]=false;
                track.remove(track.size()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
