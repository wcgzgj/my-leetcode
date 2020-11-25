 //给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。 
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。 
//
// 计算从根到叶子节点生成的所有数字之和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25. 
//
// 示例 2: 
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026. 
// Related Topics 树 深度优先搜索 
// 👍 291 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 import java.util.ArrayList;
 import java.util.List;

 public class SumRootToLeafNumbers{
      public static void main(String[] args) {
           Solution solution = new SumRootToLeafNumbers().new Solution();
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
    List<String> list = new ArrayList<>();
    String pool="";//数据暂存区
    public int sumNumbers(TreeNode root) {
        if (root==null) return 0;
        getAllPath(root);
        int sum=0;
        for (String s : list) {
            sum+=Integer.parseInt(s);
        }
        return sum;
    }

    public void getAllPath(TreeNode root) {
        if (root==null) return;
        if (root.left==null && root.right==null) {
            pool+=String.valueOf(root.val);
            list.add(pool);
            pool=pool.substring(0,pool.length()-1);//复原pool
            return;
        }
        //非空，也不是叶子节点
        pool+=String.valueOf(root.val);
        getAllPath(root.left);
        getAllPath(root.right);
        pool=pool.substring(0,pool.length()-1);//复原
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
