package test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName ArrayInitTest
 * @Description 数组初始化测试
 * @Author FARO_Z
 * @Date 2020/12/7 下午4:56
 * @Version 1.0
 **/
public class ArrayInitTest {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {2,3},
                {1,4},
                {4,1},
                {5,8},
                {6,2}};
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]>o2[1]) {
                    return 1;
                }
                return -1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
