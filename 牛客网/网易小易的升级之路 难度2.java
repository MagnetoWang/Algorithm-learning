
/*



https://www.nowcoder.com/questionTerminal/fe6c73cb899c4fe1bdd773f8d3b42c3d







��Ŀ����
С�׾���������������Ϸ.��һ��,������һ�������������Ϸ,���Ľ�ɫ�ĳ�ʼ����ֵΪ a.�ڽ�������һ��ʱ����,��������������n������,ÿ������ķ�����Ϊb1,b2,b3...bn. ��������Ĺ��������biС�ڵ���С�׵ĵ�ǰ����ֵc,��ô���������ɴ�ܹ���,�� ��ʹ���Լ�������ֵ����bi;���bi����c,����Ҳ�ܴ�ܹ���,����������ֵֻ������bi ��c�����Լ��.��ô��������,��һϵ�еĶ�����,С�׵���������ֵΪ����?
��������:
����ÿ������,��һ������������n(1��n<100000)��ʾ�����������a��ʾС�׵ĳ�ʼ����ֵ.
�ڶ���n������,b1,b2...bn(1��bi��n)��ʾÿ������ķ�����
�������:
����ÿ������,���һ��.ÿ�н�����һ������,��ʾС�׵���������ֵ
ʾ��1
����
3 50
50 105 200
5 20
30 20 15 40 100
���
110
205


*/


import java.util.*;
  
public class Main{
    public static void main(String[] args){
    	Scanner in = new Scanner(System.in);
    	while(in.hasNext()){
    		int n=in.nextInt();
    		int attack=in.nextInt();
    		for(int i=0;i<n;i++){
    			int blood =in.nextInt();
    			if(blood<=attack){
    				attack+=blood;
    			}else{
    				attack+=WangYi_gcd(attack,blood);
    			}
    		}
    		System.out.println(attack);
    	}
    	in.close();
    }
        public static int WangYi_gcd(int a,int b){
    	int temp;
    	while(b!=0){
    		temp=b;
    		b=a%b;
    		a=temp;
    	}
    	return a;
    }
}