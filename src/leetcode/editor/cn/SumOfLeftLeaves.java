 //计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 261 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 public class SumOfLeftLeaves{
      public static void main(String[] args) {
           Solution solution = new SumOfLeftLeaves().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        sumRecursion(root);
        return sum;
    }

    public void sumRecursion(TreeNode root) {
        if (root==null) return;
        if (isLeaf(root.left)) {
            sum+=root.left.val;
            // return;
        }
        sumRecursion(root.left);
        sumRecursion(root.right);
    }

    public boolean isLeaf(TreeNode root) {
        if (root==null) return false;
        if (root.left==null && root.right==null) return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
