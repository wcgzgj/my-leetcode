package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName DichotomyDemo
 * @Description TODO
 * @Author faro_z
 * @Date 2021/7/17 1:14 下午
 * @Version 1.0
 **/
public class DichotomyDemo {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int[] arr= {3,52,1,6,4,2,3,7};
        // 为数组进行排序
        Arrays.sort(arr);
        System.out.println("排序后的数组为:"+Arrays.toString(arr));
        System.out.println("请输入想要找寻的数字:");
        int target = sc.nextInt();
        int index = findIndex(target, arr);
        System.out.println(target+"的位置是:"+index);
    }

    /**
     * 二分查找
     * @param target
     * @param arr
     * @return -1:没有找到   others:找到的数组下标
     */
    public static int findIndex(int target,int[]arr) throws Exception {
        if (!isSorted(arr)) throw new Exception("错误，数组没有排序");
        int l=0,r=arr.length-1;
        while (l<=r) {
            int mid = (l + r) / 2;
            if (arr[mid]==target) return mid;
            else if (arr[mid]<target) l++;
            else r--;
        }
        return -1;
    }

    /**
     * 判断数组是不是排好序的
     * @param arr
     * @return
     */
    public static boolean isSorted(int []arr) {
        if (arr==null || arr.length==0) return true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i]>arr[i+1]) return false;
        }
        return true;
    }
}
