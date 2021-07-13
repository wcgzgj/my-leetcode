package test;

/**
 * @ClassName GetArrayIndexTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/12/3 上午10:24
 * @Version 1.0
 **/
public class GetArrayIndexTest {
    public static void main(String[] args) {
        //如果函数返回值是数组，可以通过下面方式
        //直接使用下标进行访问
        System.out.println(arr()[0]);
    }

    public static int[] arr() {
        int[] arr = new int[2];
        arr[0]=1;
        arr[1]=2;
        return arr;
    }
}
