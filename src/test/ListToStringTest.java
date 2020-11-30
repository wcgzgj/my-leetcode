package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ListToStringTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/27 下午2:08
 * @Version 1.0
 **/
public class ListToStringTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(null);
        list.add(3);
        String str = list.toString();
        System.out.println(str);
        str=str.substring(1,str.length()-1);
        str=str.replaceAll(" ","");
        String[] split = str.split(",");
        List<String> list2 = new LinkedList<>();
        Collections.addAll(list2,split);
        for (String s : list2) {
            System.out.println(s);
        }

    }
}
