 //给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索 
// 👍 633 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 import java.util.ArrayList;
 import java.util.Deque;
 import java.util.LinkedList;
 import java.util.Queue;

 public class FlattenBinaryTreeToLinkedList{
      public static void main(String[] args) {
           Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
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
    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        getRootQueue(queue,root);
        clearAllRoot(queue);
        queue.poll();
        buildTree(root,queue);
    }
    public void getRootQueue(Queue<TreeNode>queue,TreeNode root) {
        if (root==null) return;
        queue.offer(root);
        getRootQueue(queue,root.left);
        getRootQueue(queue,root.right);
    }

    public void buildTree(TreeNode root,Queue<TreeNode> queue) {
        if (queue.size()==0) {
            if (root!=null && root.right!=null) root.right=null;
            return;
        }
        root.right=queue.poll();
        buildTree(root.right,queue);
    }

    //加入队列的节点，其枝都必须为空
    public void clearAllRoot(Queue<TreeNode> queue){
        for (TreeNode node : queue) {
            if (node!=null) {
                if (node.left!=null) node.left=null;
                if (node.right!=null) node.right=null;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
