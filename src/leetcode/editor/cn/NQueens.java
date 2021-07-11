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

 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.List;
 import java.util.stream.Collectors;

 public class NQueens{
      public static void main(String[] args) {
           Solution solution = new NQueens().new Solution();
          List<List<String>> lists = solution.solveNQueens(4);
          for (List<String> list : lists) {
              System.out.println(list);
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n<=0) return res;
        // 已访问的行
        boolean[] visitedRow = new boolean[n];
        // 左斜已访问
        boolean[] visitedLeft = new boolean[2 * n - 1];
        // 右斜已访问
        boolean[] visitedRight = new boolean[2 * n - 1];

        for (int i = 0; i < n; i++) {
            recursion(0,i,n,visitedRow,visitedLeft,visitedRight,new ArrayList<String>(),res);
        }
        return res;
    }

    public void recursion(int x,int y,int n,
                          boolean[] visitedRow, //列项去重
                          boolean[] visitedLeft, // 左斜去重
                          boolean[] visitedRight, // 右斜去重
                          List<String> curr, // 当前情况
                          List<List<String>> res) { // 所有情况总和
        // 边界条件  x 是下标，n 是长度，所以是 >=
        if (x>=n && y==0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        // 剪枝
        if (visitedRow[y] ||
                visitedLeft[getLeftIndex(x,y)] ||
                visitedRight[getRightIndex(x,y,n)]) {
            return;
        }

        // 回溯
        visitedRow[y]=true;
        visitedLeft[getLeftIndex(x,y)]=true;
        visitedRight[getRightIndex(x,y,n)]=true;
        curr.add(getRowStr(y,n));
        for (int i = 0; i < n; i++) {
            recursion(x+1,i,n,visitedRow,visitedLeft,visitedRight,curr,res);
        }
        visitedRow[y]=false;
        visitedLeft[getLeftIndex(x,y)]=false;
        visitedRight[getRightIndex(x,y,n)]=false;
        curr.remove(curr.size()-1);
    }

    // 获取左斜数组下标
    public int getLeftIndex(int x,int y) {
        return x+y;
    }

    // 获取右斜数组下标
    public int getRightIndex(int x,int y,int n) {
        return (n-1)-(x-y);
    }

    // 获取一行的字符串表现形式
    public String getRowStr(int colIndex,int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (colIndex==i) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
