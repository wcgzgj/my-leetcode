package test;

import domain.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName MemoryLimitTest
 * @Description 测试一下内存极限
 * 为了防止 new 出的空间被 GC掉，需要用一个链表来存储所有 new 出的空间
 * @Author faro_z
 * @Date 2021/7/27 11:14 上午
 * @Version 1.0
 **/
public class MemoryLimitTest {
    public static void main(String[] args) {
        // 这里我们尝试创建一个长度为 Integer.MAX_VALUE 的链表，看看会不会报错
        // 改成多线程操作

        // 换成多线程操作，还是跑不满。。。。
        List<ListNode> heads = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            new Thread(()-> {
                ListNode head = createList(100000000);
                // 存储head信息，避免被 GC
                heads.add(head);
            }).start();
        }

        for (ListNode head : heads) {
            outList(head);
        }
    }

    /**
     * 构造长度为 n 的链表
     * @param n
     * @return
     */
    public static ListNode createList(int n) {
        if (n<=1) return null;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (int i = 1; i < n; i++) {
            ListNode tmp = new ListNode(i);
            System.out.println(Thread.currentThread()+"正在创建节点："+i);
            tail.next=tmp;
            tail=tail.next;
        }
        return head;
    }

    /**
     * 输出链表信息
     * @param head
     */
    public static void outList(ListNode head) {
        while (head!=null) {
            System.out.print(head.val+"  ");
            head=head.next;
        }
    }


}
