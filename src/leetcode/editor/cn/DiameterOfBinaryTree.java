 //给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 573 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 public class DiameterOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new DiameterOfBinaryTree().new Solution();
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
    //int max=0;
    //public int diameterOfBinaryTree(TreeNode root) {
    //    if (root==null) return 0;
    //    recursion(root);
    //    /**
    //     * 注意：两结点之间的路径长度是以它们之间边的数目表示。
    //     * 计算的是边的数目，因为边的数目比节点数目少一
    //     * 所以，最后答案是要减1的
    //     */
    //    return max-1;
    //}
    //
    //public int recursion(TreeNode root) {
    //    if (root==null) return 0;
    //    int left = recursion(root.left);
    //    int right = recursion(root.right);
    //    max=Math.max(max,left+right+1);
    //    return Math.max(left+1,right+1);
    //}


    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        // 我们要求的是直径，不是路径长度
        return max-1;
    }

    public int recursion(TreeNode root) {
        if (root==null) return 0;
        int lMax = recursion(root.left);
        int rMax = recursion(root.right);
        if (lMax+rMax+1>max) max=lMax+rMax+1;

        /**
         * 返回当前子树最长的边
         * 这里 +1,是为了加上当前的层
         */
        return Math.max(lMax,rMax)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
