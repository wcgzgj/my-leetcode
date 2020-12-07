package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName ArraySortTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/12/6 下午8:08
 * @Version 1.0
 **/
public class ArraySortTest {
    public static void main(String[] args) {
        Integer []arr={4,2,6,1,9};
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, arr);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        arr = list.toArray(new Integer[list.size()]);
        for (Integer integer : arr) {
            System.out.println(integer);
        }

    }
}
