/*

https://www.nowcoder.com/questionTerminal/81bb01ef2bb144808a8277e9164a0886

*/





import java.util.Scanner;
  
public class Main{
    public static void main(String[] args){
    	Scanner in = new Scanner(System.in);
    	while(in.hasNext()){
    		int r=in.nextInt();
    		long x=in.nextInt();
    		long y=in.nextInt();
    		long x1=in.nextInt();
    		long y1=in.nextInt();
    		long length=(y1-y)*(y1-y)+(x1-x)*(x1-x);
    		length=(long) Math.sqrt(length);
    		int n=(int) (length/(2*r));
    		System.out.println(n);
    	}
    	in.close();
       
    }
}