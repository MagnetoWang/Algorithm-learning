


/*


https://www.nowcoder.com/questionTerminal/655a43d702cd466093022383c24a38bf


ͦ����˼����Ŀ


����� 1 ���Ա�ɻ��Ĵ�����ô��1��Ҳ���ԡ�

*/




import java.util.Scanner;
  
public class Main{
    public static void main(String[] args){
    	Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	String str = in.nextLine();
        	boolean flag=false;
        	for(int i=0;i<str.length();i++){
        		StringBuilder front = new StringBuilder(str.substring(0, i));
        		front.append(str.substring(i+1, str.length()));
        		String s2=front.reverse().toString();
        		front.reverse();
        		if(s2.equals(front.toString())){
        			flag=true;
        			System.out.println("YES");
        			break;
        		}
        	}
        	if(flag==false)
        	System.out.println("NO");
            
        }
        
    	in.close();
    }
}