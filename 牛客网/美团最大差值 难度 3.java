/*
https://www.nowcoder.com/questionTerminal/1f7675ae7a9e40e4bd04eb754b62fd00

牛客网 2016校招 最大差值

参考思路 ： 风口上的猪还有Leetcode某道题目(忘记了)


有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。

给定数组A及它的大小n，请返回最大差值。

测试样例：
[10,5],2
返回：0

*/

import java.util.*;

public class LongestDistance {
    public int getDis(int[] A, int n) {
    	int max=Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	for(int i=0;i<A.length;i++){
    		
    		max=Math.max(max,  A[i]-min);
    		min=Math.min(min, A[i]);
    		
    	}
    	
    	
    	if(max<0){
    		return 0;
    	}
    	return max;
    }
}
/*
input
[5386,5384,11054,6345,5816,11757],6
[10,5],2
output
6373
0
*/