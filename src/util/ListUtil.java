package util;

import domain.ListNode;

/**
 * @ClassName ListUtil
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/21 上午10:59
 * @Version 1.0
 **/
public class ListUtil {
    /**
     * 根据数组，构建单向链表
     * @param arr
     * @return
     */
    public static ListNode buildListByArray(int[] arr) {
        if (arr.length==0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode tail=head;
        if (arr.length==1) return head;
        for (int i = 1; i < arr.length; i++) {
            ListNode tmp = new ListNode(arr[i]);
            tail.next=tmp;
            tail=tail.next;
        }
        return head;
    }

    /**
     * 打印单向链表
     * @param head
     */
    public static void outputList(ListNode head) {
        if (head==null) return;
        while (head!=null) {
            if (head.next!=null) {
                System.out.print(head.val+" -> ");
                head=head.next;
            } else {
                System.out.print(head.val);
                head=head.next;
            }
        }
    }


}
