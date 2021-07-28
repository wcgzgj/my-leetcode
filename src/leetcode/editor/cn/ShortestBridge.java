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

 public class ShortestBridge {
     public static void main(String[] args) {
         Solution solution = new ShortestBridge().new Solution();
         /**
          * 2.-1.2.2
          * -1,-1,-1,-1
          * -1,-1,-1,-1
          */
         int[][] grid = {{0,1,0},
                         {0,0,0},
                         {0,0,1}};
         int res = solution.shortestBridge(grid);
         System.out.println(res);
     }

     //leetcode submit region begin(Prohibit modification and deletion)
     class Solution {
         public int shortestBridge(int[][] grid) {
             if (grid==null || grid.length==0 || grid[0].length==0) return 0;
             int R = grid.length;
             int C = grid[0].length;


             boolean flag = false;
             // 将第一座岛屿的位置，全部换成2
             for (int i = 0; i < R; i++) {
                 if (flag) break;
                 for (int j = 0; j < C; j++) {
                     if (grid[i][j]==1) {
                         // 当 source 岛屿已经被全部遍历后，标记 flag，跳出二层循环
                         markSourceIsland(grid,i,j);
                         flag=true;
                         break;
                     }
                 }
             }

             // 用来进行广度遍历的辅助队列
             Queue<Node> queue = new LinkedList<>();

             // 获取起始岛屿的第一个位置
             int startR=-1;
             int startC=-1;
             boolean flag2 = false;
             for (int i = 0; i < R; i++) {
                 if (flag2) break;
                 for (int j = 0; j < C; j++) {
                     if (grid[i][j]==2) {
                         startR=i;
                         startC=j;
                         flag2=true;
                     }
                 }
             }


             // 但凡是为起始岛屿（value=2）的节点，深度都设为2
             queue.add(new Node(startR,startC,0));
             while (!queue.isEmpty()) {
                 Node node = queue.poll();
                 List<Integer> neighbors = getNeighbors(grid, node.r, node.c);
                 for (Integer neighbor : neighbors) {
                     // 获取邻接位置的坐标（升维）
                     int nr = neighbor / C;
                     int nc = neighbor % C;

                     if (grid[nr][nc]==2) { // 还是起始岛屿，深度我们还是设为0
                         queue.add(new Node(nr,nc,0));
                     } else if (grid[nr][nc]==-1) { // 已经遍历过，就不往队列添加了
                         continue;
                     } else if (grid[nr][nc]==0) { // 如果是海洋的话，我们要为深度+1
                         queue.add(new Node(nr,nc,node.depth+1));
                     } else if (grid[nr][nc]==1) { // 当前节点的邻接节点，已经有目标岛屿了，说明我们的桥建完了
                         return node.depth;
                     }
                     // 遍历过后，将遍历过的位置设置为 -1
                     grid[nr][nc]=-1;
                 }
             }
             return -1;
         }


         /**
          * 通过递归，标记处第一座岛屿的位置
          * @param grid
          * @param r
          * @param c
          */
         public void markSourceIsland(int[][] grid,int r,int c) {
             int R = grid.length;
             int C = grid[0].length;
             // 当超出范围或者当前位置不是岛屿的时候，递归终止
             if (r<0 || r>=R || c<0 || c>=C || grid[r][c]!=1) return;

             // 进行标记
             grid[r][c]=2;
             int []rs={0,0,1,-1};
             int []cs={1,-1,0,0};
             // 递归标记
             for (int i = 0; i < 4; i++) {
                 markSourceIsland(grid,r+rs[i],c+cs[i]);
             }
         }

         /**
          * 获取当前位置的，没有超出范围的、没有被遍历过的周围的点集合
          * 遍历过的点，我们全部标记为 -1
          * @param grid 二维数组
          * @param r 行
          * @param c 列
          * @return
          */
         public List<Integer> getNeighbors(int[][] grid,int r,int c) {
             int R = grid.length;
             int C = grid[0].length;
             List<Integer> res = new ArrayList<>();
             int []rs={0,0,1,-1};
             int []cs={1,-1,0,0};
             for (int i = 0; i < 4; i++) {
                 int newR = r + rs[i];
                 int newC = c + cs[i];
                 if (posIsOk(grid,newR,newC)) {
                     // 降维
                     res.add(newR*C+newC);
                 }
             }
             return res;
         }

         /**
          * 只判断当前位置是否在范围内
          * @param grid
          * @param r
          * @param c
          * @return
          */
         public boolean posIsOk(int[][]grid,int r,int c) {
             int R = grid.length;
             int C = grid[0].length;
             if (r<0 || r>=R || c<0 || c>=C) return false;
             return true;
         }


         class Node {
             public int r;
             public int c;
             public int depth;

             public Node(int r, int c, int depth) {
                 this.r = r;
                 this.c = c;
                 this.depth = depth;
             }
         }

//leetcode submit region end(Prohibit modification and deletion)

     }
 }
