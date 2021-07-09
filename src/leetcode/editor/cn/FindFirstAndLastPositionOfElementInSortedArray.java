 //给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1088 👎 0

  
  package leetcode.editor.cn;

 import java.util.Arrays;

 public class FindFirstAndLastPositionOfElementInSortedArray {
     public static void main(String[] args) {
         Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
         int[] data = {5, 7, 7, 8, 8, 10};
         int[] data2 = {};
         int res = solution.higher(data2, 8);
         System.out.println(res);
     }

     //leetcode submit region begin(Prohibit modification and deletion)
     class Solution {
         public int[] searchRange(int[] nums, int target) {
             /**
              * 方法3：二分查找
              * 因为数组是排好序的
              * 使用二分查找，分别找寻范围的左区间和右区间
              */

             return null;
         }

         public int lower(int[] nums,int target) {
             int l=0,r=nums.length-1;
             int mid=0;
             while (l<r) {
                 mid=(l+r)/2;
                 if (nums[mid]>=target) r=mid-1;
                 else l=mid+1;
             }
             return l;
         }

         public int higher(int[] nums,int target) {
             int l=0,r=nums.length-1;
             int mid=0;
             while (l<r) {
                 mid=(l+r)/2;
                 if (nums[mid]<=target) l=mid+1;
                 else r=mid-1;
             }
             return r;
         }
//leetcode submit region end(Prohibit modification and deletion)

     }


 }
