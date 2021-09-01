 //请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
//
// 
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-point
//er/ 
//
// 
// Related Topics 哈希表 链表 
// 👍 275 👎 0

  package leetcode.editor.cn;

 import domain.random.Node;

 import java.util.HashMap;
 import java.util.Map;

 public class FuZaLianBiaoDeFuZhiLcof{
      public static void main(String[] args) {
           Solution solution = new FuZaLianBiaoDeFuZhiLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
          /**
           * 做这道题，我们的思路是存储原原链表节点和新创建的链表节点的关系映射
           * 然后使用这层映射，为新链表建立节点之间的联系
           * @param head
           * @return
           */
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        // 建立新老节点的关系映射
        while (curr!=null) {
            map.put(curr,new Node(curr.val));
            curr=curr.next;
        }
        curr=head;
        while (curr!=null) {
            map.get(curr).next=map.get(curr.next);
            map.get(curr).random=map.get(curr.random);
            curr=curr.next;
        }
        // 获取新链表的头，不要直接返回 head 了
        return map.get(head);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
