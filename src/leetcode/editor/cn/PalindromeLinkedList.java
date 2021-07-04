 //请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 
// 👍 1035 👎 0

  
  package leetcode.editor.cn;

 import domain.ListNode;
 import org.junit.jupiter.api.Test;
 import test.ArrayListIndexTest;

 import java.util.ArrayList;
 import java.util.List;

 public class PalindromeLinkedList{
      public static void main(String[] args) {
           Solution solution = new PalindromeLinkedList().new Solution();
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
    public boolean isPalindrome(ListNode head) {
        /**
         * 方法一: 链表转数组
         */
        if (head==null) return true;
        List<Integer> list = new ArrayList<>();
        while (head!=null) {
            list.add(head.val);
            head=head.next;
        }
        int i=0,j=list.size()-1;
        while (i<=j) {
            if (list.get(i)!=list.get(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
