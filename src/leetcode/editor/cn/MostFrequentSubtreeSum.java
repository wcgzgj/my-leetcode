 //给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 
//
// 示例 1： 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2： 
//输入： 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 哈希表 
// 👍 94 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.Map;

 public class MostFrequentSubtreeSum{
      public static void main(String[] args) {
           Solution solution = new MostFrequentSubtreeSum().new Solution();
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
class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        recursion(root);
        int maxVal=Integer.MIN_VALUE;
        //找 和 出现的最多的次数
        for (Integer value : map.values()) {
            if (maxVal<value) maxVal=value;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==maxVal) list.add(entry.getKey());
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }

    public void recursion(TreeNode root) {
        if (root==null) return;
        int sum = getSum(root);
        if (map.containsKey(sum)) {
            map.replace(sum,map.get(sum)+1);
        } else {
            map.put(sum,1);
        }
        recursion(root.left);
        recursion(root.right);
    }

    public int getSum(TreeNode root) {
        if (root==null) return 0;
        return getSumRecursion(root,0);
    }

    public int getSumRecursion(TreeNode root,int sum) {
        if (root==null) return 0;
        sum+=root.val;
        sum+=getSumRecursion(root.left,sum);
        sum+=getSumRecursion(root.right,sum);
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
