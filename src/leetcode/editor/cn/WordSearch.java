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
          String word = "ABFEEE";

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

          /**
           * 当输入数据是大量重复的数据的时候，会出现超时。。
           */
          boolean flag=false;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] arr = word.toCharArray();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(arr,board,0,i,j,visited);
                //剪枝优化，如果能找到答案，直接返回
                if (flag) {
                    return true;
                }
            }
        }
        return flag;
    }

    public void dfs(char[] arr,char[][] board,int depth,int r,int c,boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;
        //边界条件
        if (depth> arr.length-1 || r<0 || r>=m || c<0 || c>=n ) {
            return;
        }
        //剪枝
        if(arr[depth]!=board[r][c] || visited[r][c]) {
            return;
        }
        //取得值
        if (depth==arr.length-1 && arr[depth]==board[r][c]) {
            flag=true;
            return;
        }
        visited[r][c]=true;
        dfs(arr,board,depth+1,r-1,c,visited);
        dfs(arr,board,depth+1,r+1,c,visited);
        dfs(arr,board,depth+1,r,c-1,visited);
        dfs(arr,board,depth+1,r,c+1,visited);
        visited[r][c]=false;//回溯 !!!!!
    }


}
//leetcode submit region end(Prohibit modification and deletion)

  }
