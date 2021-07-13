 //序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。 
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计 
// 👍 408 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 import java.util.*;

 public class SerializeAndDeserializeBinaryTree{
      public static void main(String[] args) {
          String str = "[1,2,3,null,null,4,5]";
          new Codec().deserialize(str);

      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

static class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return list.toString();
    }

    public void getAllNodes(TreeNode root,List<Integer> list) {
        if (root==null) {
            list.add(null);
            return;
        }
        list.add(root.val);
        getAllNodes(root.left,list);
        getAllNodes(root.right,list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //去除中括号
        data=data.substring(1,data.length()-1);
        //去除空格
        data=data.replaceAll(" ","");
        if (data.length()==0) return null;

        String[] split = data.split(",");
        if (split.length==0) return null;
        LinkedList<String> queue = new LinkedList<>();
        Collections.addAll(queue,split);
        for (String s : queue) {
            System.out.println(s);
        }
        return buildTree(queue);
    }

    public TreeNode buildTree(LinkedList<String>queue) {
        if (queue.getFirst().equals("null")) {
            queue.removeFirst();
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(queue.removeFirst()));
        root.left=buildTree(queue);
        root.right=buildTree(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

  }
