
    /*
     * 



牛客网 2016 字符串计数


求字典序在s1和s2之间的，长度在len1到len2的字符串的个数，结果mod 1000007。

输入描述:
每组数据包涵s1（长度小于100），s2（长度小于100），len1（小于100000），len2（大于len1，小于100000）
输出描述:
输出答案。
示例1
输入
ab ce 1 2
输出
56









首先要搞清楚字典序的意思：即从两个字符串的下标为0开始进行对比，字典序是从左往右进行对比的。 
例如ab，abc这样两者之间的字符串个数为aba、abb，而ab、bb两者之间的字符串个数为：ac、ad、ae…az、ba这26个，所以高位的字符串个数要是26的i次幂。 
其次，要理解题目的“长度在len1到len2的字符串的个数”，指的是长度在len1的字符串个数、长度在len1+1的字符串个数。。。长度为len2的字符串个数。 
例abcde、acede这两个字符串，长度为1到4表示的是长度为1的时候两个字符a、a之间的个数，长度为2的时候两个字符ab、ac之间的个数，长度为3的时候abc、ace两个字符串之间的个数，长度为4：abcd、aced的个数。 
所以计算的时候应该以长度作为变量遍历len1到len2之间的字符串个数，最后相加。
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
        	//字典序，正常的相等字符串都是差0，如果差一个字母的顺序，如a,b两个字母是差1，即26的0次方
        	//但是如果长度是2的话,如ax,bx。x代表某个字母，就是26的1次方
        	//长度是3的话，如axx,bxx。就是26的2次方
        	//这是其中一个计算。
        	//接下来是单子字符串的字符顺序
        	//如b,bb,bbb,bbbb
        	//b到a距离是26的0次方
        	//bb到a距离是26的1次方+之前的长度
        	//bbb到a距离是26的2次方+之前的长度
        	//bbbb到a距离是26的3次方+之前的长度
        	for(int i=begin;i<=end;i++){
        		char a=s1[0];
        		char b=s2[0];
        		//先计算从长度begin到end之间的字典序的字符串数
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