    /*


ţ����  https://www.nowcoder.com/questionTerminal/8b678c5ec9a94b02b3a09ada6ac8a16f



��Ŀ����
A��B�Ǻ��ѣ����Ǿ����ڿ���ʱ�����죬A�Ŀ���ʱ��Ϊ[a1 ,b1 ],[a2 ,b2 ]..[ap ,bp ]��B�Ŀ���ʱ����[c1 +t,d1 +t]..[cq +t,dq +t],����tΪB����ʱ�䡣��Щʱ������˱߽�㡣B����ʱ��Ϊ[l,r]��һ��ʱ�̡���һ����ʱ����ʹ��������һʱ�����죬��ô���ʱ����Ǻ��ʵģ����ж��ٸ����ʵ���ʱ�䣿
��������:
��һ�������ĸ�������p,q,l,r��1��p,q��50,0��l��r��1000)��������p������ÿһ����һ������ai��bi(0��aii+1>bi,ci+1>di
�������:
����𰸸���
ʾ��1
����
2 3 0 20
15 17
23 26
1 4
7 11
15 17
���
20


     * 
     * �������ⷽ�����ĺܲ���������Կ��ܻ�����е��ѡ�
     * �����������������Ŀ







     * 
     */


import java.util.Scanner;
  
public class Main{
    public static void main(String[] args){
    	Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	int p=in.nextInt();
        	int q=in.nextInt();
        	int Left=in.nextInt();
        	int Right=in.nextInt();
        	int a[][]=new int[p][2];
        	int b[][]=new int[q][2];
        	for(int i=0;i<p;i++){
        		a[i][0]=in.nextInt();
        		a[i][1]=in.nextInt();
        	}
        	for(int i=0;i<q;i++){
        		b[i][0]=in.nextInt();
        		b[i][1]=in.nextInt();
        	}
        	int ans=MOGUJIE_Count(a,b,Left,Right);
                    	System.out.println(ans);
            
        }
        
    	in.close();
    }
        public static int MOGUJIE_Count(int a[][],int b[][],int Left,int Right){
    	int count=0;
    	for(int i=Left;i<=Right;i++){
    		if(MOGU_Proper(a,b,i)==true){
    			count++;
    		}
    	}
    	
    	
    	
    	return count;
    }
    public static boolean MOGU_Proper(int a[][],int b[][],int t){
    	for(int i=0;i<a.length;i++){
    		int a1=a[i][0];
    		int a2=a[i][1];
    		for(int j=0;j<b.length;j++){
        		int b1=b[j][0]+t;
        		int b2=b[j][1]+t;
        		//�����㷨����֤�����������غϼ���
        		//Ҳ����˵ֻҪ��һ��ʱ�̿��������п��С��Ϳ���������
        		if(b1 <= a2 && b2 >= a1){
        			return true;
        		}
    		}
    	}
    	return false;
    }
}