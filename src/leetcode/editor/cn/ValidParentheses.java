 //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = '()'
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = '()[]{}'
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = '(]'
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = '([)]'
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = '{[]}'
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2341 👎 0

  
  package leetcode.editor.cn;

 import java.util.*;

 public class ValidParentheses{
      public static void main(String[] args) {
           Solution solution = new ValidParentheses().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (s.length()==0) return true;
        char[] token = s.toCharArray();
        Set<Character> left = new HashSet<>();
        Set<Character> right = new HashSet<>();
        left.add('(');
        left.add('[');
        left.add('{');
        right.add(')');
        right.add(']');
        right.add('}');

        LinkedList<Character> stack = new LinkedList<>();
        for (char c : token) {
            if (left.contains(c)) {
                stack.addLast(c);
            } else {
                if (stack.size()==0) return false;
                if (!isMatch(c,stack.getLast())) return false;
                stack.removeLast();
            }
        }
        if (stack.size()==0) return true;
        return false;
    }

    public boolean isMatch(char c1,char c2) {
        if (c1=='(' || c1==')') {
            return (c1=='('&&c2==')') || (c1==')'&&c2=='(');
        }
        if (c1=='[' || c1==']') {
            return (c1=='['&&c2==']') || (c1==']'&&c2=='[');
        }
        if (c1=='{' || c1=='}') {
            return (c1=='{'&&c2=='}') || (c1=='}'&&c2=='{');
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
