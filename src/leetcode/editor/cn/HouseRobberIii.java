 //在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 
// 👍 649 👎 0

  
  package leetcode.editor.cn;

 import domain.TreeNode;

 import java.util.LinkedList;
 import java.util.Queue;

 public class HouseRobberIii{
      public static void main(String[] args) {
           Solution solution = new HouseRobberIii().new Solution();
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
    // int max=0;
    // public int rob(TreeNode root) {
    //     if (root==null) return 0;
    //     recursion(root,0);
    //     return max;
    // }
    //
    // public void recursion(TreeNode root,int sum) {
    //     if (root==null) return;
    //     if (root.left==null && root.right==null) {
    //         if (sum+root.val>max) {
    //             max=sum+root.val;
    //             return;
    //         }
    //     }
    //     recursion(root.left,sum+root.val);
    //     recursion(root.right,sum+root.val);
    // }

    /**
     * 我发现，我上面的题理解错了
     * 所以答案不对
     *
     * 后来我发现，只是取得二叉树的不同层的和，
     * 没有包含所有的情况（比如如下的枝）
     *      10
     *      /
     *     1
     *    /
     *   2
     *  /
     * 12
     * 这个时候，取头尾，明显最大
     * 但是，头尾的层号，不是只间隔2的
     */
    // public int rob(TreeNode root) {
    //     int odd=0;//奇数层总和
    //     int even=0;//偶数层总和
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     if (root==null) return 0;
    //
    //     int level=0;
    //     queue.offer(root);
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         int sum=0;
    //         for (int i = 0; i < size; i++) {
    //             TreeNode tmp = queue.poll();
    //             sum+=tmp.val;
    //             if (tmp.left!=null) queue.offer(tmp.left);
    //             if (tmp.right!=null) queue.offer(tmp.right);
    //         }
    //         if (level%2==0) even+=sum;
    //         else odd+=sum;
    //         level++;
    //     }
    //     return even>=odd?even:odd;
    // }


    /**
     * 4 个孙子偷的钱 + 爷爷的钱 VS 两个儿子偷的钱
     * 哪个组合钱多，就当做当前节点能偷的最大钱数。
     * 这就是动态规划里面的最优子结构
     */
    //方法一：递归，但是耗时太长
    // public int rob(TreeNode root) {
    //     if(root==null) return 0;
    //     int money=root.val;
    //     if (root.left!=null) {
    //         money+=rob(root.left.left);
    //         money+=rob(root.left.right);
    //     }
    //     if (root.right!=null) {
    //         money+=rob(root.right.left);
    //         money+=rob(root.right.right);
    //     }
    //     return Math.max(money, rob(root.left)+rob(root.right));
    // }

    //方法二：树形dp
    public int rob(TreeNode root) {
        int[] dfs = dfs(root);
        return Math.max(dfs[0],dfs[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root==null) return new int[]{0,0};

        //后序遍历
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] dp = new int[2];
        //根节点不选，左右节点可选可不选
        dp[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        //选根节点，左右节点不能选
        dp[1]=root.val+left[0]+right[0];

        return dp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
