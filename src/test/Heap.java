package test;

import java.util.Arrays;

/**
 * @ClassName Heap
 * @Description 一个大根堆，包含元素的插入和删除
 * @Author faro_z
 * @Date 2021/9/8 1:57 下午
 * @Version 1.0
 **/
public class Heap {
    // 存放堆数据
    private int[] heap;
    // 末尾元素下标(从1开始)
    private int index;
    // 记录元素个数
    private int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.index=0;
        this.heap=new int[capacity+1];
    }

    // 大根堆添加元素
    public boolean add(int num) {
        // 堆已经满了
        if (index>=capacity) return false;
        index++;
        heap[index]=num;
        int curr = this.index;
        while (curr/2>=1 && heap[curr]>heap[curr/2]) {
            swap(curr,curr/2);
            curr/=2;
        }
        return true;
    }

    // 大根堆删除最大元素
    // 用最后一个元素替换堆头，然后进行堆调整
    public int removeMax() {
        if (index<=0) throw new RuntimeException("堆已经为空");
        // 用最后一个叶子代替被删除的大根（保证堆的完全二叉树性质）
        int max = heap[1];
        heap[1]=heap[index];
        //heap[index]=0;
        // 末尾元素位置前移
        index--;
        heapAdjust(1);
        return max;
    }

    /**
     * 堆调整
     * @param index 想要开始调整的位置
     */
    private void heapAdjust(int index) {
        // 当当前节点还有左孩子(非叶子)的时候
        while (index*2<=this.index) {
            int child = index * 2;
            // 找出左后孩子那个值更大
            if (child+1<=this.index && heap[child+1]>heap[child]) child++;
            if (heap[child]>heap[index]) {
                swap(child,index);
                // 迭代进行堆的转换
                index=child;
            } else {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return index==0;
    }

    public int size() {
        return this.index;
    }

    // 交换堆内元素位置
    private void swap(int x,int y) {
        checkInBound(x,y);
        heap[x]=heap[y]-heap[x];
        heap[y]=heap[y]-heap[x];
        heap[x]=heap[y]+heap[x];
    }

    private void checkInBound(int... indexes) {
        for (int i : indexes) {
            checkInBound(i);
        }
    }

    // 不在范围内，抛出异常
    private void checkInBound(int index) {
        if (!(index>=0 && index<=this.index)) throw new RuntimeException("不在范围");
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}
