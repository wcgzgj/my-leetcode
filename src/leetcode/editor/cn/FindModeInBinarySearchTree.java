 //给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 247 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.zip.Adler32;

 public class FindModeInBinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new FindModeInBinarySearchTree().new Solution();
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
    /**
     * 解法一：没有用到二叉搜树的性质
     */
    // public int[] findMode(TreeNode root) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     DFS(root,map);
    //     int maxVal=Integer.MIN_VALUE;
    //     for (Integer value : map.values()) {
    //         if (value>maxVal) maxVal=value;
    //     }
    //     List<Integer> list = new ArrayList<>();
    //     for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //         if (entry.getValue()==maxVal) list.add(entry.getKey());
    //     }
    //     int[] arr = new int[list.size()];
    //     for (int i = 0; i < arr.length; i++) {
    //         arr[i]=list.get(i);
    //     }
    //     return arr;
    // }
    //
    // public void DFS(TreeNode root,Map<Integer,Integer>map) {
    //     if (root==null) return;
    //     if (map.containsKey(root.val)) {
    //         map.replace(root.val,map.get(root.val)+1);
    //     } else {
    //         map.put(root.val,1);
    //     }
    //     DFS(root.left,map);
    //     DFS(root.right,map);
    // }

    /**
     *方法二：使用二叉搜索树的特性
     */
    //  当前数值       当前数值出现的次数   同一数字出现的最多次数
    int currentNum,currentNumCount,maxCount;
    //临时记录众数，找到更高的，就清空，然后新增
    List<Integer> result = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        midRecursion(root);
        int[] arr = new int[result.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=result.get(i);
        }
        return arr;
    }

    public void midRecursion(TreeNode root) {
        if (root==null) return;
        midRecursion(root.left);
        update(root.val);
        midRecursion(root.right);
    }

    public void update(int val) {
        if (currentNum==val) {
            currentNumCount++;
        } else {
            currentNum=val;
            currentNumCount=1;
        }
        if (maxCount==currentNumCount) {
            result.add(currentNum);
        }
        if (maxCount<currentNumCount) {
            maxCount=currentNumCount;//要更新最大数据
            result.clear();
            result.add(currentNum);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
