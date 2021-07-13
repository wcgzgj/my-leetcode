 //给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 1031 👎 0

  
  package leetcode.editor.cn;

 import java.util.Arrays;

 public class NumberOfIslands{
      public static void main(String[] args) {
           Solution solution = new NumberOfIslands().new Solution();
          char[][] grid=new char[][]{{'1','1','0','0','0'},
                  {'1','1','0','0','0'},
                  {'0','0','1','0','0'},
                  {'0','0','0','1','1'}};
          int res = solution.numIslands(grid);
          for (int i = 0; i < grid.length; i++) {
              for (int j = 0; j < grid[0].length; j++) {
                  System.out.print(grid[i][j]+"  ");
              }
              System.out.println();
          }
          System.out.println(res);

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int res=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //如果为1，说明还没遍历过，即刚刚登岛
                if (grid[i][j]=='1') {
                    res++;
                    //只有该岛屿没有遍历过，才有遍历的必要
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid,int r,int c) {
        //如果遍历过，或者是海洋，跳出递归
        if (!inArea(grid,r,c) || grid[r][c]=='2' || grid[r][c]=='0') {
            return;
        }

        grid[r][c]='2';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }

    public boolean inArea(char[][] grid,int r,int c) {
        return r>=0 && r<grid.length && c>=0 && c<grid[0].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
