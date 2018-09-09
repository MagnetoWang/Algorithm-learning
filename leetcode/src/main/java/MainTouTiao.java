import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTouTiao {
    public static void main(String[] args) {
        zhuiyi_2();
    }
    public static void zhuiyi_1(){
        Scanner sc = new Scanner(System.in);
        String x=sc.nextLine();
        String y=sc.nextLine();

        System.out.println(new BigInteger(x).multiply(new BigInteger(y)));
    }

    /**
     * abbaad
     */
    public static void zhuiyi_2(){
        Scanner sc = new Scanner(System.in);
        String line=sc.nextLine();
        StringBuilder stringBuilder=new StringBuilder(line);
        String[] head=zhuiyiHuiZhui(stringBuilder.toString());
        String[] tail=zhuiyiHuiZhui(stringBuilder.reverse().toString());
        int max=0;
        int index=0;
        int maxIndex=0;
        for(int i=0;i<head.length;i++){

            for(int k=0;k<tail.length;k++){
                int sum=0;
                for(int j=0;j<Math.min(head[i].length(),tail[k].length());j++){
//                    System.out.println(head[i]);
//                    System.out.println(tail[i]);
                    if(head[i].charAt(j)==tail[k].charAt(j)){
                        sum++;
                        index=i;
                    }else {
                        break;
                    }
                }
                if(max<sum){
                    max=sum;
                    maxIndex=index;
                }

            }

        }

        System.out.println(head[maxIndex].substring(0,max));

        System.out.println(max);
    }
    public static String[] zhuiyiHuiZhui(String s){
        String[] suffix=new String[s.length()];
        for(int i=0;i<s.length();i++){
            suffix[i]=s.substring(i);
        }
        return suffix;
    }
    //abc
    //3
    public static void toutiao_3_1(){
        Scanner sc = new Scanner(System.in);
        String line=sc.nextLine();
        int max=0;
        int sum=0;
        Map<Character,Integer> pro=new HashMap<Character, Integer>();
        int begin=0;
        for(int i = 0; i < line.length(); ){
            if(pro.containsKey(line.charAt(i))){

                pro.remove(line.charAt(begin));
                if(sum<max){
                    sum=max;
                }
                begin++;
                max--;
            }else {
                pro.put(line.charAt(i),1);
                i++;
                max++;
            }
        }
        if(sum<max){
            sum=max;
        }
        System.out.println(sum);
    }

    /**
     * input
     * 4
     * 1 0 0 0
     * 0 0 0 0
     * 0 0 0 1
     * 0 0 0 0
     *output
     * 2
     *
     *
     * 4
     * 1 1 1 1
     * 0 0 0 0
     * 1 1 0 0
     * 0 0 1 1
     */
    public static void toutiao_3_2(){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        apartment=new int[n][n];
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n;j++){
                apartment[i][j]=sc.nextInt();
            }
        }
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n;j++){
                if(i>=0&&i<n&&j>=0&&j<n&&apartment[i][j]==1){
                    TeamSum++;
                    apartment[i][j]=0;
                    findTeam(i,j,n);
                }
            }
        }
        System.out.println(TeamSum);
    }
    static int[][] apartment;
    static int TeamSum=0;
    public static void findTeam(int x,int y,int n){
        int xNew=x-1;
        int yNew=y;
        if(xNew>=0&&xNew<n&&yNew>=0&&yNew<n&&apartment[xNew][yNew]==1){
//            TeamSum++;
            apartment[xNew][yNew]=0;
            findTeam(xNew,yNew,n);
        }
        xNew=x;
        yNew=y-1;
        if(xNew>=0&&xNew<n&&yNew>=0&&yNew<n&&apartment[xNew][yNew]==1){
//            TeamSum++;
            apartment[xNew][yNew]=0;
            findTeam(xNew,yNew,n);
        }
        xNew=x+1;
        yNew=y;
        if(xNew>=0&&xNew<n&&yNew>=0&&yNew<n&&apartment[xNew][yNew]==1){
//            TeamSum++;
            apartment[xNew][yNew]=0;
            findTeam(xNew,yNew,n);
        }
        xNew=x;
        yNew=y+1;
        if(xNew>=0&&xNew<n&&yNew>=0&&yNew<n&&apartment[xNew][yNew]==1){
//            TeamSum++;
            apartment[xNew][yNew]=0;
            findTeam(xNew,yNew,n);
        }
    }

    /**
     * 55555555
     * 555555559
     * 255255255255
     * 192255255255
     *
     * 100001
     *
     * 010000100000
     *
     * 000000000000
     */
    public static void toutiao_3_3(){
        Scanner sc = new Scanner(System.in);
        String line=sc.nextLine();
        int ans=0;
        if(line.length()>12){
            System.out.println(0);
            return;
        }
        if(line.length()==4){
            System.out.println(1);
            return;
        }
//        if(line.length()==5){
//            System.out.println(4);
//            return;
//        }
        if(line.length()>4) {
            String IPADDRESS_PATTERN =
                    "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

            Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
            StringBuilder ip=new StringBuilder(line);
            Matcher matcher = pattern.matcher(ip);
            int sum=0;
            int cout=0;
            for(int i=1;i<line.length()-2;i++){
                for (int j=i+1;j<line.length()-1;j++){
                    for (int k=j+1;k<line.length();k++){
                        ip.insert(k,".");
                        ip.insert(j,".");
                        ip.insert(i,".");
                        cout++;


                        if (matcherFind(ip.toString())) {
                            System.out.println("ok : "+ip);
                            sum++;
                        }else {
                            System.out.println("not ok : "+ip);
                        }
                        ip=new StringBuilder(line);
                    }
                }
            }
//            for(String e:ipSet){
//                System.out.println(ipSet);
//            }
            System.out.println(ipSet);
            System.out.println(ipSet.size());
            System.out.println(sum);
            System.out.println(cout);
            return;
        }

    }
    static Set<String> ipSet=new HashSet<String>();
    public static boolean matcherFind(String ip){
        String[] number=ip.split("\\.");
//        System.out.println("find "+ip);
        int i=1;
        for(String e:number){
//            System.out.println(e);
            if(i==1){
                i++;
                if(Integer.valueOf(e)>192||Integer.valueOf(e)<0){
                    return false;
                }
                continue;
            }
            if(Integer.valueOf(e)>255||Integer.valueOf(e)<0){
                return false;
            }
        }
        ipSet.add(String.valueOf(Integer.valueOf(number[0]))+"."+String.valueOf(Integer.valueOf(number[1]))+"."+String.valueOf(Integer.valueOf(number[2]))+"."+String.valueOf(Integer.valueOf(number[3])));
        return true;
    }
    public static void toutiao_3_4(){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String line=sc.nextLine();
        System.out.println(1);
    }
    public static void toutiao_3_5(){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        String line=sc.nextLine();
        System.out.println(1);
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
