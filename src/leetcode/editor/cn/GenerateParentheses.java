 //数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1488 👎 0

  
  package leetcode.editor.cn;

 import java.util.LinkedList;
 import java.util.List;

 public class GenerateParentheses{
      public static void main(String[] args) {
           Solution solution = new GenerateParentheses().new Solution();
          List<String> res = solution.generateParenthesis(3);
          for (String re : res) {
              System.out.println(re);
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder track = new StringBuilder();
        track.append("(");
        dfs(track,1,0,n);
        return res;
    }

    public void dfs(StringBuilder track,int l,int r,int n) {
        if (l+r==n*2) {
            //必须保证左右括号个数相等
            //且最后一个括号是右括号
            if (l==r && track.charAt(track.length()-1)==')') {
                res.add(track.toString());
                return;
            } else {
                //如果不满足条件
                //也必须返回
                return;
            }
        }
        //剪枝
        if (l<r) return;

        track.append("(");
        dfs(track,l+1,r,n);
        //回溯
        track.deleteCharAt(track.length()-1);

        track.append(")");
        dfs(track,l,r+1,n);
        //回溯
        track.deleteCharAt(track.length()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
