/*



题目描述
输入一个字符串，求出该字符串包含的字符集合
输入描述:
每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
输出描述:
每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
示例1
输入
abcqweracb
输出
abcqwer
*/




import java.util.Scanner;
  
public class Main{
    public static void main(String[] args){
    	Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	String str =in.nextLine();
        	int az[]=new int[27];
        	int AZ[]=new int[27];
        	for(int i=0;i<str.length();i++){
        		if(str.charAt(i)>='A'&&str.charAt(i)<='Z'){
        			if(AZ[str.charAt(i)-'A']==0){
        				System.out.print(str.charAt(i));
        				
        			}
        			AZ[str.charAt(i)-'A']++;
        			
        			
        		}
        		if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
        			if(az[str.charAt(i)-'a']==0){
        				System.out.print(str.charAt(i));
        			}
        			az[str.charAt(i)-'a']++;
        		}
        		
        	}
            System.out.println();
            
        }
        
    	in.close();
    }
}