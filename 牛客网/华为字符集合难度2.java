/*



��Ŀ����
����һ���ַ�����������ַ����������ַ�����
��������:
ÿ����������һ���ַ������ַ�����󳤶�Ϊ100����ֻ������ĸ��������Ϊ�մ������ִ�Сд��
�������:
ÿ������һ�У����ַ���ԭ�е��ַ�˳������ַ����ϣ����ظ����ֲ��������ĸ�������
ʾ��1
����
abcqweracb
���
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