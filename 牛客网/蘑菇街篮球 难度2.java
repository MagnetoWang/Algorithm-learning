
/*


牛客网 蘑菇街 投篮游戏

https://www.nowcoder.com/questionTerminal/696d1c350cf1492c9b22ad232614086f


题目描述
有一个投篮游戏。球场有p个篮筐，编号为0，1...，p-1。每个篮筐下有个袋子，每个袋子最多装一个篮球。有n个篮球，每个球编号xi 。规则是将数字为xi 的篮球投到xi 除p的余数为编号的袋里。若袋里已有篮球则球弹出游戏结束输出i，否则重复至所有球都投完。输出-1。问游戏最终的输出是什么？
输入描述:
第一行两个整数p,n（2≤p,n≤300)。p为篮筐数，n为篮球数。接着n行为篮球上的数字xi(0≤xi≤1e9)
输出描述:
输出游戏的结果
示例1
输入
10 5
0
21
53
41
53
输出
4


*/


import java.util.Scanner;
  
public class Main{
    public static void main(String[] args){
       	Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	int p=in.nextInt();
        	int n=in.nextInt();
        	int[] basketball = new int[p+1];
        	boolean dup=false;
        	int[] number=new int[n];
        	for(int i=0;i<n;i++){
        		number[i]=in.nextInt();
        	}
        	for(int i=0;i<n;i++){
        		
        		int target = number[i]%p;
        		
        		if(basketball[target]==1){
        			System.out.println(i+1);
        			dup=true;
        			break;
        			
        		}else{
        			basketball[target]=1;
        		}
        	}
        	if(dup==false){
        		System.out.println(-1);
        	}
        }
        
    	in.close();
    }
}