 //在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。） 
//
// 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。 
//
// 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1 。） 
//
// 
//
// 示例 1： 
//
// 
//输入：A = [[0,1],[1,0]]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：A = [[0,1,0],[0,0,0],[0,0,1]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//输出：1 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length == A[0].length <= 100 
// A[i][j] == 0 或 A[i][j] == 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 
// 👍 172 👎 0

  
  package leetcode.editor.cn;

 import java.util.*;

 public class ShortestBridge{
      public static void main(String[] args) {
           Solution solution = new ShortestBridge().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // public int shortestBridge(int[][] grid) {
    //     return -1;
    // }

          /**
           * 下面是官方答案
           */
          public int shortestBridge(int[][] A) {
              int R = A.length, C = A[0].length;


              int[][] colors = getComponents(A);

              Queue<Node> queue = new LinkedList();
              Set<Integer> target = new HashSet();

              for (int r = 0; r < R; ++r)
                  for (int c = 0; c < C; ++c) {
                      // 将两座岛屿的位置信息，存入各自的集合
                      if (colors[r][c] == 1) {
                          // 岛屿A 因为还要存储深度信息，所以不能进行压缩
                          queue.add(new Node(r, c, 0));
                      } else if (colors[r][c] == 2) {
                          target.add(r * C + c);
                      }
                  }

              while (!queue.isEmpty()) {
                  Node node = queue.poll();
                  if (target.contains(node.r * C + node.c))
                      return node.depth - 1;
                  for (int nei: neighbors(A, node.r, node.c)) {
                      int nr = nei / C, nc = nei % C;
                      if (colors[nr][nc] != 1) {
                          queue.add(new Node(nr, nc, node.depth + 1));
                          colors[nr][nc] = 1;
                      }
                  }
              }

              throw null;
          }

          /**
           * 搜索到两座岛屿的位置信息
           * 岛 A 不变，还是以1表示，岛 B 全部换用 2 表示
           * @param A
           * @return
           */
          public int[][] getComponents(int[][] A) {
              int R = A.length, C = A[0].length;
              int[][] colors = new int[R][C];
              int t = 0;

              for (int r0 = 0; r0 < R; ++r0)
                  for (int c0 = 0; c0 < C; ++c0)
                      // 当前位置是岛屿，且当前位置之前还没被遍历过
                      if (colors[r0][c0] == 0 && A[r0][c0] == 1) {
                          // Start dfs
                          Stack<Integer> stack = new Stack();
                          stack.push(r0 * C + c0);
                          colors[r0][c0] = ++t;

                          while (!stack.isEmpty()) {
                              int node = stack.pop();
                              int r = node / C, c = node % C;
                              // neighbors 函数，获取
                              for (int nei: neighbors(A, r, c)) {
                                  int nr = nei / C, nc = nei % C;
                                  // 这里其实已经剪枝了
                                  if (A[nr][nc] == 1 && colors[nr][nc] == 0) {
                                      colors[nr][nc] = t;
                                      stack.push(nr * C + nc);
                                  }
                              }
                          }
                      }

              return colors;
          }

          /**
           * 获取指定位置的点，在二维数组范围之内的邻接点
           * @param A 初始岛屿信息
           * @param r 行
           * @param c 列
           * @return
           */
          public List<Integer> neighbors(int[][] A, int r, int c) {
              int R = A.length, C = A[0].length;
              List<Integer> ans = new ArrayList();
              // r*C+c 是将
              if (0 <= r-1) ans.add((r-1) * R + c);
              if (0 <= c-1) ans.add(r * R + (c-1));
              if (r+1 < R) ans.add((r+1) * R + c);
              if (c+1 < C) ans.add(r * R + (c+1));
              return ans;
          }

      }


      class Node {
          int r, c, depth;
          Node(int r, int c, int d) {
              this.r = r;
              this.c = c;
              depth = d;
          }
      }

//leetcode submit region end(Prohibit modification and deletion)

  }
