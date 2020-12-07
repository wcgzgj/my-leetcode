package test;

/**
 * @ClassName FibTest
 * @Description 通过dp，提高dp的效率
 * @Author FARO_Z
 * @Date 2020/12/7 上午12:37
 * @Version 1.0
 **/
public class FibTest {
    public static void main(String[] args) {
        //这种方法，使得fib的时间服复杂度为 O(n)
        //比之前O(2^n) 要小的多的多
        System.out.println(fib(30));
    }

    public static int fib(int n) {
        if (n<0) return -1;
        int[] memo = new int[n+1];
        return help(memo,n);
    }


    public static int help(int[]memo,int n) {
        if (n==1 || n==0) return 1;
        if (memo[n]!=0) return memo[n];
        memo[n]=help(memo,n-1)+help(memo,n-2);
        return memo[n];
    }
}

