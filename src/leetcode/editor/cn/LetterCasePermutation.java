 //给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 回溯算法 
// 👍 253 👎 0

  
  package leetcode.editor.cn;
 import com.sun.xml.internal.bind.v2.model.core.ID;

 import java.util.ArrayList;
 import java.util.List;

 public class LetterCasePermutation{
      public static void main(String[] args) {
          StringBuilder sb = new StringBuilder();
          sb.append("dsada");
          System.out.println(sb.length());
          System.out.println(sb.toString());
          System.out.println(sb.deleteCharAt(sb.length()-1).toString());

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        if (S.length()==0) return res;
        //使用StringBuilder，因为不需要重新申请空间，迁移数组，所以能提升效率
        StringBuilder track = new StringBuilder();
        char[] token = S.toCharArray();
        dfs(token,0,track);
        return res;
    }

    public void dfs(char[] token,int depth,StringBuilder track) {
        //边界条件
        if (depth==token.length) {
            res.add(track.toString());
            return;
        }
        if (!isNum(token[depth])) {

            //不改变状态
            track.append(token[depth]);
            dfs(token,depth+1,track);
            //回溯
            track.deleteCharAt(track.length()-1);

            //改变状态
            track.append(changeStatus(token[depth]));
            dfs(token,depth+1,track);
            //回溯
            track.deleteCharAt(track.length()-1);
        } else { //如果当前是数字，就放行
            track.append(token[depth]);
            dfs(token,depth+1,track);
            //回溯
            track.deleteCharAt(track.length()-1);
        }
    }

    public char changeStatus(char c) {
        // A-Z  65-90
        //a-z  97-122
        if (c<=90 && c>=65) {
            return (char) (c+32);
        } else if (c>=97 && c<=122) {
            return (char) (c-32);
        }
        return 0;
    }

    boolean isNum(char c) {
        if (c>=48 && c<=57) return true;
        return false;
    }

    /*
    解答失败: 测试用例:"a1b2" 测试结果:["a1b2","a1bB2","a1bA1b2","a1bA1bB2"]
    期望结果:["a1b2","a1B2","A1b2","A1B2"] stdout:
     */

}
//leetcode submit region end(Prohibit modification and deletion)

  }
