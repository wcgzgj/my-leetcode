 //给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 897 👎 0

  
  package leetcode.editor.cn;
  public class UniqueBinarySearchTrees{
      public static void main(String[] args) {
           Solution solution = new UniqueBinarySearchTrees().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        /**
         * 这道题的精髓在于，对递归的推理
         * 虽然看起来像dp，但其实应该不是dp
         * 下面要来还原一下推理过程:
         *
         * 解题思路
         * 标签：动态规划
         * 假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
         * G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n)
         *
         * 当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
         * f(i) = G(i-1)*G(n-i)
         *
         * 综合两个公式可以得到 卡特兰数 公式
         * G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
         */
        //使用数组来模拟递归
        
        int []G=new int[n+1];
        //当前没有节点
        G[0]=1;
        G[1]=1;
        for (int i = 2; i <=n; i++) {
            for (int j = 1; j <=i ; j++) {
                G[i]+=G[j-1]*G[i-j];
            }
        }

        return G[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
