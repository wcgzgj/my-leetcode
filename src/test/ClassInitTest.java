package test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ClassInitTest
 * @Description TODO
 * @Author faro_z
 * @Date 2021/8/5 11:41 上午
 * @Version 1.0
 **/
public class ClassInitTest {

    public static void main(String[] args) {

        //MyClass clazz1 = new MyClass();
        //MyClass clazz2 = new MyClass();
        //clazz1.list.add("a");
        //
        //System.out.println(clazz2.list.size());

        Deque<Integer> stack = new LinkedList<>();
        System.out.println(stack.poll());
    }

}

class MyClass {
    public List<String> list = new ArrayList<String>();


}