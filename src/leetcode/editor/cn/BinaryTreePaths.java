 //给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 404 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 import java.util.ArrayList;
 import java.util.List;

 public class BinaryTreePaths{
      public static void main(String[] args) {
           Solution solution = new BinaryTreePaths().new Solution();
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
    List<TreeNode> list = new ArrayList<>();
    List<String> stringList = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        getPath(root);
        return stringList;
    }

    public void getPath(TreeNode root) {
        if (root==null) return;
        list.add(root);
        if (root.left==null && root.right==null) {
            stringList.add(listToString(list));
            list=list.subList(0,list.size()-1);
            return;
        }
        getPath(root.left);
        getPath(root.right);
        list=list.subList(0,list.size()-1);
    }

    public String listToString(List<TreeNode> list) {
        if (list.size()==0) return null;
        String pool = "";
        for (int i = 0; i < list.size() - 1; i++) {
            pool+=String.valueOf(list.get(i).val)+"->";
        }
        pool+=String.valueOf(list.get(list.size()-1).val);
        return pool;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
