
    /*
     * 



ţ���� 2016 �ַ�������


���ֵ�����s1��s2֮��ģ�������len1��len2���ַ����ĸ��������mod 1000007��

��������:
ÿ�����ݰ���s1������С��100����s2������С��100����len1��С��100000����len2������len1��С��100000��
�������:
����𰸡�
ʾ��1
����
ab ce 1 2
���
56









����Ҫ������ֵ������˼�����������ַ������±�Ϊ0��ʼ���жԱȣ��ֵ����Ǵ������ҽ��жԱȵġ� 
����ab��abc��������֮����ַ�������Ϊaba��abb����ab��bb����֮����ַ�������Ϊ��ac��ad��ae��az��ba��26�������Ը�λ���ַ�������Ҫ��26��i���ݡ� 
��Σ�Ҫ�����Ŀ�ġ�������len1��len2���ַ����ĸ�������ָ���ǳ�����len1���ַ���������������len1+1���ַ�����������������Ϊlen2���ַ��������� 
��abcde��acede�������ַ���������Ϊ1��4��ʾ���ǳ���Ϊ1��ʱ�������ַ�a��a֮��ĸ���������Ϊ2��ʱ�������ַ�ab��ac֮��ĸ���������Ϊ3��ʱ��abc��ace�����ַ���֮��ĸ���������Ϊ4��abcd��aced�ĸ����� 
���Լ����ʱ��Ӧ���Գ�����Ϊ��������len1��len2֮����ַ��������������ӡ�
     * 
     * 
     * 
     * cpqejrrgp cpqejtrdg 9 9
     * 35064
     * 
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
    		char [] s1=in.next().toCharArray();
        	char [] s2=in.next().toCharArray();
        	int begin=in.nextInt();
        	int end=in.nextInt();
        	long sum=0;
        	//�ֵ�������������ַ������ǲ�0�������һ����ĸ��˳����a,b������ĸ�ǲ�1����26��0�η�
        	//�������������2�Ļ�,��ax,bx��x����ĳ����ĸ������26��1�η�
        	//������3�Ļ�����axx,bxx������26��2�η�
        	//��������һ�����㡣
        	//�������ǵ����ַ������ַ�˳��
        	//��b,bb,bbb,bbbb
        	//b��a������26��0�η�
        	//bb��a������26��1�η�+֮ǰ�ĳ���
        	//bbb��a������26��2�η�+֮ǰ�ĳ���
        	//bbbb��a������26��3�η�+֮ǰ�ĳ���
        	for(int i=begin;i<=end;i++){
        		char a=s1[0];
        		char b=s2[0];
        		//�ȼ���ӳ���begin��end֮����ֵ�����ַ�����
        		sum+= Math.pow(26, i-1)*(b-a);
        		long sum1=0;
        		long sum2=0;
        		for(int j =1;j<s1.length;j++){
        			sum1+=(long)Math.pow(26, i-1-j)*(s1[j]-'a');
        		}
        		for(int j =1;j<s2.length;j++){
        			sum2+=(long)Math.pow(26, i-1-j)*(s2[j]-'a');
        		}
        		sum=sum+sum2-sum1;
        	}
        	sum--;
        	sum=sum%1000007;
        	System.out.println(sum);
    		
    	}
    	
    	

    }
}