 //给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 704 👎 0

  
  package leetcode.editor.cn;


 import domain.TreeNode;

 import java.util.ArrayList;
 import java.util.List;

 public class UniqueBinarySearchTreesIi{
      public static void main(String[] args) {
           Solution solution = new UniqueBinarySearchTreesIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n<=0) return new ArrayList<TreeNode>();
        //不能使用0~n-1的范围，因为题目要求第一个节点的值从1开始
        return getAllTreeList(1,n);
    }


    public List<TreeNode> getAllTreeList(int start,int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start>end) {
            list.add(null);
            return list;
        }
        //枚举每一个根节点的可能
        for (int i = start; i <= end; i++) {
            //获取所有可能左枝的头结点
            List<TreeNode> left = getAllTreeList(start, i - 1);
            //获取所有可能右枝的头结点
            List<TreeNode> right = getAllTreeList(i + 1, end);
            //遍历所有可能的左右枝组合
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left=l;
                    treeNode.right=r;
                    list.add(treeNode);
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
