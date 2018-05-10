



/*


https://www.nowcoder.com/questionTerminal/3a571cdc72264d76820396770a151f90

*/




import java.util.Scanner;
  
public class Main{
    public static void main(String[] args){
    	Scanner in = new Scanner(System.in);
    	while(in.hasNext()){
    		int n = in.nextInt();
    		int a[]=new int [n];
    		for(int i=0;i<n;i++){
    			
    			a[i]=in.nextInt();
    		}
    		int sum=0;
    		for(int i=1;i<n;i++){
    			if(sum<a[i]-a[i-1]){
    				sum=a[i]-a[i-1];
    			}
    		}
    		System.out.println(sum);
    	}
    	in.close();
    }
}