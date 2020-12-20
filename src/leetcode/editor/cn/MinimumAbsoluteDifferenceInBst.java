 //给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 218 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 public class MinimumAbsoluteDifferenceInBst{
      public static void main(String[] args) {
           Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
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
    /**
     * 因为题目中给出的是二叉搜索树
     * 所以我认为，最小的差，应该在中序遍历中
     * 相邻的两个数之间
     */
    int pre=-1;//说了是非负数
    int min=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        recursion(root);
        return min;
    }

    //中序遍历
    public void recursion(TreeNode root) {
        if (root==null) return;
        recursion(root.left);
        if (pre==-1) pre=root.val;
        else {
            min=Math.min(min,Math.abs(pre-root.val));
            pre=root.val;
        }
        recursion(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
