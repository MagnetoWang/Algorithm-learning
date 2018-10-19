import java.util.HashMap;
import java.util.Scanner;

public class WangYiMain  {

    public static void main(String[] args) {
//        wangyi_3();

        System.out.println("hello world");
    }

    public static void wangyi_1() {
        Scanner in = new Scanner(System.in);

        String bw=in.nextLine();
        System.out.println(bw.length());
    }
    public static void wangyi_2() {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int house=in.nextInt();
            int people=in.nextInt();
            int empty=house-people;
//            if(empty==0){
//                System.out.println("0 0");
//                return;
//            }
            if(house<3){
                System.out.println("0 0");
            }else{
                if(empty==house){
                    System.out.println("0 0");
                    continue;
                }
                if(people>empty){
                    System.out.println("0 "+empty);
                }else{
                    System.out.println("0 "+(people-1));
                }

            }
        }

    }
    public static void wangyi_3(){
        Scanner in = new Scanner(System.in);
        int voter=in.nextInt();
        int present=in.nextInt();
        int[] presentCost=new int[voter+1];

        for(int i=0;i<voter;i++){
            presentCost[i]=0;
        }
        int max=Integer.MIN_VALUE;
        int maxIndex=0;
        int[][] voterCost=new int[voter][2];
        HashMap<Integer,Integer> counts=new HashMap<Integer, Integer>();
        for(int i=1;i<=present;i++){
            counts.put(i,1);
        }
        for(int i=0;i<voter;i++){
            int index=in.nextInt();
            int cost=in.nextInt();
            if(counts.containsKey(index)){
                counts.put(index,counts.get(index)+1);
            }
            voterCost[i][0]=index;
            voterCost[i][1]=cost;


        }
        boolean flag=true;
        max=counts.get(1);
        int maxCounts=0;
        for(int i=2;i<=present;i++){
            if(counts.get(1)<counts.get(i)){
                flag=false;
                maxCounts=counts.get(i);
                max=counts.get(i);
                maxIndex=i;
            }
        }
        int min=Integer.MAX_VALUE-10;
        int result=0;
        for(int i=0;i<(max-counts.get(1))/2+1;i++){
            min=Integer.MAX_VALUE-10;
            for(int j=0;j<voter;j++){
                if(min>voterCost[j][1]&&voterCost[j][0]!=1){
                    min=voterCost[j][1];
                    voterCost[j][1]=Integer.MAX_VALUE;
                }
            }
            result+=min;
        }
        if(flag){
            System.out.println(0);
            return;
        }else {
            System.out.println(result);
        }
    }
}
