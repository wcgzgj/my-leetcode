package test;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

/**
 * @ClassName SubStringTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/25 上午10:50
 * @Version 1.0
 **/
public class SubStringTest {
    @Test
    public void subStringTest() {
        String str = "abcde";
        System.out.println(str.substring(0,2));
    }
}
