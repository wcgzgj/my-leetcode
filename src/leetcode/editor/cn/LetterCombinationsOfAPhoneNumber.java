 //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1182 👎 0

  
  package leetcode.editor.cn;

 import javax.swing.table.TableCellEditor;
 import java.util.ArrayList;
 import java.util.List;

 public class LetterCombinationsOfAPhoneNumber{
      public static void main(String[] args) {
           Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0) return res;
        String track = "";
        String[] nums=new String[]{"-1","-1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack(0,digits,nums,track);
        return res;
    }

    public void backtrack(int depth,String digit,String[] nums,String track) {
        if (depth==digit.length()) {
            res.add(new String(track));
            return;
        }
        //获取当前深度电话数字
        int index = Character.getNumericValue(digit.charAt(depth));
        String paths = nums[index];
        for (int i = 0; i < paths.length(); i++) {
            track+=String.valueOf(paths.charAt(i));
            backtrack(depth+1,digit,nums, track);
            //回溯
            track=track.substring(0,track.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
