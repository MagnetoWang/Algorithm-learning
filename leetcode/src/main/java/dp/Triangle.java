package dp;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode题号：120
 * 思路：这是个三角形中求最短路径。
 * 两种方法
 * 1，从上到下遍历
 * 2，从下到上遍历
 * 显然，从上到下不行，因为无法准确搜索到下面更短的路径
 * 从下到上，行！
 * 每次都是选取当前下方最短的路径，然后加上自己本身大小。
 */
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle=new LinkedList<List<Integer>>();
        List<Integer> list=new LinkedList<Integer>();
        list.add(2);
        triangle.add(list);
        list=new LinkedList<Integer>();
        list.add(3);
        list.add(4);
        triangle.add(list);
        list=new LinkedList<Integer>();
        list.add(6);
        list.add(5);
        list.add(7);
        triangle.add(list);
        list=new LinkedList<Integer>();
        list.add(4);
        list.add(1);
        list.add(8);
        list.add(3);
        triangle.add(list);

        System.out.println(minimumTotal(triangle));


    }
    public static int minimumTotal(List<List<Integer>> triangle) {

        for(int i=1;i<triangle.size();i++){
            int row=triangle.size()-i-1;
            for(int j=0;j<triangle.get(row).size();j++){
                int answer =triangle.get(row).get(j)+Math.min(triangle.get(row+1).get(j+1),triangle.get(row+1).get(j));
                triangle.get(row).set(j,answer);

            }
        }
        return triangle.get(0).get(0);
    }

}
