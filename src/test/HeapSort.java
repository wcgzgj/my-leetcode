package test;

import java.util.Arrays;

/**
 * @ClassName HeapSort
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/8 5:53 下午
 * @Version 1.0
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {3,5,2,5,6,2,1};
        heapSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr,int n) {
        if (n<=1) return;
        buildHeap(arr,n);
        int k = n-1;
        while (k>0) {
            swap(arr,0,k);
            k--;
            heapify(arr,0,k+1);
        }
    }

    public static void buildHeap(int[] arr,int n) {
        // 从最后一个非叶子节点开始，进行堆化
        for (int i = n/2-1; i >=0; i--) {
            heapify(arr,i,n);
        }
    }

    /**
     * 对指定的堆，从指定位置开始堆化
     * @param arr 堆
     * @param i 指定开始的位置
     * @param n 指定的大小
     */
    public static void heapify(int[] arr,int i,int n) {
        while (i*2+1<n) {
            int child = i * 2+1;
            if (child+1<n && arr[child+1]>arr[child]) child++;
            if (arr[child]>arr[i]) swap(arr,child,i);
            else return; // 不需要交换，说明下面的所有节点也没必要交换了
            i=child;
        }
    }

    public static void swap(int[] arr,int x,int y) {
        if (x<0 || x>=arr.length || y<0 || y>=arr.length) return;
        arr[x]=arr[y]-arr[x];
        arr[y]=arr[y]-arr[x];
        arr[x]=arr[y]+arr[x];
    }
}
