 //给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 298 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 import java.util.ArrayList;
 import java.util.LinkedList;
 import java.util.List;
 import java.util.Queue;

 public class BinaryTreeZigzagLevelOrderTraversal{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        //记录遍历的层数
        int level = 0;
        que.offer(root);
        while (!que.isEmpty()) {
            //记录当前层的元素
            List<Integer> item = new LinkedList<>();
            /**
             * 一定要提前获取当前的层数
             * 不然queue的大小会随着后的进队列不断改变
             */
            int size = que.size();
            //保证是在当层遍历
            for (int i = 0; i < size; i++) {
                TreeNode tmp = que.poll();
                if (tmp.left!=null) que.offer(tmp.left);
                if (tmp.right!=null) que.offer(tmp.right);

                if (level%2==0) {//偶数层头插
                    item.add(tmp.val);
                } else { //奇数层尾插
                    item.add(0,tmp.val);
                }
            }
            res.add(item);
            level++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
