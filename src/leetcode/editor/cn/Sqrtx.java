 //实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 707 👎 0

  
  package leetcode.editor.cn;
  public class Sqrtx{
      public static void main(String[] args) {
           Solution solution = new Sqrtx().new Solution();
          System.out.println(solution.mySqrt(8));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        /**
         * 方法一：二分查找
         */
        int l=0,r=x;
        int res=-1;
        // 二分法的范围条件，应该是两边的边界
        while (l<=r) {
            int mid=(l+r)/2;
            // 这里必须要用 long 类型进行强转，因为 mid 如果给 2147483647,我们就超范围了
            if ((long)mid*mid<=x) {
                res=mid;
                l=mid+1;
            } else {
                r=mid-1;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
