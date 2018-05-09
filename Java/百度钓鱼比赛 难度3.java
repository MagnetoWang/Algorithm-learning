/*


题目描述
ss请cc来家里钓鱼，鱼塘可划分为n＊m的格子，每个格子有不同的概率钓上鱼，cc一直在坐标(x,y)的格子钓鱼，而ss每分钟随机钓一个格子。问t分钟后他们谁至少钓到一条鱼的概率大？为多少？
输入描述:
第一行五个整数n,m,x,y,t(1≤n,m,t≤1000,1≤x≤n,1≤y≤m);
接下来为一个n＊m的矩阵，每行m个一位小数，共n行，第i行第j个数代表坐标为(i,j)的格子钓到鱼的概率为p(0≤p≤1)
输出描述:
输出两行。第一行为概率大的人的名字(cc/ss/equal),第二行为这个概率(保留2位小数)
示例1
输入
2 2 1 1 1
0.2 0.1
0.1 0.4
输出
equal
0.20



    		//稍微动下脑子，ss,要算出整个格子的平均掉到鱼的概率。
    		//然后用对立事件计算钓鱼的概率。就是分类和输出值的时候要注意下


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
    		int n=in.nextInt();
    		int m=in.nextInt();
    		int x=in.nextInt();
    		int y=in.nextInt();
    		int t=in.nextInt();
    		double map[][] =new double[n][m];
    		double sum=0;
    		for(int i=0;i<n;i++){
    			for(int j=0;j<m;j++){
    				map[i][j]=Double.parseDouble(in.next());
    				sum+=map[i][j];
    			}
    		}
    		sum=sum/(n*m);
    		double ss=1-sum;
    		double cc=1-map[x-1][y-1];
    		double cc_sum=1-Math.pow(cc, t);
    		double ss_sum=1-Math.pow(ss, t);
    		if(cc_sum<ss_sum){
    			System.out.println("ss");
    			System.out.println(String.format("%.2f", ss_sum));
    		}else{
    			if(cc_sum>ss_sum){
    				System.out.println("cc");
    				System.out.println(String.format("%.2f", cc_sum));
    			}else{
    				System.out.println("equal");
    				System.out.println(String.format("%.2f", ss_sum));
    			}
    		}
    		
    	}
    	
    	in.close();
    }
}