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

 import java.util.HashMap;
 import java.util.Map;

 public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
      public static void main(String[] args) {
           Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
    //用来存放中序遍历中数组元素的下标
    //方便通过前序遍历中的数组元素，找寻中序遍历中相同元苏的位置
    public Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0) return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildMyTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode buildMyTree(int[] preorder,int[] inorder,int pre_start,int pre_end,int in_start,int in_end) {
        if (pre_start>pre_end) return null;//终止条件

        //根节点值
        int root_val = preorder[pre_start];
        //根节点值所在的位置
        Integer root_val_index = map.get(root_val);
        TreeNode root = new TreeNode(root_val);

        //左子树节点个数
        int left_tree_size = root_val_index - in_start;

        //递归建树
        root.left=buildMyTree(preorder,inorder,pre_start+1,pre_start+left_tree_size,in_start,root_val_index-1);
        root.right=buildMyTree(preorder,inorder,pre_start+1+left_tree_size,pre_end,root_val_index+1,in_end);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
