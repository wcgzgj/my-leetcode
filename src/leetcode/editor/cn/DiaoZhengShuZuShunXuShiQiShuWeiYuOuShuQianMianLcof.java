 //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 
// 👍 151 👎 0

  package leetcode.editor.cn;
  
  public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
      public static void main(String[] args) {
           Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          // 双指针
    public int[] exchange(int[] nums) {
        if (nums==null || nums.length==0) return nums;
        int l=0,r=nums.length-1;
        while (l<r) {
            while (l<nums.length && nums[l]%2!=0) l++;
            while (r>=0 && nums[r]%2==0) r--;
            if (l<r) {
                int tmp = nums[l];
                nums[l]=nums[r];
                nums[r]=tmp;
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
