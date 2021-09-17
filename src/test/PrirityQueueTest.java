package test;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @ClassName PrirityQueueTest
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/10 9:17 下午
 * @Version 1.0
 **/
public class PrirityQueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            queue.offer(r.nextInt(100));
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
