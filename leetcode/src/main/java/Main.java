import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int numeber=Integer.valueOf(in.nextLine());

        int maxRow=Integer.MIN_VALUE;
        int maxCol=Integer.MIN_VALUE;
        for(int i=0;i<numeber;i++){

            String line=in.nextLine();
//            System.out.println(line);
            String[] lineXY=line.split(",");
            int x=Integer.valueOf(lineXY[0]);
            int y=Integer.valueOf(lineXY[1]);
            if(x>maxRow){
                maxRow=x;
            }
            if(y>maxCol){
                maxCol=y;
            }
        }
        System.out.println((maxCol+maxRow)*2);

    }
}
