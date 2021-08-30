 //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 
// 👍 292 👎 0

  package leetcode.editor.cn;

 import java.util.ArrayList;

 public class ShunShiZhenDaYinJuZhenLcof{
      public static void main(String[] args) {
           Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          // 打印矩阵是经典的 for 循环相关问题了，要牢牢记住
          // 其实，就是矩阵的四个方向缩边，然后注意边界条件即可
    public int[] spiralOrder(int[][] matrix) {
        if (matrix==null || matrix.length==0) return new int[0];
        // 定义左右上下四个边的范围
        int l=0,r=matrix[0].length-1,t=0,b=matrix.length-1;
        int index = 0;
        int[] res = new int[matrix.length * matrix[0].length];
        while (true){
            for (int i = l; i <=r ; i++) res[index++]=matrix[t][i];
            if (++t>b) break;
            for (int i = t; i <=b; i++) res[index++]=matrix[i][r];
            if (--r<l) break;
            for (int i = r; i >=l; i--) res[index++]=matrix[b][i];
            if (--b<t) break;
            for (int i = b; i >=t; i--) res[index++]=matrix[i][l];
            if (++l>r) break;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
