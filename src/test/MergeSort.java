package test;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName MergeSort
 * @Description TODO
 * @Author faro_z
 * @Date 2021/8/10 11:24 上午
 * @Version 1.0
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = getRandomArr(10);
        System.out.println("排序前:"+ Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("排序后:"+ Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        if (arr==null || arr.length==0) return;
        mergeSortRecursion(arr,0,arr.length-1);
    }

    public static void mergeSortRecursion(int[] arr,int l,int r) {
        if (l>=r) return;
        int mid = (l + r) / 2;
        mergeSortRecursion(arr,l,mid);
        mergeSortRecursion(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    // 归并操作
    public static void merge(int[] arr,int ls,int le,int re) {
        int start = ls;
        int end = re;
        int rs = le + 1;
        int n = re - ls + 1;
        int[] tmp = new int[n];
        int index=0;
        while (ls<=le && rs<=re) {
            if (arr[ls]<=arr[rs]) {
                tmp[index]=arr[ls];
                ++ls;
            } else {
                tmp[index]=arr[rs];
                ++rs;
            }
            ++index;
        }
        while (ls<=le) {
            tmp[index]=arr[ls];
            ++ls;
            ++index;
        }
        while (rs<=re) {
            tmp[index]=arr[rs];
            ++rs;
            ++index;
        }
        index=0;
        for (int i = start; i <= end; i++) {
            arr[i]=tmp[index];
            ++index;
        }
    }


    public static int[] getRandomArr(int n) {
        Random r = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=r.nextInt(n);
        }
        return arr;
    }
}
