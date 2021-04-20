package test;

import java.util.*;

/**
 * @ClassName ArraySortTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/12/6 下午8:08
 * @Version 1.0
 **/
public class ArraySortTest {
    public static void main(String[] args) {
        int []arr={4,2,6,1,9};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        // List<Integer> list = new ArrayList<>();
        // Collections.addAll(list, arr);
        // list.sort(new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer o1, Integer o2) {
        //         return o1-o2;
        //     }
        // });
        //
        // arr = list.toArray(new Integer[list.size()]);
        // for (Integer integer : arr) {
        //     System.out.println(integer);
        // }

    }
}
