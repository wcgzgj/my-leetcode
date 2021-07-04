 //给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 617 👎 0

  
  package leetcode.editor.cn;

 import java.util.zip.CheckedOutputStream;

 public class PalindromicSubstrings{
      public static void main(String[] args) {
           Solution solution = new PalindromicSubstrings().new Solution();
          System.out.println(solution.countSubstrings("abc"));
          System.out.println(solution.countSubstrings("aaa"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        if (s==null) return 0;
        if (s.length()==1) return 1;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count+=extendsString(s,i,i); // 奇数长度子串
            count+=extendsString(s,i,i+1); // 偶数长度子串
        }
        return count;
    }

    public int extendsString(String s,int l,int r) {
        int count = 0;
        while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
