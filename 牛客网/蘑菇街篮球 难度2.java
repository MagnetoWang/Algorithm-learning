
/*


ţ���� Ģ���� Ͷ����Ϸ

https://www.nowcoder.com/questionTerminal/696d1c350cf1492c9b22ad232614086f


��Ŀ����
��һ��Ͷ����Ϸ������p�����𣬱��Ϊ0��1...��p-1��ÿ���������и����ӣ�ÿ���������װһ��������n������ÿ������xi �������ǽ�����Ϊxi ������Ͷ��xi ��p������Ϊ��ŵĴ�������������������򵯳���Ϸ�������i�������ظ���������Ͷ�ꡣ���-1������Ϸ���յ������ʲô��
��������:
��һ����������p,n��2��p,n��300)��pΪ��������nΪ������������n��Ϊ�����ϵ�����xi(0��xi��1e9)
�������:
�����Ϸ�Ľ��
ʾ��1
����
10 5
0
21
53
41
53
���
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