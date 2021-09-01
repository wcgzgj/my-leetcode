package domain.random;

/**
 * @ClassName Node
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/1 11:06 上午
 * @Version 1.0
 **/
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
