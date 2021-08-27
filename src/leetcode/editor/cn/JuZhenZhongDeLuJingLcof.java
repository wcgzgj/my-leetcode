 //给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 
// 👍 393 👎 0

  package leetcode.editor.cn;
  
  public class JuZhenZhongDeLuJingLcof{
      public static void main(String[] args) {
          Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
          /**
           * 例:[["a"]] "ab"
           */
          char[][] board = {{'a'}};
          System.out.println(solution.exist(board,"ab"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        if (word==null || word.length()==0) return true;
        boolean[][] visited = new boolean[board.length][board[0].length];
        int R = board.length;
        int C = board[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                boolean res = recursion(visited, board, i, j, word, 0);
                if (res) return true;
            }
        }
        return false;
    }

    public boolean recursion(boolean[][] visited,char[][] board,int r,int c,String word,int index) {
        int R = board.length;
        int C = board[0].length;

        // 出界
        if (r>=R || c>=C || r<0 || c<0 ) return false;
        // 已经访问
        if (visited[r][c]) return false;
        // 不匹配
        if (board[r][c]!=word.charAt(index)) return false;
        // 找到
        if (board[r][c]==word.charAt(index) && index==word.length()-1) return true;

        int []rows = {0,0,1,-1};
        int []cols = {1,-1,0,0};
        boolean res = false;
        visited[r][c]=true;
        for (int i = 0; i < 4; i++) {
            res = recursion(visited,board,r+rows[i],c+cols[i],word,index+1) || res;
            if (res) return true;
        }
        visited[r][c]=false;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
