/*





��Ŀ����
C������Ҫת��һ���ﷸ��D�У�C����n���ﷸ����������ʱ����˳������ÿ���ﷸ��һ������ֵ��ֵԽ����Խ�ء�����Ϊ�˷�������г�����ת������ʱ��������c�����ˣ�ͬʱҪ��ת�Ʒ��˵�����ֵ֮�Ͳ�����t�����ж�����ѡ��ķ�ʽ�� 
��������:
��һ��������������:n��t��c(1��n��2e5,0��t��1e9,1��c��n)���ڶ��а�����ʱ�����ÿ�����˵�����ֵai(0��ai��1e9)
�������:
һ������𰸡�
ʾ��1
����
3 100 2
1 2 3
���
2






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
    	while(in.hasNext()){
    		long n=in.nextLong();
    		long t=in.nextLong();
    		long c=in.nextLong();
    		long a[] =new long[(int) n];
    		for(int i=0;i<n;i++){
    			a[i]=in.nextLong();
    		}
    		int method=0;
    		long sum=0;
			for(long j=0;j<c;j++){
				sum+=a[(int) j];
			}
			if(sum<=t){
				method++;
			}
    		for(long i=c;i<n;i++){

    			sum-=a[(int) (i-c)];
    			sum+=a[(int) i];
    			if(sum<=t){
    				method++;
    			}
    		}
    		System.out.println(method);
    	}
        
    }
}
