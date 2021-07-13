package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SubListTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/26 上午10:38
 * @Version 1.0
 **/
public class SubListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list.subList(0,list.size()-1));
    }
}
