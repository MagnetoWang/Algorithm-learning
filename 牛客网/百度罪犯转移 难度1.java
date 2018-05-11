/*





题目描述
C市现在要转移一批罪犯到D市，C市有n名罪犯，按照入狱时间有顺序，另外每个罪犯有一个罪行值，值越大罪越重。现在为了方便管理，市长决定转移入狱时间连续的c名犯人，同时要求转移犯人的罪行值之和不超过t，问有多少种选择的方式？ 
输入描述:
第一行数据三个整数:n，t，c(1≤n≤2e5,0≤t≤1e9,1≤c≤n)，第二行按入狱时间给出每个犯人的罪行值ai(0≤ai≤1e9)
输出描述:
一行输出答案。
示例1
输入
3 100 2
1 2 3
输出
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
