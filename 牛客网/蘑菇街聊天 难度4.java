    /*


牛客网  https://www.nowcoder.com/questionTerminal/8b678c5ec9a94b02b3a09ada6ac8a16f



题目描述
A和B是好友，他们经常在空闲时间聊天，A的空闲时间为[a1 ,b1 ],[a2 ,b2 ]..[ap ,bp ]。B的空闲时间是[c1 +t,d1 +t]..[cq +t,dq +t],这里t为B的起床时间。这些时间包括了边界点。B的起床时间为[l,r]的一个时刻。若一个起床时间能使两人在任一时刻聊天，那么这个时间就是合适的，问有多少个合适的起床时间？
输入描述:
第一行数据四个整数：p,q,l,r（1≤p,q≤50,0≤l≤r≤1000)。接下来p行数据每一行有一对整数ai，bi(0≤aii+1>bi,ci+1>di
输出描述:
输出答案个数
示例1
输入
2 3 0 20
15 17
23 26
1 4
7 11
15 17
输出
20


     * 
     * 就是题意方面理解的很不清楚。所以可能会觉得有点难。
     * 反正不好评价这道题目







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
        		//核心算法，保证两个区间有重合即可
        		//也就是说只要有一个时刻可以正好有空闲。就可以聊天了
        		if(b1 <= a2 && b2 >= a1){
        			return true;
        		}
    		}
    	}
    	return false;
    }
}