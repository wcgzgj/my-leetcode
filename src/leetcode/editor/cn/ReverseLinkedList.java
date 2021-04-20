 //反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1433 👎 0

  
  package leetcode.editor.cn;

 import domain.ListNode;

 import java.util.Stack;

 public class ReverseLinkedList{
      public static void main(String[] args) {
           Solution solution = new ReverseLinkedList().new Solution();
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
    public ListNode reverseList(ListNode head) {
        //方法1：使用栈
        // if (head==null) return head;
        // Stack<ListNode> stack = new Stack<>();
        // while (head!=null) {
        //     stack.push(head);
        //     head=head.next;
        // }
        // head=stack.pop();
        // ListNode tail = head;
        // while (!stack.isEmpty()) {
        //     tail.next=stack.pop();
        //     tail=tail.next;
        // }
        // tail.next=null;
        // return head;

        //方法2：递归
        ListNode curr = head;
        ListNode prev=null;
        while (curr!=null) {
            ListNode tmp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=tmp;
        }
        return prev;

        //方法3：递归

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
