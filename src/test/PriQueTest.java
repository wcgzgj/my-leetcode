package test;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @ClassName PriQueTest
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/8 12:56 下午
 * @Version 1.0
 **/
public class PriQueTest {

    private static Random r = new Random();

    private static Queue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        doRandomInsert();
    }

    public static void doRandomInsert() {
        for (int i = 0; i < 20; i++) {
            int random = r.nextInt(20);
            //System.out.println("待插入的数为:"+random);
            queue.offer(random);
        }
        System.out.println("queue为:"+queue);
        for (int i = 0; i < 20; i++) {
            System.out.println("被抽取的元素为:"+queue.poll());
        }
    }
}
