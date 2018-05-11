/*
https://www.nowcoder.com/questionTerminal/1f7675ae7a9e40e4bd04eb754b62fd00

ţ���� 2016У�� ����ֵ

�ο�˼· �� ����ϵ�����Leetcodeĳ����Ŀ(������)


��һ����Ϊn������A��������0��a��b<n��A[b]-A[a]�����ֵ��

��������A�����Ĵ�Сn���뷵������ֵ��

����������
[10,5],2
���أ�0

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