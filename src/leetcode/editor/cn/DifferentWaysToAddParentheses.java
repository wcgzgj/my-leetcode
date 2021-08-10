 //给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 *
// 。 
//
// 示例 1: 
//
// 输入: "2-1-1"
//输出: [0, 2]
//解释: 
//((2-1)-1) = 0 
//(2-(1-1)) = 2 
//
// 示例 2: 
//
// 输入: "2*3-4*5"
//输出: [-34, -14, -10, -10, 10]
//解释: 
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10 
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 
// 👍 405 👎 0

  package leetcode.editor.cn;

 import java.util.ArrayList;
 import java.util.List;

 public class DifferentWaysToAddParentheses{
      public static void main(String[] args) {
           Solution solution = new DifferentWaysToAddParentheses().new Solution();
          List<Integer> res = solution.diffWaysToCompute("2*3-4*5");
          System.out.println(res);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (!Character.isDigit(c)) {
                List<Integer> l = diffWaysToCompute(expression.substring(0, i));
                List<Integer> r = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                char op = c;
                for (int p = 0; p < l.size(); p++) {
                    for (int q = 0; q < r.size(); q++) {
                        switch (op) {
                            case '+':
                                res.add(l.get(p)+r.get(q));
                                break;
                            case '-':
                                res.add(l.get(p)-r.get(q));
                                break;
                            case '*':
                                res.add(l.get(p)*r.get(q));
                                break;
                        }
                    }
                }
            }
        }
        // 处理边界情况，即当前字符串中只有数字，没有运算符号
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
