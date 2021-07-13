 //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1495 👎 0

  
  package leetcode.editor.cn;

 import domain.ListNode;

 public class MergeTwoSortedLists{
      public static void main(String[] args) {
           Solution solution = new MergeTwoSortedLists().new Solution();
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 方法1 递归
         */
        // if (l1==null) return l2;
        // if (l2==null) return l1;
        // if (l1.val<=l2.val) {
        //     l1.next=mergeTwoLists(l1.next,l2);
        //     return l1;
        // }
        // if (l2.val<l1.val) {
        //     l2.next=mergeTwoLists(l1,l2.next);
        //     return l2;
        // }
        // return null;

        /**
         * 方法2 迭代
         */
        ListNode head=new ListNode(-1);
        ListNode tail=head;
        while (l1!=null && l2!=null) {
            // if (l1.val<=l2.val) {
            //     if (head==null) {
            //         head=l1;
            //         tail=head;
            //     } else {
            //         tail.next=l1;
            //         tail=tail.next;
            //         l1=l1.next;
            //     }
            // } else { // l2.val<l1.val
            //     if (head==null) {
            //         head=l2;
            //         tail=head;
            //     } else {
            //         tail.next=l2;
            //         tail=tail.next;
            //         l2=l2.next;
            //     }
            // }
            if(l1.val<=l2.val) {
                tail.next=l1;
                l1=l1.next;
            } else {
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }

        // 收尾工作
        tail.next=l1==null?l2:l1;

        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
