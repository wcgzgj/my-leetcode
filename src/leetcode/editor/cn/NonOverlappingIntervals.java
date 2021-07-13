 //给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心 数组 动态规划 排序 
// 👍 437 👎 0

  
  package leetcode.editor.cn;

 import java.util.Arrays;
 import java.util.Comparator;

 public class NonOverlappingIntervals{
      public static void main(String[] args) {
           Solution solution = new NonOverlappingIntervals().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals==null || intervals.length==0) {
            return 0;
        }

        /**
         * 按照区间的末尾，由小到大排序
         */
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]>o2[1]) {
                    return 1;
                }
                return -1;
            }
        });
        /**
         * 记录应被去除的区间个数
         */
        int count = 0;
        for (int i = 1; i <intervals.length ; i++) {
            int step=1;
            while ( i-step>=0 && intervals[i-step][1]==-1) {
                step++;
            }
            /**
             * 要和前面没被删除的区间进行比较
             */
            if (intervals[i][0]<intervals[i-step][1]) {
                /**
                 * 将该区间的末尾标记为-1，表示该区间被删除
                 */
                intervals[i][1]=-1;
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
