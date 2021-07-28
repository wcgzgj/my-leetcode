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

 import java.util.*;

 public class BinaryTreeZigzagLevelOrderTraversal{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
          List<Integer> list = new ArrayList<>();
          list.add(1);
          list.add(2);
          Collections.reverse(list);
          System.out.println(list);
      }
      //leetcode submit region begin(Prohibit modification and deletion)

class Solution {

    /**
     * 这道题，可以看成102的变种
     * 在 102 里，我们获得了每层的节点数据
     * 在这道题里，我们还要做一个奇偶层判断
     * 奇数层从左往右遍历
     * 偶数层从右往左遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res = new ArrayList<>();
        if (root==null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 记录层数
        int lay=1;
        while (!queue.isEmpty()) {
            List<Integer> tmpRes = new ArrayList<>();
            // 记录当前层的节点个数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                tmpRes.add(tmp.val);
                if (tmp.left!=null) queue.offer(tmp.left);
                if (tmp.right!=null) queue.offer(tmp.right);
            }
            // 偶数层从右往左，需要我们对 list 进行一次 reverse 操作
            if (lay%2==0) {
                Collections.reverse(tmpRes);
            }
            res.add(tmpRes);
            lay++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
