 //根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 405 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 import java.util.HashMap;
 import java.util.Map;

 public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
      public static void main(String[] args) {
           Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    //其实和前序，中序建树比起来，也就是换汤不换药

    /**
     * 后来发现超出内存限制...座椅跑不出来
     *
     */
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length==0) return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildMyTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }

    public TreeNode buildMyTree(int[] inorder,int [] postorder,int in_start,int in_end,int post_star,int post_end) {
        if (post_star>post_end) return null;//终止条件
        //根节点值
        int root_val = postorder[post_end];
        //根节点值所在的位置
        int root_val_index = map.get(root_val);
        //建立根节点
        TreeNode root = new TreeNode(root_val);
        //左子树节点个数
        int left_tree_size = root_val_index - in_start;


        //递归建树
        root.left=buildMyTree(inorder,postorder,in_start,root_val_index-1,post_star,post_star+left_tree_size-1);
        root.right=buildMyTree(inorder ,postorder ,in_start+1 ,in_end ,post_star+left_tree_size, post_end-1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
