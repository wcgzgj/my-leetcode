 //给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 660 👎 0

  
  package leetcode.editor.cn;

 import java.util.ArrayList;
 import java.util.List;

 public class PalindromePartitioning{
      public static void main(String[] args) {
           Solution solution = new PalindromePartitioning().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          //应该就是动态规划中的查找回文串，加上回溯查找所有答案
    // public List<List<String>> partition(String s) {
    //     // int len = s.length();
    //     // char[] token = s.toCharArray();
    //     // boolean[][] dp = new boolean[len][len];
    //     // for (int i = 0; i < len; i++) {
    //     //     dp[i][i]=true;
    //     // }
    //     // /**
    //     //  * 状态：dp[i][j]  s[i]-s[j] 是否为回文串
    //     //  * 状态转移: dp[i][j]  ==dp[i+1][j-1] && s[i]==s[j]
    //     //  * 边界：当长度区间小于2 即   (j-1)-(i+1)+1 < 2  =>  j-i<3
    //     //  * 优化：只需要dp数组的对角线上半部分
    //     //  */
    //     // for (int i = 0; i < len; i++) {
    //     //     for (int j = i+1; j <len; j++) {
    //     //         if (token[i]!=token[j]) {
    //     //             dp[i][j]=false;
    //     //         } else {
    //     //             if (j-i<3) {
    //     //                 dp[i][j]=true;
    //     //             } else {
    //     //                 dp[i][j]=dp[i+1][j-1];
    //     //             }
    //     //         }
    //     //     }
    //     // }
    //     // List<List<String>> res = new ArrayList<>();
    //     // for (int i = 0; i < len; i++) {
    //     //     for (int j = i; j < len; j++) {
    //     //
    //     //     }
    //     // }
    //
    //
    //     return null;
    // }

          List<List<String>> res = new ArrayList<>();
      public List<List<String>> partition(String s) {



          return null;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
