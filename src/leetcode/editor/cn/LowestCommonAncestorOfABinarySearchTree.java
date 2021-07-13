 //给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
// Related Topics 树 
// 👍 495 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 import java.util.ArrayList;
 import java.util.List;

 public class LowestCommonAncestorOfABinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new LowestCommonAncestorOfABinarySearchTree().new Solution();
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
    /**
     * 方法一：
     * 借助二叉搜索树的性质，获取两个节点的路径
     * 然后，获取两个路径的交叉点
     */
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if (root==null) return null;
    //     List<TreeNode> list1 = getPath(root, p);
    //     List<TreeNode> list2 = getPath(root, q);
    //     for (int i = list1.size()-1; i >=0; i--) {
    //         for (int j = list2.size()-1; j >=0; j--) {
    //             if (list1.get(i)==list2.get(j)) return list1.get(i);
    //         }
    //     }
    //     return null;
    // }
    //
    // //获取从根节点，到该节点的路径
    // public List<TreeNode> getPath(TreeNode root,TreeNode target) {
    //     List<TreeNode> list = new ArrayList<>();
    //     getPath(root,target,list);
    //     return list;
    // }
    //
    // private void getPath(TreeNode root,TreeNode target,List<TreeNode> list) {
    //     if (root.val==target.val) {
    //         list.add(target);
    //         return;
    //     }
    //     list.add(root);
    //     if (root.val>target.val) getPath(root.left,target,list);
    //     else getPath(root.right,target,list);
    // }

    /**
     * 方法二：
     * 运用二叉搜索树的性质
     * 通过一次遍历，得到公共节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;
        //注意，下面的递归一定要加return,不然，根本就不会去返回其值！！！！
        if (root.val <p.val && root.val<q.val) return lowestCommonAncestor(root.right,p,q);
        else if (root.val >p.val && root.val>q.val) return lowestCommonAncestor(root.left,p,q);
        return root;
    }

    // public TreeNode recurison(TreeNode root,int min,int max) {
    //     if (root.val>min && root.val<max) return root;
    //     if (root.val<min && root.val<max ) recurison(root.right,min,max);
    //     return recurison(root.left,min,max);
    // }    //wtf???照理说，不会报错的

    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     TreeNode ancestor = root;
    //     while (true) {
    //         if (ancestor.val<p.val && ancestor.val<q.val) {
    //             ancestor=ancestor.right;
    //         } else if (ancestor.val>p.val && ancestor.val>q.val) {
    //             ancestor=ancestor.left;
    //         } else {
    //             break;
    //         }
    //     }
    //     return ancestor;
    // }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
