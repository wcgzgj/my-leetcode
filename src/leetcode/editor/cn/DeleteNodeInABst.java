 //给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树 
// 👍 347 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 public class DeleteNodeInABst{
      public static void main(String[] args) {
           Solution solution = new DeleteNodeInABst().new Solution();
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) return root;

        //找到要被删除的节点
        TreeNode delNode = searchRoot(root, key);
        //没有该节点，直接返回根节点
        if (delNode==null) return root;
        TreeNode parent = findParent(root, delNode);
        if (parent==null) {//父节点是空节点，说明被删的是根节点
            TreeNode left = parent.left;
            TreeNode right = parent.right;
            if (left==null && right==null) return null;
            TreeNode tmp=left;
            if (tmp==null) tmp=right;
        }



        return null;
    }

    public TreeNode searchRoot(TreeNode root,int key) {
        if (root==null) return null;
        if (root.val==key) return root;
        TreeNode res=null;
        res=searchRoot(root.left,key);
        if (res!=null) return res;
        res=searchRoot(root.right,key);
        return res;
    }

    //找寻target的父节点
    public TreeNode findParent(TreeNode root,TreeNode target) {
        if (root==null) return null;
        if ((root.left!=null && root.left.val==target.val) ||
                (root.right!=null && root.right.val==target.val)) {
            return root;
        }
        TreeNode res=null;
        res=findParent(root.left,target);
        if (res!=null) return res;
        res=findParent(root.right,target);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
