package test;

/**
 * @ClassName PPTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/3/17 下午5:37
 * @Version 1.0
 **/
public class PPTest {
    public static void main(String[] args) {
        int x=0;
        System.out.println("函数外x为："+x);
        test(x+1);
        System.out.println("现在x是："+x);
    }

    public static void test(int x) {
        System.out.println("函数内x为："+x);
    }
}
