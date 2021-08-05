package test;

import sun.java2d.pipe.SpanClipRenderer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ParseStringDemo
 * @Description TODO
 * @Author faro_z
 * @Date 2021/8/4 1:04 下午
 * @Version 1.0
 **/
public class ParseStringDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> myClazz = Class.forName("src/test/ParseStringDemo.java");
        Class<?> myClazz2 = Class.forName("src/test/ParseStringDemo.java");

        System.out.println(myClazz);


        System.out.println(myClazz==myClazz2);
    }
}
