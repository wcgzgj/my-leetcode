 //实现一个函数，检查一棵二叉树是否为二叉搜索树。示例 1: 输入:     2    / \   1   3 输出: true 示例 2: 输入:     5
//    / \   1   4      / \     3   6 输出: false 解释: 输入为: [5,1,4,null,null,3,6]。    
//  根节点的值为 5 ，但是其右子节点值为 4 。 Related Topics 树 深度优先搜索 
// 👍 35 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 public class LegalBinarySearchTreeLcci{
      public static void main(String[] args) {
           Solution solution = new LegalBinarySearchTreeLcci().new Solution();
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
    public int prev=Integer.MIN_VALUE;
    public boolean start=false;
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        boolean left = isValidBST(root.left);
        if (start==false) {
            // prev=root.val;
            start=true;
        } else {
            if (root.val<=prev) {
                return false;
            }
        }
        // if (root.val!=Integer.MIN_VALUE) {
        //
        // }
        prev=root.val;
        boolean right = isValidBST(root.right);
        return left&&right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
