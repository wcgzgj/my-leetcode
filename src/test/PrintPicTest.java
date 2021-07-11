package test;

/**
 * @ClassName PrintPicTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/7/10 下午6:22
 * @Version 1.0
 **/
public class PrintPicTest {
    public static void main(String[] args) {
        // 4 行
        /**      *的个数 空格数   行数
         *           1    3     0
         *           3    2     1
         *           5    1     2
         *           7    0     3
         *
         *           5    1      4
         *           3    2      5
         *           1    3      6
         */
        print(20);

    }

    /**
     * 打印菱形
     * @param row 上半部分的行数
     */
    public static void print(int row) {
        // 打印上半部分
        for (int i = 0; i < row; i++) {
            // 打印空格
            for (int j = 0; j < row - i - 1; j++) {
                System.out.print(" ");
            }
            // 打印菱形
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            // 别忘了换行
            System.out.println();
        }

        // 打印下半部分
        for (int i = row-2; i >=0 ; i--) {
            // 打印空格
            for (int j = 0; j < row - i - 1; j++) {
                System.out.print(" ");
            }
            // 打印菱形
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            // 别忘了换行
            System.out.println();
        }
    }
}
