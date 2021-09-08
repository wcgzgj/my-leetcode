package test;

/**
 * @ClassName HeapSort
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/8 5:53 下午
 * @Version 1.0
 **/
public class HeapSort {
    public static void main(String[] args) {

    }

    public static void heapSort(int[] arr,int n) {

    }

    public static void buildHead(int[] arr,int n) {
        // 从最后一个非叶子节点开始，进行堆化
        for (int i = n/2; i >=1; i--) {
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

    }
}
