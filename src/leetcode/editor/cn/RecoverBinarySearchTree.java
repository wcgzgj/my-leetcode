 //给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 
// 👍 369 👎 0

  
  package leetcode.editor.cn;

 import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;
 import domain.TreeNode;

 import java.util.ArrayList;
 import java.util.List;

 public class RecoverBinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new RecoverBinarySearchTree().new Solution();
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
    public void recoverTree(TreeNode root) {
        if (root==null) return;
        List<TreeNode> list = new ArrayList<>();
        getAllNodes(root,list);
        TreeNode[] nodes = list.toArray(new TreeNode[list.size()]);
        TreeNode x=null;
        TreeNode y=null;
        for (int i = 0; i < nodes.length - 1; i++) {
            if (nodes[i].val>nodes[i+1].val) {
                y=nodes[i+1];
                //如果x还为null，说明大的那个值还没有找到
                if (x==null) {
                    x=nodes[i];
                }
            }
        }
        if (x!=null && y!=null) {
            int tmp = y.val;
            y.val=x.val;
            x.val=tmp;
        }

        //存放地址的列表
        // List<Integer> indexs = new ArrayList<>();
        // for (int i = 0; i < nodes.length; i++) {
        //     if (i+1<nodes.length && nodes[i].val>nodes[i+1].val && indexs.size()==0) {
        //         System.out.println(i);
        //         indexs.add(i);
        //         continue;
        //     }
        //     if (i-1>=0 && nodes[i].val<nodes[i-1].val && indexs.size()==1) {
        //         indexs.add(i);
        //         continue;
        //     }
        // }
        // System.out.println(indexs.toString());
        // int index1=indexs.get(0);
        // int index2=indexs.get(1);
        // int tmp = nodes[index1].val;
        // nodes[index1].val=nodes[index2].val;
        // nodes[index2].val=tmp;
    }

    /**
     * 通过中序遍历，将所有节点放入list中
     * @param root
     * @return
     */
    public void getAllNodes(TreeNode root,List<TreeNode>list) {
        //空节点不要
        if (root==null) return;
        getAllNodes(root.left,list);
        list.add(root);
        getAllNodes(root.right,list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
