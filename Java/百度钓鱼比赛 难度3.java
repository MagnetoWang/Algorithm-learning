/*


��Ŀ����
ss��cc��������㣬�����ɻ���Ϊn��m�ĸ��ӣ�ÿ�������в�ͬ�ĸ��ʵ����㣬ccһֱ������(x,y)�ĸ��ӵ��㣬��ssÿ���������һ�����ӡ���t���Ӻ�����˭���ٵ���һ����ĸ��ʴ�Ϊ���٣�
��������:
��һ���������n,m,x,y,t(1��n,m,t��1000,1��x��n,1��y��m);
������Ϊһ��n��m�ľ���ÿ��m��һλС������n�У���i�е�j������������Ϊ(i,j)�ĸ��ӵ�����ĸ���Ϊp(0��p��1)
�������:
������С���һ��Ϊ���ʴ���˵�����(cc/ss/equal),�ڶ���Ϊ�������(����2λС��)
ʾ��1
����
2 2 1 1 1
0.2 0.1
0.1 0.4
���
equal
0.20



    		//��΢�������ӣ�ss,Ҫ����������ӵ�ƽ��������ĸ��ʡ�
    		//Ȼ���ö����¼��������ĸ��ʡ����Ƿ�������ֵ��ʱ��Ҫע����


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