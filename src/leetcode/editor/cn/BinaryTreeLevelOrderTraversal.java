 //给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 698 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 import java.util.ArrayList;
 import java.util.LinkedList;
 import java.util.List;
 import java.util.Queue;

 public class BinaryTreeLevelOrderTraversal{
      public static void main(String[] args) {
          Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
          TreeNode n1 = new TreeNode(3);
          TreeNode n2 = new TreeNode(9);
          TreeNode n3 = new TreeNode(20);
          TreeNode n4 = new TreeNode(15);
          TreeNode n5 = new TreeNode(7);
          // root = n1
          n1.left=n2;
          n1.right=n3;
          n3.left=n4;
          n3.right=n5;

          List<List<Integer>> res = solution.levelOrder(n1);
          for (List<Integer> re : res) {
              System.out.println(re);
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)


class Solution {

    /**
     * 这个层次遍历，不只是简单的层次输出，而是要把每层的信息单独记录下来
     * 想要实现这个效果，也很简单
     * 在每层遍历之前，先记录下队列的大小 size （这时，队列的大小就是当前层的个数）
     * 然后，在 size 的范围内进行一般层次遍历的操作
     * 当 size 个数的节点被 pop 完后，队列中剩下的就是下一层的所有接节点
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res = new ArrayList<>();
        if (root==null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 这里的空判断，不要写成 queue!=null 了，而是要写成 !queue.isEmpty
        while (!queue.isEmpty()) {
            ArrayList<Integer> tmpRes = new ArrayList<>();
            // 记录当前层的个数，当当前层都 pop 出来后，剩下的就是下一层的节点了
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                tmpRes.add(tmp.val);
                if (tmp.left!=null) queue.offer(tmp.left);
                if (tmp.right!=null) queue.offer(tmp.right);
            }
            res.add(tmpRes);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
