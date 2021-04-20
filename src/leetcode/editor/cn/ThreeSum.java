 //给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2802 👎 0

  
  package leetcode.editor.cn;

 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.List;

 public class ThreeSum{
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
          // int[] nums = {-1, 0, 1, 2, -1, -4};
          int[] nums = {-2,0,0,2,2};
          List<List<Integer>> lists = solution.threeSum(nums);
          System.out.println(lists.toString());
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length<=2) return res;
        int len = nums.length;
        //排序
        Arrays.sort(nums);
        for (int i = 0; i <= len-3; i++) {
            //如果 i 都大于 0 了，那么后面怎么凑都凑不出 0 的
            if (nums[i] > 0) break;
            if (i-1>=0 && nums[i]==nums[i-1]) continue;
            int l = i + 1;
            int r = len - 1;
            while (l < r) {

                int sum = nums[l] + nums[r] + nums[i];
                if (sum == 0) {
                    //去重
                    if (l+1<r-1 && (nums[l]==nums[l+1]&&nums[r]==nums[r-1])) {
                        l++;
                        r--;
                        continue;
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
