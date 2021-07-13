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

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length==0) return res;
        boolean[] visited=new boolean[nums.length];
        recursion(nums,visited,new ArrayList<Integer>(),res,0);
        return res;
    }

    // 递归
    public void recursion(int[]nums,boolean[] visited,List<Integer>curr,List<List<Integer>>res,int depth) {
        // 递归边界
        if (depth>=nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                curr.add(nums[i]);
                visited[i]=true;
                recursion(nums,visited,curr,res,depth+1);
                // 回溯
                visited[i]=false;
                curr.remove(curr.size()-1);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
