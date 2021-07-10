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

 import test.ArrayListIndexTest;

 import java.util.ArrayList;
 import java.util.LinkedList;
 import java.util.List;

 public class Combinations{
      public static void main(String[] args) {
           Solution solution = new Combinations().new Solution();
          List<List<Integer>> res = solution.combine(4, 2);
          for (List<Integer> re : res) {
              System.out.println(re.toString());
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>res = new ArrayList<>();
        // 当输入为 n<k 的时候，是不存在答案的，比如说是从3个数中，找出4个数的排列
        if (n<k) return res;
        if (k<1) return res;
        // 为了方便 cisited 数组从 1 开始数
        boolean[] visited = new boolean[n+1];

        recursion(res,k-1,n,new ArrayList<>(),visited);
        return res;
    }

    public void recursion(List<List<Integer>>res,int k,int n,List<Integer>currList,boolean[] visited) {
        if (k<=0) {
            res.add(new ArrayList<>(currList));
            return;
        }
        for (int i = 1; i <=n ; i++) {
            // 剪枝，不仅当前位置不能被访问过，而且当前位置的数，必须比已经存储的数大
            if (!visited[i] && i>currList.get(currList.size()-1)) {
                currList.add(i);
                visited[i]=true;
                recursion(res,k-1,n,currList,visited);
                // 回溯
                currList.remove(currList.size()-1);
                visited[i]=false;
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
