 //输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 295 👎 0

  package leetcode.editor.cn;

 import java.util.Arrays;

 public class ZuiXiaoDeKgeShuLcof{
      public static void main(String[] args) {
           Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
          int[]arr = {4,3,2,5,8,4};
          solution.quickSort(arr,0,arr.length-1);
          System.out.println(Arrays.toString(arr));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 方法一-1：排序再获取（直接使用 SDK 中的排序工具）
        //int[] res = new int[k];
        //Arrays.sort(arr);
        //for (int i = 0; i < k; i++) {
        //    res[i]=arr[i];
        //}
        //return res;

        // 方法一-2：手动实现快速排序
        quickSort(arr,0,arr.length-1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=arr[i];
        }
        return res;
    }

    public void quickSort(int[] arr,int l,int r) {
        if (l>=r) return;
        int pivot = partition(arr,l,r);
        quickSort(arr,l,pivot-1);
        quickSort(arr,pivot+1,r);
    }

    public int partition(int[] arr,int l,int r) {
        int tmp = arr[l];
        int low = l+1;
        int high = r;
        while (low<high) {
            while (low<high && arr[low]<=tmp) low++;
            while (low<high && arr[high]>=tmp) high--;
            if (low>=high) break;
            int t = arr[low];
            arr[low]=arr[high];
            arr[high]=t;
        }
        arr[l]=arr[low];
        arr[low]=tmp;
        return low;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
