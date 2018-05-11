/*
https://www.nowcoder.com/questionTerminal/65865c6644154bb4acca764b1480ecbb

牛客网 2016年 百度 裁剪网格纸

题目描述
度度熊有一张网格纸，但是纸上有一些点过的点，每个点都在网格点上，若把网格看成一个坐标轴平行于网格线的坐标系的话，每个点可以用一对整数x，y来表示。度度熊必须沿着网格线画一个正方形，使所有点在正方形的内部或者边界。然后把这个正方形剪下来。问剪掉正方形的最小面积是多少。
输入描述:
第一行一个数n(2≤n≤1000)表示点数，接下来每行一对整数xi,yi(－1e9<=xi,yi<=1e9)表示网格上的点
输出描述:
一行输出最小面积
示例1
输入
2
0 0
0 3
输出
9




*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class Main {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	//一开始总是在想，应该是找最大的变长，还是最小的变长。因为题目问最小的正方形。其实要想包括所有的点。
    	//就是要找最大的边长。如果理解了题意。就可以好好想思路。但是没想到一下子看到答案了。这个方法已经做过三次了
    	//自己好好想想就好



    	while(in.hasNext()){
    		int n=in.nextInt();
    		int maxX=Integer.MIN_VALUE;
    		int maxY=Integer.MIN_VALUE;
    		int minX=Integer.MAX_VALUE;
    		int minY=Integer.MAX_VALUE;
    		for(int i=0;i<n;i++){
    			int x=in.nextInt();
    			int y=in.nextInt();
    			minX=(int)Math.min(minX, x);
       			maxX=(int)Math.max(maxX, x);
    			minY=(int)Math.min(minY, y);
    			maxY=(int)Math.max(maxY, y);
    		}
    		int edge=Math.max(Math.abs((maxY-minY)),Math.abs(maxX-minX));
    		System.out.println(edge*edge);
    	}
    	in.close();
    }
}