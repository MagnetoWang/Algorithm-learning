/*

https://www.nowcoder.com/questionTerminal/3745638815d04c26babcfc463c25478c

2016 ƽ������


��Ŀ����
��֪ĳ��˾������ΪW��ƽ������ΪY��(ÿ��3��ĩ���㣬ͬʱÿ��3�³���ְ����)������ÿ����ְ��Ϊx��x>0&&x<1,ÿ�걣������Ա���������������Ƹ����Ա��ƽ������21�ꡣ 
�ӽ���3��ĩ��ʼ����ʵ��һ���㷨�����Լ������N���˾Ա����ƽ�����䡣(���������ȡ��)��
��������:
����W Y x N
�������:
�����N����ƽ������
ʾ��1
����
5 5 0.2 3
���
15



     * ���������䣬��ְ�����ˣ����ж����ˡ�
     * �е�����21�꣬���ڹ�˾�ĳ�һ��
     * 
     * 133 26 0.01 64
     * 168 26 0.40 78
     * 
     * 71
     * 23


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
    		double W=0,age=0,lizhilv=0,year=0;
    		W=in.nextDouble();
    		age=in.nextDouble();
    		lizhilv=in.nextDouble();
    		year=in.nextDouble();
    		year=year;
    		while((year--)!=0){
//    			System.out.println(year);
    			//ageҪ��1.ÿ����Ա������һ��
    			age=(age+1)*(1-lizhilv)+lizhilv*21;
    		}
    		System.out.println((int)Math.ceil(age));
    	}

    }
}