 //给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 432 👎 0

  
  package leetcode.editor.cn;

 import java.awt.*;

 public class SurroundedRegions{
      public static void main(String[] args) {
           Solution solution = new SurroundedRegions().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //n行m列
    int row,col;
    public void solve(char[][] board) {
        row=board.length;
        if (row==0) return;
        col=board[0].length;
        if (col==0) return;
        //通过dfs，将不符合条件的 O，转换为 #
        for (int i = 0; i < row; i++) {
            dfs(board,i,0);
            dfs(board,i,col-1);
        }
        for (int i = 0; i <col; i++) {
            dfs(board,0,i);
            dfs(board,row-1,i);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j]=='#') {
                    board[i][j]='O';
                 } else if (board[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }
    }

    public void dfs(char[][] board,int x,int y) {
        //我忘记这是哪一题了
        //等哪次翻到了再说吧
    }


}
//leetcode submit region end(Prohibit modification and deletion)

  }
