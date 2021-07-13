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
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

          /**
           * 暴力解法
           * 直接尝试获取所有位置的回文串
           * 然后对比，找出最长的回文串
           * @param s
           * @return
           */
    public String longestPalindrome(String s) {
        if (s==null || s.length()==0) return "";
        if (s.length()==1) return s;
        String max="";
        for (int i = 0; i < s.length(); i++) {
            String str1 = getMaxSub(s, i, i);
            String str2 = getMaxSub(s, i, i+1);
            max=max.length()<str1.length()?str1:max;
            max=max.length()<str2.length()?str2:max;
        }
        return max;
    }

          /**
           * 获取当前位置延伸出来的最长回文字符串
           * @param s
           * @param l
           * @param r
           * @return
           */
    public String getMaxSub(String s,int l,int r) {
        while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
