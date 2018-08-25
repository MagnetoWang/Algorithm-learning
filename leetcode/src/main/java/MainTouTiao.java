import java.util.*;

public class MainTouTiao {
    public static void main(String[] args) {
//        un();
        twoString();
//        toutiao_2_1();
//        toutiao_1();
    }
    public static void twoString(){
        Scanner in = new Scanner(System.in);
        int n=Integer.valueOf(in.next());
        for(int i=0;i<n;i++){
            int number=Integer.valueOf(in.next());
//            in.nextLine();
            List<StringBuilder> e=new LinkedList<StringBuilder>();
//            String string1=in.nextLine();
            int j=0;
            while (in.hasNext()){

                StringBuilder string2=new StringBuilder(in.next());
//                System.out.println(string2.toString());
                e.add(string2);
                j++;
                if(j==number){
                    break;
                }
            }




            int flag=0;
            for(StringBuilder eBuilder :e){
                StringBuilder string1=eBuilder;
                for(StringBuilder h:e){
                    if(h.toString().equals(string1.toString())){
                        continue;
                    }
                    StringBuilder string2=h;
                    string2.append(string2);
                    if(string2.toString().contains(string1.toString())||string2.reverse().toString().contains(string1.toString())){
                        System.out.println("Yeah");
                        flag=1;
                        break;
                    }
//                    else {
//                        System.out.println("Sad");
//                        break;
//                    }
                }
                if(flag==1){
                    break;
                }
            }

//            string2.append(string2);
//            System.out.println(string2.toString());
//            System.out.println(string2.reverse().toString());
            if(flag==0) {
                System.out.println("Sad");
            }
        }



    }

    private static int[] unFind;
    private static byte[] rank;

    public static void un(){
        Scanner in = new Scanner(System.in);
        n=Integer.valueOf(in.nextLine());
        unFind=new int[n+1];
        rank=new byte[n+1];
        for (int i=1;i<=n;i++){
            unFind[i]=i;
        }
        for (int i=1;i<=n;i++){
            String x=in.nextLine();
//            System.out.println(x);
            String[] number=x.split(" ");
            if(number[0].equals("0")){
                continue;
            }
            for(int j=0;j<number.length;j++){
                if(number[j].equals("0")){
                    continue;
                }
//                System.out.println(Integer.valueOf(number[j]));
                if (connected(i, Integer.valueOf(number[j]))) continue;
                union(i, Integer.valueOf(number[j]));
            }
        }
        Set<Integer> e=new HashSet<Integer>();
        for(int i=1;i<=n;i++){
            e.add(unFind[i]);
        }
        System.out.println(e.size());


    }
    public static void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;


        if      (rank[rootP] < rank[rootQ]) unFind[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ]) unFind[rootQ] = rootP;
        else {
            unFind[rootQ] = rootP;
            rank[rootP]++;
        }
//        count--;
    }
    public static int find(int p) {
        while (p != unFind[p]) {
            unFind[p] = unFind[unFind[p]];
            p = unFind[p];
        }
        return p;
    }
    public static  boolean connected(int p, int q) {
        return find(p) == find(q);
    }








    // validate that p is a valid index
    private void validate(int p) {
        int n = unFind.length;
            if (p < 0 || p >= n) {
//            return false;
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }



    static Integer[]  set;
    static Integer n;
    static List<Set<String>> setList=new LinkedList<Set<String>>();
    public static void toutiao_2_1(){
        Scanner in = new Scanner(System.in);
        n=Integer.valueOf(in.nextLine());
        Map<String,Set<String>> friends=new HashMap<String, Set<String>>();
        for (int i=1;i<=n;i++){
            Set<String> e=new HashSet<String>();

        }
        for(int i=1;i<=n;i++){
            String x=in.nextLine();
            String[] number=x.split(" ");
            if(number[0].equals("0")){
                continue;
            }
            int flag=0;
            for(int j=0;j<number.length;j++){
                if(number[j].equals("0")){
                    break;
                }
                for(Set<String> e : setList){
                    if(e.contains(String.valueOf(i))||e.contains(number[j])){
                        flag=1;
                        for(int k=0;k<number.length;k++){
                            e.add(number[k]);
                        }
//                        break;
                    }
                }
                if (flag==1){
                    break;
                }
            }
            if(flag==0){
                Set<String> e=new HashSet<String>();
                for(int k=0;k<number.length;k++){
                    e.add(number[k]);
                }
                e.add(String.valueOf(i));
                setList.add(e);
            }
        }
        System.out.println(setList.size());

    }
    public static void setN(){

    }

    public static void toutiao_1(){
        Scanner in=new Scanner(System.in);
        String line=in.nextLine();
        int n=Integer.valueOf(line.split(",")[0]);

        int m=Integer.valueOf(line.split(",")[1]);
        int[][] map=new int[n  ][m];
        for(int i=0;i<n;i++){
            line=in.nextLine();
            for (int j=0;j<m;j++){

                map[i][j]=Integer.valueOf(line.split(",")[j]);

            }
        }
        int group=0;
        int maxPeople=0;
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(map[i][j]==1){
                    group++;
                    maxPeople=Math.max(maxPeople,findPeople(i,j,n,m,map));
                }
            }
        }
        System.out.println(group+","+maxPeople);
//        System.out.println(maxPeople);

    }
    public static int findPeople(int currentRow,int currentCol,int row,int col,int map[][]){
        map[currentRow][currentCol]=0;
        int people=1;
        int x=currentRow+1;
        int y=currentCol;

        if(x<row&&map[x][y]==1){
           people= people+findPeople(x,y,row,col,map);
        }
        y=currentCol;
        x=currentRow-1;
        if(x>=0&&map[x][y]==1){
            people= people+findPeople(x,y,row,col,map);
        }
        x=currentRow;
        y=currentCol+1;
        if(y<col&&map[x][y]==1){
            people= people+findPeople(x,y,row,col,map);
        }
        x=currentRow;
        y=currentCol-1;
        if(y>=0&&map[x][y]==1){
            people= people+findPeople(x,y,row,col,map);
        }
        x=currentRow+1;
        y=currentCol+1;
        if(x<row&&y<col&&map[x][y]==1){
            people= people+findPeople(x,y,row,col,map);
        }
        x=currentRow+1;
        y=currentCol-1;
        if(x<row&&y>=0&&map[x][y]==1){
            people= people+findPeople(x,y,row,col,map);
        }
        x=currentRow-1;
        y=currentCol+1;
        if(x>=0&&y<col&&map[x][y]==1){
            people= people+findPeople(x,y,row,col,map);
        }
        x=currentRow-1;
        y=currentCol-1;
        if(x>=0&&y>=0&&map[x][y]==1){
            people= people+findPeople(x,y,row,col,map);
        }
        return people;
    }


}
