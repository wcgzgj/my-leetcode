 //给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表 
// 👍 436 👎 0

  
  package leetcode.editor.cn;

 import com.sun.tools.javadoc.Start;
 import domain.ListNode;
 import domain.TreeNode;

 import java.util.ArrayList;
 import java.util.List;

 public class ConvertSortedListToBinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new ConvertSortedListToBinarySearchTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

    public TreeNode sortedListToBST(ListNode head) {
        if (head==null) return null;
        int[] arr = getArr(head);
        TreeNode root = dfs(arr, 0, arr.length - 1);
        return root;
    }

    public TreeNode dfs(int[] arr,int start,int end) {
        if (start>end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left=dfs(arr,start,mid-1);
        root.right=dfs(arr,mid+1,end);
        return root;
    }

    public int[] getArr(ListNode head) {
        if (head==null) return null;
        List<Integer> list = new ArrayList<>();
        while (head!=null) {
            list.add(head.val);
            head=head.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
