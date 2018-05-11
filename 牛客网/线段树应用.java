//https://www.nowcoder.com/practice/3897c2bcc87943ed98d8e0b9e18c4666?tpId=49&tqId=29275&tPage=1&rp=1&ru=/ta/2016test&qru=/ta/2016test/question-ranking
//https://www.nowcoder.com/questionTerminal/3897c2bcc87943ed98d8e0b9e18c4666
//牛客网，2016年华为校招题目 ： 最高分是多少


/*
题目描述
老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.
输入描述:
输入包括多组测试数据。
每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
学生ID编号从1编到N。
第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
输出描述:
对于每一次询问操作，在一行里面输出最高成绩.
输入
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5
输出
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
     * L,R查询区间的值。p是起点，l,r目标区间的左右端点
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
        //左移1为，并且和1做或运算，相当于加1
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