 //给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 515 👎 0

  
  package leetcode.editor.cn;

 import java.util.ArrayList;
 import java.util.LinkedList;
 import java.util.List;

 public class Combinations{
      public static void main(String[] args) {
           Solution solution = new Combinations().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k>n || n==0) return res;
        List<Integer> track = new LinkedList<>();
        backtrack(n,k,1,track);
        return res;
    }

    public void backtrack(int n,int k,int begin,List<Integer>track) {
        // 边界条件
        if (track.size()==k) {
            res.add(new ArrayList<>(track));
            return;
        }
        if (n-begin+1+track.size()<k) return;//剪枝
        for (int i = begin; i <= n; i++) {
            track.add(i);
            backtrack(n,k,i+1,track);
            track.remove(track.size()-1);
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)

  }
