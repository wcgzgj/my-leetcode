 //给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树 
// 👍 667 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 public class PathSumIii{
      public static void main(String[] args) {
           Solution solution = new PathSumIii().new Solution();
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
    int res=0;
    public int pathSum(TreeNode root, int sum) {
        firstRecursion(root,sum);
        return res;
    }

    public void firstRecursion(TreeNode root,int sum) {
        if (root==null) return;
        secondRecursion(root,sum,0);
        firstRecursion(root.left,sum);
        firstRecursion(root.right,sum);
    }

    //二层递归
    public void secondRecursion(TreeNode root,int sum,int pool) {
        if (root==null) return;
        // if (pool>sum) return;//加这句话，就把负数的情况排除了...
        pool+=root.val;
        if (pool==sum) {
            res++;
            // return;
            /**
             * 上面不能直接return
             * 因为可能还有负数的情况
             * 比如下面的节点是-1
             * 再下面的节点是1
             * 这样，就又多了一个可能情况
             */
        }
        secondRecursion(root.left,sum,pool);
        secondRecursion(root.right,sum,pool);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
