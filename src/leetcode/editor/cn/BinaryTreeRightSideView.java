 //给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 366 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 import java.util.ArrayList;
 import java.util.LinkedList;
 import java.util.List;
 import java.util.Queue;

 public class BinaryTreeRightSideView{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeRightSideView().new Solution();
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>list=new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root==null) return list;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            list.add(queue.get(size-1).val);
            for (int i = 0; i < size; i++) {
                TreeNode tmpNode = queue.removeFirst();
                if (tmpNode.left!=null) queue.addLast(tmpNode.left);
                if (tmpNode.right!=null) queue.addLast(tmpNode.right);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
