 //
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 
// 👍 573 👎 0

  
  package leetcode.editor.cn;

 import jdk.nashorn.internal.ir.IfNode;

 import java.util.Arrays;

 public class NumberOfProvinces{
      public static void main(String[] args) {
          Solution solution = new NumberOfProvinces().new Solution();
          // int[][] arr={{1,1,0},
          //              {1,1,0},
          //              {0,0,1}};
          /**
           * [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]] 测试结果:3 期望结果:1 stdout:
           */
          int[][] arr={{1,0,0,1},
                       {0,1,1,0},
                       {0,1,1,1},
                       {1,0,1,1}};

          int res=solution.findCircleNum(arr);
          for (int i = 0; i < arr.length; i++) {
              for (int j = 0; j < arr[0].length; j++) {
                  System.out.print(arr[i][j]+"  ");
              }
              System.out.println();
          }

          System.out.println(res);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected==null ||
                isConnected.length==0 ||
                isConnected[0].length==0) return 0;
        int count=0;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (isConnected[i][j]==1) {
                    count++;
                    recursion(i,j,isConnected);
                }
            }
        }
        return count;
    }

    public int recursion(int x,int y,int[][]isConnected) {
        /**
         * 因为是遍历对角线一下的位置
         * 所以，当列数超过行数的时候，我们就判定为超范围
         */
        if (x<0 || x>=isConnected.length ||
                y<0 || y>x || isConnected[x][y]!=1 ) return 0;
        int res=0;
        res++;
        isConnected[x][y]=2;
        int[] xs={0,0,1,-1};
        int[] ys={1,-1,0,0};
        for (int i = 0; i < 4; i++) {
            res+=recursion(x+xs[i],y+ys[i],isConnected);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
