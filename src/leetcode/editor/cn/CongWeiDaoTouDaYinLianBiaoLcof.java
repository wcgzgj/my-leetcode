 //输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 
// 👍 175 👎 0

  package leetcode.editor.cn;

 import domain.ListNode;

 import java.util.ArrayList;
 import java.util.List;

 public class CongWeiDaoTouDaYinLianBiaoLcof{
      public static void main(String[] args) {
           Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
          ListNode n1 = new ListNode(1);
          ListNode n2 = new ListNode(2);
          ListNode n3 = new ListNode(3);
          n1.next=n2;
          n2.next=n3;
          ListNode head = solution.reverse(n1);
          while (head!=null) {
              System.out.println(head.val);
              head=head.next;
          }
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
    public int[] reversePrint(ListNode head) {
        head = reverse(head);
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

    // 反转链表
    public ListNode reverse(ListNode head) {
        if (head==null) return null;
        ListNode pre=null,curr=head;
        while (curr!=null) {
            ListNode tmp = curr.next;
            curr.next=pre;
            pre=curr;
            curr=tmp;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
