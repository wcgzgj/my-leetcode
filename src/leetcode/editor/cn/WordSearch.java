 //给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 827 👎 0

  
  package leetcode.editor.cn;

 import sun.security.util.Length;

 import javax.xml.transform.Source;

 public class WordSearch{
      public static void main(String[] args) {
           Solution solution = new WordSearch().new Solution();
          char[][] board = {{'A', 'B', 'C', 'E' },
                            {'S', 'F', 'E', 'S' },
                            {'A', 'D', 'E', 'E' }};
          String word = "ABCESEEEC";
          // String word = "B";

          // [["A","B","C","E"],
          //  ["S","F","C","S"],
          //  ["A","D","E","E"]]
          // "ABCB <<===失败的判断案例！！

          // [["A","B","C","E"],
          //  ["S","F","E","S"],
          //  ["A","D","E","E"]]
          //  "ABCESEEEFS"
          boolean res = solution.exist(board, word);
          System.out.println(res);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean exist(char[][] board, String word) {
        if (word==null || word.length()==0) return true;
        if (board==null ||board.length==0 || board[0].length==0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (recursion(i,j,board,visited,word,0)) return true;
            }
        }
        return false;
    }


    public boolean recursion(int x,int y,char[][]board,boolean[][] visited,String word,int depth) {
        // 边界条件
        if (depth>=word.length()) {
            return true;
        }
        // 剪枝
        if (x<0 || x>=board.length || y<0 || y>=board[0].length // 超出边界
                || visited[x][y] // 已经访问
                || word.charAt(depth)!=board[x][y]) return false; // 符号不匹配
        visited[x][y] = true;
        boolean res = false;
        int[]xs={0,0,1,-1};
        int[]ys={1,-1,0,0};
        for (int i = 0; i < 4; i++) {
            res = res || recursion(x+xs[i],y+ys[i],board,visited,word, depth+1);
        }
        visited[x][y] = false;
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
