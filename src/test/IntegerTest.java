package test;

import domain.TreeNode;

import javax.xml.transform.Source;

/**
 * @ClassName IntegerTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/26 上午10:50
 * @Version 1.0
 **/
public class IntegerTest {
    public static void main(String[] args) {
        //TreeNode root = new TreeNode(0);
        //plus(root);
        //System.out.println(root.val);
        Integer num = new Integer(1);
        plus(num);
        System.out.println(num);
    }

    public static void plus(Integer i) {
        for (int j = 0; j < 10; j++) {
            i++;
        }
    }

    public static void plus(TreeNode root) {
        for (int i = 0; i < 10; i++) {
            root.val++;
        }
    }
}
