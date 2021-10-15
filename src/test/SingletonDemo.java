package test;

/**
 * @ClassName SingletonDemo
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/18 9:01 下午
 * @Version 1.0
 **/
public class SingletonDemo {

    private volatile static SingletonDemo instance = null;

    private SingletonDemo() {}

    public static SingletonDemo getInstance() {
        if (instance==null) {
            synchronized (SingletonDemo.class) {
                if (instance==null) {
                    instance=new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
