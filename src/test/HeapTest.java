package test;

import java.util.Random;

/**
 * @ClassName HeapTest
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/8 2:12 下午
 * @Version 1.0
 **/
public class HeapTest {

    private static Random r = new Random();

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        for (int i = 0; i < 10; i++) {
            int random = r.nextInt(20);
            System.out.println(random);
            heap.add(random);
            System.out.println(heap);
        }

        System.out.println("--------");

        while (!heap.isEmpty()) {
            System.out.println(heap.removeMax());
        }
    }
}
