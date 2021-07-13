 //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1747 👎 0

  
  package leetcode.editor.cn;

 import java.util.HashMap;
 import java.util.HashSet;
 import java.util.Map;
 import java.util.Set;

 public class SingleNumber{
      public static void main(String[] args) {
           Solution solution = new SingleNumber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //方法1：暴力解法
    // public int singleNumber(int[] nums) {
    //     int n = nums.length;
    //     for (int i = 0; i < n; i++) {
    //         int count=1;
    //         for (int j =0; j < n; j++) {
    //             if (i==j) {
    //                 continue;
    //             }
    //             if (nums[i]==nums[j]) count++;
    //         }
    //         if (count<2) {
    //             return nums[i];
    //         }
    //     }
    //     return 0;
    // }

    //方法2：借助hashmap
    // public int singleNumber(int[] nums) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int num : nums) {
    //         Integer tmp = map.get(num);
    //         tmp=tmp==null?1:tmp++;
    //         map.put(num,tmp);
    //     }
    //     for (Integer num : map.keySet()) {
    //         if (map.get(num)==1) return num;
    //     }
    //     return -1;
    // }

      //方法3：异或
      public int singleNumber(int[] nums) {
          int ans = nums[0];
          for (int i = 1; i < nums.length; i++) {
              //异或情况下，
              //相同的数字异或，全为0
              //任何数字和0异或
              ans^=nums[i];
          }
          return ans;
      }


}
//leetcode submit region end(Prohibit modification and deletion)

  }
