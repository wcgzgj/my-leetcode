 //实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。 
//
// 调用 next() 将返回二叉搜索树中的下一个最小的数。 
//
// 
//
// 示例： 
//
// 
//
// BSTIterator iterator = new BSTIterator(root);
//iterator.next();    // 返回 3
//iterator.next();    // 返回 7
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 9
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 15
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 20
//iterator.hasNext(); // 返回 false 
//
// 
//
// 提示： 
//
// 
// next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。 
// 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。 
// 
// Related Topics 栈 树 设计 
// 👍 285 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 import java.util.ArrayList;
 import java.util.List;

 // public class BinarySearchTreeIterator{
 //      public static void main(String[] args) {
 //           BSTIterator solution = new BinarySearchTreeIterator().new BSTIterator();
 //      }
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
class BSTIterator {
    List<Integer> list=new ArrayList<Integer>();
    int index;

    public BSTIterator(TreeNode root) {
        index=-1;
        getAllNodes(root);
    }

    //获取中序遍历
    private void getAllNodes(TreeNode root) {
        if (root==null) return;
        getAllNodes(root.left);
        list.add(root.val);
        getAllNodes(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        //注意了，一定是前++，
        //因为index初始值是-1,所以必须是先加，后用
        return list.get(++index);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index+1<list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

  //}
