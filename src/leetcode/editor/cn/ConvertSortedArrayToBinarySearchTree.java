 //将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索 
// 👍 638 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 public class ConvertSortedArrayToBinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
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
     * 这道题总有一种似曾相识的感觉
     * 我的解决思路是，每次去数组的中间元素，作为根
     * 然后一直递归，知道结束
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        //下面这个也可以省
        // if (nums.length==0) return null;
        return buildTree(nums,0,nums.length-1);
    }

    public TreeNode buildTree(int []nums,int start,int end) {
        if (start>end) return null;

        int mid =(start+end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=buildTree(nums,start,mid-1);
        root.right=buildTree(nums,mid+1,end);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
