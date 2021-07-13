 //给定一个二叉树，在树的最后一行找到最左边的值。 
//
// 示例 1: 
//
// 
//输入:
//
//    2
//   / \
//  1   3
//
//输出:
//1
// 
//
// 
//
// 示例 2: 
//
// 
//输入:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
//输出:
//7
// 
//
// 
//
// 注意: 您可以假设树（即给定的根节点）不为 NULL。 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 140 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 import java.util.Iterator;
 import java.util.LinkedList;
 import java.util.Queue;

 public class FindBottomLeftTreeValue{
      public static void main(String[] args) {
           Solution solution = new FindBottomLeftTreeValue().new Solution();
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode res=null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // if (isBottom(queue,size)) {
            //     return queue.poll().val;
            // }
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (i==0) res=tmp;
                if (tmp.left!=null) queue.offer(tmp.left);
                if (tmp.right!=null) queue.offer(tmp.right);
            }
        }
        //如果上面的代码正确，是不会返回-1的
        return res.val;
    }

    //判断是不是底层
    public boolean isBottom(Queue<TreeNode>queue,int size) {
        Iterator<TreeNode> iterator = queue.iterator();
        for (int i = 0; i < size; i++) {
            TreeNode node = iterator.next();
            if (!isLeaf(node)) return false;
        }
        return true;
    }

    //判断是不是叶子节点
    public boolean isLeaf(TreeNode root) {
        if (root==null) return false;
        if (root.left==null && root.right==null) return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
