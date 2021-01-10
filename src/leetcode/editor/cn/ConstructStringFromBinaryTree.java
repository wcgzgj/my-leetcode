 //你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。 
//
// 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。 
//
// 示例 1: 
//
// 
//输入: 二叉树: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /    
//  4     
//
//输出: "1(2(4))(3)"
//
//解释: 原本将是“1(2(4)())(3())”，
//在你省略所有不必要的空括号对之后，
//它将是“1(2(4))(3)”。
// 
//
// 示例 2: 
//
// 
//输入: 二叉树: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \  
//      4 
//
//输出: "1(2()(4))(3)"
//
//解释: 和第一个示例相似，
//除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
// 
// Related Topics 树 字符串 
// 👍 168 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 public class ConstructStringFromBinaryTree{
      public static void main(String[] args) {
           Solution solution = new ConstructStringFromBinaryTree().new Solution();
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
     * 几种情况分布如下：
     * 1. 左右子树都不为空，都套上括号
     * 2. 左子树为空，左子树套上括号
     * 3. 右子树为空，不用管
     */
    String res="";
    public String tree2str(TreeNode t) {
        if (t==null) return "";
        if (t.left==null && t.right==null) {
            return t.val+"";
        } else if (t.right==null) {
            return t.val+"("+tree2str(t.left)+")";
        } else if (t.left==null) {
            return t.val+"()"+"("+tree2str(t.right)+")";
        }
        return t.val+"("+tree2str(t.left)+")"+"("+tree2str(t.right)+")";
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
