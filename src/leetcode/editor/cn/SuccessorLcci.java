 //设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// Related Topics 树 深度优先搜索 
// 👍 38 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 public class SuccessorLcci{
      public static void main(String[] args) {
           Solution solution = new SuccessorLcci().new Solution();
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root==null) return null;
        if (root.val==p.val) return root.right;
        return getRecursion(root,p.val,false);
    }

    //need表示当前的节点是否需要
    //递归前一层的root值如果为target，会将need设置为true
    //这样，就会返回递归下一层的节点
    public TreeNode getRecursion(TreeNode root,int target,boolean need) {
        if (need==true) return root;
        if (root==null) return null;
        TreeNode leftNode = getRecursion(root.left, target, false);
        if (root.val==target) {
            // return getRecursion(root)
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
