package test;

/**
 * @ClassName ContinueTes
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/20 下午1:04
 * @Version 1.0
 **/
public class ContinueTes {
    public static void main(String[] args) {
        // for (int i = 0; i < 10; i++) {
        //     if (i<11) {
        //         if (i==5) continue;
        //         System.out.println(i);
        //     }
        // }

        int num=10;
        while (num>=0) {
            num--;
            if (num==5) continue;
            System.out.println(num);
        }
    }
}
