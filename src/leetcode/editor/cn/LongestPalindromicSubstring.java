 //给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3248 👎 0

  
  package leetcode.editor.cn;

 import javax.swing.text.StyledEditorKit;
 import java.security.cert.TrustAnchor;

 public class LongestPalindromicSubstring{
      public static void main(String[] args) {
           Solution solution = new LongestPalindromicSubstring().new Solution();
          String str = "ababbc";
          System.out.println(solution.longestPalindrome(str));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //方法一：穷举
    // int max=0;
    // String str="";
    // public String longestPalindrome(String s) {
    //     int n = s.length();
    //
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i; j < n; j++) {
    //             if (isHuiWen(s.substring(i,j+1))) {
    //                 if ((j-i+1)>max) {
    //                     max=j-i+1;
    //                     str=s.substring(i,j+1);
    //                 }
    //             }
    //         }
    //     }
    //     return str;
    // }
    //
    // public boolean isHuiWen(String str) {
    //     if (str.length()<=1) return true;
    //     int i=0;
    //     int j=str.length()-1;
    //     while (i<=j) {
    //         if (str.charAt(i)!=str.charAt(j)) return false;
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }

    //方法二：动态规划
    public String longestPalindrome(String s) {
        //空串和长度为1的串一定是回文串
        if (s.length()<=1) return s;

        char[] array = s.toCharArray();
        int len = s.length();
        int beginIndex=0;
        int maxLen=0;
        //状态
        boolean[][] dp = new boolean[len][len];
        //初始化
        for (int i = 0; i < len; i++) {
            dp[i][i]=true;
        }

        //状态转移方程的实现
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (array[i]!=array[j]) dp[i][j]=false;
                else {
                    //边界条件
                    if (j-i<3) dp[i][j]=true;
                    else dp[i][j]=dp[i+1][j-1];
                }

                //考虑输出
                if (dp[i][j] && j-i+1>maxLen) {
                    maxLen=j-i+1;
                    beginIndex=i;
                }
            }
        }
        return s.substring(beginIndex,beginIndex+maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
