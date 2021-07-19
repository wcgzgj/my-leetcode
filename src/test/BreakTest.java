package test;

/**
 * @ClassName BreakTest
 * @Description TODO
 * @Author faro_z
 * @Date 2021/7/15 11:17 上午
 * @Version 1.0
 **/
public class BreakTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("j:"+j);
                if (j==5) break;
            }
            System.out.println("i-----:"+i);
        }
    }
}
