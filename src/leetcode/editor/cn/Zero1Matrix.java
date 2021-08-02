 //给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 104 
// 1 <= m * n <= 104 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 
// 👍 459 👎 0

  package leetcode.editor.cn;
  
  public class Zero1Matrix{
      public static void main(String[] args) {
           Solution solution = new Zero1Matrix().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat==null || mat.length==0) return new int[0][0];
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j]=Integer.MAX_VALUE;
            }
        }

        // 从左上开始遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果当前位置就是 0，那么其离0的位置就是0
                if (mat[i][j]==0) {
                    dp[i][j]=0;
                } else {
                    if (i>0) {
                        dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+1);
                    }
                    if (j>0) {
                        dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+1);
                    }
                }
            }
        }

        // 从右下开始遍历
        for (int i = m-1; i >=0 ; i--) {
            for (int j = n-1; j >=0 ; j--) {
                // 如果当前位置就是 0，那么其离0的位置就是0
                if (mat[i][j]==0) {
                    dp[i][j]=0;
                } else {
                    if (i<m-1) {
                        dp[i][j]=Math.min(dp[i][j],dp[i+1][j]+1);
                    }
                    if (j<n-1) {
                        dp[i][j]=Math.min(dp[i][j],dp[i][j+1]+1);
                    }
                }
            }
        }
        return dp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
