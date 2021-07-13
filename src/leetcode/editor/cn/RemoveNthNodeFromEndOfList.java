 //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1327 👎 0

  
  package leetcode.editor.cn;

 import domain.ListNode;
 import util.ListUtil;

 public class RemoveNthNodeFromEndOfList{
      public static void main(String[] args) {
           Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
          int[] arr = {1, 2};
          ListNode head = ListUtil.buildListByArray(arr);
          head=solution.removeNthFromEnd(head,2);
          ListUtil.outputList(head);
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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode next=head;
        ListNode headPoint=head;
        for (int i = 0; i < n; i++) {
            next=next.next;
        }
        //pre 是我们要删除的节点的前一个节点
        ListNode pre=head;
        while (next!=null) {
            next=next.next;
            /**
             * 初始状态下
             */
            if (pre!=headPoint) {
                pre=pre.next;
            }
            headPoint=headPoint.next;
        }

        if (head==headPoint) {
            head=head.next;
        } else {
            pre.next=headPoint.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
