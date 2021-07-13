 //给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
// 
//
// 示例 2： 
//
// 输入：[-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出：42 
// Related Topics 树 深度优先搜索 
// 👍 790 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 public class BinaryTreeMaximumPathSum{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeMaximumPathSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    /**
     * 题解中，实现方式，是找寻最大贡献值
     * 最大贡献值，就是该节点往下的和最长的链的值
     * 在获取最大贡献值的同时，还要更新总值
     * 如果当前最大贡献值比总值大，就替换（不是相加，不然会出现重复相加的问题）
     */
    public int sum=0;//记录全局数据
    public int maxPathSum(TreeNode root) {
        sum=root.val;
        maxGain(root);//在获取最大贡献值的同时，也会更新sum
        return sum;
    }

    public int maxGain(TreeNode root) {
        if (root==null) return 0;

        //叶子节点
        //如果叶子节点的值是负数，就不要了，取0
        if (root.left==null && root.right==null) {
            if (root.val>sum) sum=root.val;
            return root.val>0?root.val:0;
        }

        //如果子树的最大贡献值是负数，就不要了，取0
        int leftMax = Math.max(maxGain(root.left), 0);
        int rightMax = Math.max(maxGain(root.right), 0);

        int returnVal = Math.max(root.val + leftMax, root.val + rightMax);
        int currVal = root.val + leftMax + rightMax; //以当前节点为根，形成的桥性链的总值
        if (currVal>sum) sum=currVal; //如果上面的桥形链的总值比sum大，更新sum
        return returnVal;//虽然上面判断的是桥形链，但是，返回的，必须只能是单边链条的值 <- 这里，一定要和上面区分的非常清楚
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
