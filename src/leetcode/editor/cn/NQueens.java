 //n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 791 👎 0

  
  package leetcode.editor.cn;

 import java.util.Collections;
 import java.util.List;
 import java.util.stream.Collectors;

 public class NQueens{
      public static void main(String[] args) {
           Solution solution = new NQueens().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {



        return null;
    }

    public void dfs() {


    }

    //判断当前位置，皇后能否放置
    public boolean isPlaceable(int r,int c,char[][] map) {


        return false;
    }



    public List<List<String>> mapToList(char[][]map) {


        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }