 //给定一个包含了一些 0 和 1 的非空二维数组 grid 。 
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。) 
//
// 
//
// 示例 1: 
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// [[0,0,0,0,0,0,0,0]] 
//
// 对于上面这个给定的矩阵, 返回 0。 
//
// 
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 503 👎 0

  
  package leetcode.editor.cn;
  public class MaxAreaOfIsland{
      public static void main(String[] args) {
           Solution solution = new MaxAreaOfIsland().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 主函数，用来遍历
    public int maxAreaOfIsland(int[][] grid) {
        if (grid==null || grid.length==0 || grid[0].length==0) return 0;
        int max=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1) {
                    max=Math.max(max,getIslandSize(i,j,grid));
                }
            }
        }
        return max;
    }

    // 辅函数，用来递归
    public int getIslandSize(int x,int y,int [][]grid) {
        // 范围判断
        if (x<0 || x>=grid.length || y<0 || y>=grid[0].length ||
        grid[x][y]!=1) return 0;
        int res=0;
        // 通过了前面的判断，说明当前位置是岛屿
        res++;
        // 遍历过的岛屿，设置为2
        grid[x][y]=2;
        res+=getIslandSize(x+1, y,grid );
        res+=getIslandSize(x, y+1,grid );
        res+=getIslandSize(x-1, y,grid );
        res+=getIslandSize(x, y-1,grid );

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
