package test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName SetTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/3/9 上午11:59
 * @Version 1.0
 **/
public class SetTest {
    @Test
    public void hashSetTest() {
        int[] a1 = {123};
        int[] a2 = {123};
        String str = Arrays.toString(a2);


        Set<int[]> set = new HashSet<>();
        set.add(a1);
        set.add(a2);
        System.out.println(set);
    }
}
