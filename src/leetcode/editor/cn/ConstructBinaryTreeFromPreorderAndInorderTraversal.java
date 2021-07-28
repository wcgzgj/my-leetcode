 //根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 762 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 import java.util.Arrays;
 import java.util.HashMap;
 import java.util.Map;

 public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
      public static void main(String[] args) {
           Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
          int [] pre_order = {3,9,20,15,7};
          int [] in_order = {9,3,15,20,7};
          TreeNode root = solution.buildTree(pre_order, in_order);

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0 || inorder.length==0) return null;
        // 前序序列的第一个元素，一定是整棵树的根节点
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            /**
             * 找到中序遍历中，根节点的位置
             * 此时，i 就是左子树的长度
             * inorder.length - (i+1) 就是右子树的长度
             */
            if (preorder[0]==inorder[i]) {
                int[] pre_left = Arrays.copyOfRange(preorder, 1, i+1);
                int[] pre_right = Arrays.copyOfRange(preorder, i + 1, preorder.length);

                int[] in_left = Arrays.copyOfRange(inorder, 0, i);
                int[] in_right = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left=buildTree(pre_left,in_left);
                root.right=buildTree(pre_right,in_right);
                break;
            }
        }
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
