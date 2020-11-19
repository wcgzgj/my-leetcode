package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ArrayListIndexTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/19 上午9:46
 * @Version 1.0
 **/
public class ArrayListIndexTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.get(1));
    }
}
