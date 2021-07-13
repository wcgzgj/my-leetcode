 //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 842 👎 0

  
  package leetcode.editor.cn;


 import domain.TreeNode;

 import java.util.ArrayList;
 import java.util.List;

 public class LowestCommonAncestorOfABinaryTree{
      public static void main(String[] args) {
           Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
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

     /**
      * 终止条件：
      * 当越过叶节点，则直接返回 nullnull ；
      * 当 rootroot 等于 p, qp,q ，则直接返回 rootroot ；
      * 递推工作：
      * 开启递归左子节点，返回值记为 leftleft ；
      * 开启递归右子节点，返回值记为 rightright ；
      * 返回值： 根据 leftleft 和 rightright ，可展开为四种情况；
      * 当 leftleft 和 rightright 同时为空 ：说明 rootroot 的左 / 右子树中都不包含 p,qp,q ，返回 nullnull ；
      * 当 leftleft 和 rightright 同时不为空 ：说明 p, qp,q 分列在 rootroot 的 异侧 （分别在 左 / 右子树），因此 rootroot 为最近公共祖先，返回 rootroot ；
      * 当 leftleft 为空 ，rightright 不为空 ：p,qp,q 都不在 rootroot 的左子树中，直接返回 rightright 。具体可分为两种情况：
      * p,qp,q 其中一个在 rootroot 的 右子树 中，此时 rightright 指向 pp（假设为 pp ）；
      * p,qp,q 两节点都在 rootroot 的 右子树 中，此时的 rightright 指向 最近公共祖先节点 ；
      * 当 leftleft 不为空 ， rightright 为空 ：与情况 3. 同理；
      */
     class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.root值为左节点或者为右节点
        if(root==null || root.val==p.val || root.val==q.val) return root;
        //获取左右递归的结果
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left==null && right==null) return null;
        if (left==null && right!=null) return right;
        if (right==null && left!=null) return left;
        return root;//(left!=null && right!=null)
    }


}
//leetcode submit region end(Prohibit modification and deletion)

  }
