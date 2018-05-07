//https://www.nowcoder.com/practice/3897c2bcc87943ed98d8e0b9e18c4666?tpId=49&tqId=29275&tPage=1&rp=1&ru=/ta/2016test&qru=/ta/2016test/question-ranking
//https://www.nowcoder.com/questionTerminal/3897c2bcc87943ed98d8e0b9e18c4666
//ţ������2016�껪ΪУ����Ŀ �� ��߷��Ƕ���


/*
��Ŀ����
��ʦ��֪����ĳĳͬѧ���У�������ߵ��Ƕ��٣�����������ģ����ʦ��ѯ�ʡ���Ȼ����ʦ��ʱ����Ҫ����ĳλͬѧ�ĳɼ�.
��������:
�����������������ݡ�
ÿ�������һ��������������N��M��0 < N <= 30000,0 < M < 5000��,�ֱ����ѧ������Ŀ�Ͳ�������Ŀ��
ѧ��ID��Ŵ�1�ൽN��
�ڶ��а���N��������������N��ѧ���ĳ�ʼ�ɼ������е�i��������IDΪi��ѧ���ĳɼ�
��������M�У�ÿһ����һ���ַ�C��ֻȡ��Q����U������������������A,B,��CΪ'Q'��ʱ��, ��ʾ����һ��ѯ�ʲ�������ѯ��ID��A��B������A,B����ѧ�����У��ɼ���ߵ��Ƕ���
��CΪ��U����ʱ�򣬱�ʾ����һ�����²�����Ҫ���IDΪA��ѧ���ĳɼ�����ΪB��
�������:
����ÿһ��ѯ�ʲ�������һ�����������߳ɼ�.
����
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5
���
5
6
5
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
        Main test=new Main();
        test.HuaWeiHighScore();

    }
        public int[] MaxBuild;
    public void HuaWeiHighScore(){
    	Scanner in = new Scanner(System.in);
    	while(in.hasNext()){
    		int n=in.nextInt();
    		int m=in.nextInt();
    		int[] score=new int[n+5];
     		for(int i=1;i<=n;i++){
     			score[i]=in.nextInt();
     		}
     		MaxBuild=new int[n*4+5];
     		HuaWeiBuild(1,1,n,score);
     		in.nextLine();
//     		for(Integer e: MaxBuild){
//     			System.out.print(e+" ");
//     		}
//     		System.out.println();
     		for(int i=0;i<m;i++){
     			String oneline=in.nextLine();
     			String[] Question=oneline.split(" ");
     			int a= Integer.parseInt(Question[1]) ;
     			int b= Integer.parseInt(Question[2]);
     			if(Question[0].equals("Q")){
     				if(a>b){
     					int temp=a;
     					a=b;
     					b=temp;
     				}
     				System.out.println(QueryMaxHuaWei(a,b,1,1,n));
     			}else{
     				updateHuaWei(a,b,1,1,n);
     			}
     		}
    	}
    	
    	in.close();
    	
    }
    /*
     * L,R��ѯ�����ֵ��p����㣬l,rĿ����������Ҷ˵�
     * 
     */
    public int QueryMaxHuaWei(int L , int R , int p , int l , int r ){
        if ( L <= l && r <= R ) {
            return MaxBuild[p];
        }
        int m=(l+r)>>1;
        int lans=-1,rans=-1;
        if(L<=m){
        	lans=QueryMaxHuaWei(L , R , p << 1 , l , m);
        }
        if(m<R){
        	rans=QueryMaxHuaWei(L , R , p << 1| 1 , m+1 , r);
        }
        if(lans==-1){
        	return rans;
        }
        if(rans==-1){
        	return lans;
        }
        return Math.max(lans, rans);
    }
    public void updateHuaWei(int id	, int value , int p , int l , int r ){
    	if(l==r&&id==l){
    		MaxBuild[p]=value;
    		return;
    	}
    	int m=(l+r)>>1;
        if(id<=m){
        	updateHuaWei(id, value, p<< 1, l, m);
        }
        if(id>m){
        	updateHuaWei(id, value, p << 1| 1, m+1, r);
        }
        MaxBuild[p]=Math.max(MaxBuild[p<<1], MaxBuild[p<<1|1]);



    	
    }
    public void HuaWeiBuild(int p,int L,int R,int [] score){
    	if(L==R){
    		MaxBuild[p]=score[L];
    		return;
    	}
    	int m = (L+R)>>1;
        //����1Ϊ�����Һ�1�������㣬�൱�ڼ�1
     	int Lchild=p<<1,Rchild=p<<1|1;
//     	System.out.println("m = "+m);
//     	System.out.println("p = "+p+" Lchild = "+Lchild+" Rchild = "+Rchild);
//     	System.out.println("Lchild = "+Lchild+" L = "+L+" m = "+m);
//     	System.out.println("Rchild = "+Rchild+" R = "+R+" m+1 = "+(m+1));
     	HuaWeiBuild(Lchild, L, m, score);
     	HuaWeiBuild(Rchild, m+1, R, score);
     	
     	MaxBuild[p]=Math.max(MaxBuild[Lchild], MaxBuild[Rchild]);
     	
     	
     	
    }
}