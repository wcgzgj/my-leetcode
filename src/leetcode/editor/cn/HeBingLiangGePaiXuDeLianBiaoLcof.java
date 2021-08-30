 //输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 
// 👍 155 👎 0

  package leetcode.editor.cn;

 import domain.ListNode;

 public class HeBingLiangGePaiXuDeLianBiaoLcof{
      public static void main(String[] args) {
           Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        while (l1!=null && l2!=null) {
            if (l1.val<= l2.val) {
                tail.next=l1;
                tail=tail.next;
                l1=l1.next;
            } else {
                tail.next=l2;
                tail=tail.next;
                l2=l2.next;
            }
        }
        while (l1!=null) {
            tail.next=l1;
            tail=tail.next;
            l1=l1.next;
        }
        while (l2!=null) {
            tail.next=l2;
            tail=tail.next;
            l2=l2.next;
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
