/*
https://www.nowcoder.com/questionTerminal/65865c6644154bb4acca764b1480ecbb

ţ���� 2016�� �ٶ� �ü�����ֽ

��Ŀ����
�ȶ�����һ������ֽ������ֽ����һЩ����ĵ㣬ÿ���㶼��������ϣ��������񿴳�һ��������ƽ���������ߵ�����ϵ�Ļ���ÿ���������һ������x��y����ʾ���ȶ��ܱ������������߻�һ�������Σ�ʹ���е��������ε��ڲ����߽߱硣Ȼ�����������μ��������ʼ��������ε���С����Ƕ��١�
��������:
��һ��һ����n(2��n��1000)��ʾ������������ÿ��һ������xi,yi(��1e9<=xi,yi<=1e9)��ʾ�����ϵĵ�
�������:
һ�������С���
ʾ��1
����
2
0 0
0 3
���
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
    	//һ��ʼ�������룬Ӧ���������ı䳤��������С�ı䳤����Ϊ��Ŀ����С�������Ρ���ʵҪ��������еĵ㡣
    	//����Ҫ�����ı߳��������������⡣�Ϳ��Ժú���˼·������û�뵽һ���ӿ������ˡ���������Ѿ�����������
    	//�Լ��ú�����ͺ�



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