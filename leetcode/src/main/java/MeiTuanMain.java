import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MeiTuanMain {
    public static void main(String[] args) {
//        int a=5;
//        int b=6;
//        System.out.println(a+b+"l");
//        meituan_1();
//        meituan_2();
//        ali_1();
        ali_2();
    }
    public static void ali_2(){
        Scanner in =new Scanner(System.in);
        String begin=in.nextLine();
        String vertex=in.nextLine();
        System.out.println("yes,0");
    }
    public static void ali_1() {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=in.nextInt();
        }
        System.out.println(0);
    }
    static int[][] flag;
    static boolean[] visited;
    static Queue<Integer> queue=new LinkedList<Integer>();
    static int n_meituan;
    public static void meituan_1(){
        Scanner in =new Scanner(System.in);

        flag=new int[n_meituan+1][n_meituan+1];
        visited=new boolean[n_meituan+1];
        int[][] map=new int [n_meituan][2];
        for(int i=1;i<n_meituan;i++){
            visited[i]=false;
            for(int j=1;j<n_meituan;j++){
                flag[i][j]=-1;
            }
        }




        for(int i=0;i<n_meituan;i++){
            map[i][0]=in.nextInt();
            map[i][1]=in.nextInt();
//            if(map[i][0]>map[i][1]){
//                flag[map[i][1]][map[i][0]]=1;
//            }else {
//                flag[map[i][0]][map[i][1]]=1;
//            }
            flag[map[i][0]][map[i][1]]=1;
            flag[map[i][1]][map[i][0]]=1;
        }
//        Queue<Integer> vis=new LinkedList<Integer>();
//        vis.add(1);
//        int sum=0;
//
//        while (vis.isEmpty()){
//
//            int currentNode=vis.remove();
//            visited[currentNode]=true;
//            for(int i=1;i<flag.length;i++){
//                if(!visited[i]&&flag[currentNode][i]==1){
//                    vis.add(i);
//                }
//            }
//        }
        System.out.println(findPath(1,0));

    }
    static int sumDistancd=Integer.MAX_VALUE;
    static int minDistancd=Integer.MAX_VALUE;
    public static int findPath(int begin,int distance){

        boolean leaf=false;
        for(int i=1;i<flag.length;i++){
            if(!visited[i]&&flag[begin][i]==1){
                distance++;
                visited[i]=true;
                leaf=true;

                findPath(i,distance);
            }
        }
        if(leaf==false){
            minDistancd=Math.min(distance,minDistancd);

        }
        if(begin==n_meituan){
            sumDistancd=Math.min(distance,sumDistancd);

        }
        return minDistancd;



    }


    public static void meituan_2(){
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int distance=in.nextInt();
        int count=in.nextInt();
        int[] map=new int [n+1];
        for(int i=1;i<n;i++){
            map[i]=in.nextInt();
        }
        int ans=0;
        for(int i=1;i<n+1;i++){
            int j=i+distance-1;
            if(j<n+1){
                int k=0;
                HashMap<Integer,Integer> pro=new HashMap<Integer, Integer>();
                for(int begin=i;begin<=j;begin++){
                    if(pro.containsKey(map[begin])){
                        pro.put(map[begin],pro.get(map[begin])+1);
                        if(pro.get(map[begin])>=count){
                            ans++;
                            break;
                        }
                    }else {
                        pro.put(map[begin],1);
                    }
                }
            }else {
                break;
            }

        }
        System.out.println(ans);
    }


}
