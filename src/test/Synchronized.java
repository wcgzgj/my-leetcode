package test;

/**
 * @ClassName Synchronized
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/17 9:23 下午
 * @Version 1.0
 **/
public class Synchronized {
    public void method1() {
        Object lock = new Object();
        int count = 0;
        synchronized (lock) {
            count++;
        }
        method2();
    }

    public static void method2() {

    }
}
