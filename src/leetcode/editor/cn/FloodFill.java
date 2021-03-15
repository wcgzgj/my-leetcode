 //有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。 
//
// 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。 
//
// 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方
//向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。 
//
// 最后返回经过上色渲染后的图像。 
//
// 示例 1: 
//
// 
//输入: 
//image = [[1,1,1],[1,1,0],[1,0,1]]
//sr = 1, sc = 1, newColor = 2
//输出: [[2,2,2],[2,2,0],[2,0,1]]
//解析: 
//在图像的正中间，(坐标(sr,sc)=(1,1)),
//在路径上所有符合条件的像素点的颜色都被更改成2。
//注意，右下角的像素没有更改为2，
//因为它不是在上下左右四个方向上与初始点相连的像素点。
// 
//
// 注意: 
//
// 
// image 和 image[0] 的长度在范围 [1, 50] 内。 
// 给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。 
// image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。 
// 
// Related Topics 深度优先搜索 
// 👍 167 👎 0

  
  package leetcode.editor.cn;

 import java.util.Arrays;
 import java.util.LinkedList;
 import java.util.Queue;

 public class FloodFill{
      public static void main(String[] args) {
           Solution solution = new FloodFill().new Solution();
          int[][] image = {{1, 1, 1},
                  {1, 1, 0},
                  {1, 0, 1}};
          int[][] newImage = solution.floodFill(image, 1, 1, 2);
          System.out.println(Arrays.toString(newImage));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

          int[] dx={1,0,0,-1};
          int[] dy={0,1,-1,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc]==newColor) {
            return image;
        }
        int xlen = image.length;
        int ylen = image[0].length;
        //queue存储位置
        Queue<int[]> queue = new LinkedList<>();
        int currentColor = image[sr][sc];
        image[sr][sc]=newColor;
        queue.offer(new int[]{sr,sc});
        while (!queue.isEmpty()) {
            int[] dir = queue.poll();
            for (int i = 0; i < 4; i++) {
                //获取遍历的范围
                int mx = dir[0] + dx[i];
                int my = dir[1] + dy[i];
                //范围
                if (mx>=0 && mx<xlen && my>=0 && my<ylen && image[mx][my]==currentColor) {
                    image[mx][my]=newColor;
                    queue.offer(new int[]{mx,my});
                }
            }
        }
        return image;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
