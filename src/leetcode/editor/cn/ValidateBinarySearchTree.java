 //给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 830 👎 0

  
  package leetcode.editor.cn;


 import domain.TreeNode;

 import java.util.ArrayList;
 import java.util.List;

 public class ValidateBinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new ValidateBinarySearchTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)


class Solution {
    /**
     * 方法一：暴力解法
     */
    // public boolean isValidBST(TreeNode root) {
    //     if (root==null) return true;
    //     //这种方法，不能保证某一节点的所有左子树大于或者右=子树都小于它
    //     //比如其右子树的左子树就可能小于它
    //     // if (root.left!=null && root.left.val>=root.val) return false;
    //     // if (root.right!=null && root.right.val<=root.val) return false;
    //     List<TreeNode> leftNodes = getAllNodes(root.left);
    //     List<TreeNode> rightNodes = getAllNodes(root.right);
    //     //保证某一边的所有节点的值全部小于根节点
    //     for (TreeNode node : leftNodes) {
    //         if (node!=null && node.val>=root.val) return false;
    //     }
    //     for (TreeNode node : rightNodes) {
    //         if (node!=null && node.val<=root.val) return false;
    //     }
    //     return (isValidBST(root.left)&&isValidBST(root.right));
    // }
    //
    // //获取某个节点及其包含的所有节点
    // public List<TreeNode> getAllNodes(TreeNode root) {
    //     List<TreeNode> nodes = new ArrayList<>();
    //     if (root==null) return nodes;
    //     nodes.add(root);
    //     nodes.addAll(getAllNodes(root.left));
    //     nodes.addAll(getAllNodes(root.right));
    //     return nodes;
    // }


    /**
     * 方法二：中序遍历
     * 这个最最开始使用方法
     * 性质上是不一样的
     *
     * 下面这个全局变量pre，妙就妙在，能将一串的节点进行对比
     * （如果不能理解的话，大致在头脑中遍历一下运行的过程）
     */
    //这里还必须要用long....不然测试用例中有一个数，会超出Int的范围
    long pre = Long.MIN_VALUE;//使用一个全局变量
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        if (!isValidBST(root.left)) return false;
        //经过左子树的判断，pre已经发生了改变
        //且是左子树最小的节点的值
        if (root.val<=pre) return false;
        pre=root.val;//判断结束以后，一定要更新pre的值
        //因为右子树判断的依据，是root的val
        return isValidBST(root.right);
    }




}
//leetcode submit region end(Prohibit modification and deletion)

  }
