/*

ţ���� 2016 ���� ֱ��ͼ��������


��Ŀ����
��һ��ֱ��ͼ����һ�����������ʾ������ÿ�еĿ��Ϊ1��������ֱ��ͼ��������������������磬����ֱ��ͼ[2,7,9,4],���������������ε����Ϊ14(��[7,9]������7x2�ľ���)��

����һ��ֱ��ͼA�������ܿ��n���뷵���������������ֱ֤��ͼ���С�ڵ���500����֤�����int��Χ�ڡ�

����������
[2,7,9,4,1],5
���أ�14








*/

import java.util.*;

public class MaxInnerRec {
    public int countArea(int[] A, int n) {
                int minHeight=Integer.MAX_VALUE;
        int Area=0;
       for(int i=0;i<A.length;i++){
        	minHeight=Integer.MAX_VALUE;
        	for(int j=i;j>=0;j--){
        		minHeight=Math.min(minHeight, A[j]);
        		Area=Math.max(Area, (i-j+1)*minHeight);
        		
        				
        	}
        }
        return Area;
    }
}