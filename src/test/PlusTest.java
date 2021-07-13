package test;

/**
 * @ClassName PlusTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/25 下午4:43
 * @Version 1.0
 **/
public class PlusTest {
    public static int index1=0;
    public static int index2=0;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(p1());
        }

        System.out.println("\n\n\n");
        for (int i = 0; i < 20; i++) {
            System.out.println(p2());
        }
    }
    public static int p1() {
        return index1++;
    }
    public static int p2() {
        return index2+1;
    }
}
