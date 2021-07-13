package test;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/7/11 下午7:00
 * @Version 1.0
 **/
public class ThreadTest {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        System.out.println("顾客说要买包子");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("顾客吃包子！");
                    }


                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        System.out.println("jaja ");
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("老板说：包子做好了");
                        lock.notifyAll();
                    }
                }
            }
        }.start();
    }
}
