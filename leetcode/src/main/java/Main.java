import java.util.*;

public class Main {
    public static void main(String[] args) {
//        pinduoduo_1();
//        pinduoduo_2();
//        pingduoduo_3();
        pingduoduo_4();
//        Scanner in=new
// Scanner(System.in);
//        int numeber=Integer.valueOf(in.nextLine());
//
//        int maxRow=Integer.MIN_VALUE;
//        int maxCol=Integer.MIN_VALUE;
//        for(int i=0;i<numeber;i++){
//
//            String line=in.nextLine();
////            System.out.println(line);
//            String[] lineXY=line.split(",");
//            int x=Integer.valueOf(lineXY[0]);
//            int y=Integer.valueOf(lineXY[1]);
//            if(x>maxRow){
//                maxRow=x;
//            }
//            if(y>maxCol){
//                maxCol=y;
//            }
//        }
//        System.out.println((maxCol+maxRow)*2);

    }
    public static void pinduoduo_1(){
        Scanner in=new Scanner(System.in);
        String line=in.nextLine();
        char[] lineChar=line.toCharArray();
        int boder=line.length()/4+1;
        char[][] map=new char[boder][boder];
        for(int i=0;i<boder;i++){
            map[0][i]=lineChar[i];

        }
        for(int i=0;i<boder;i++){
            map[i][boder-1]=lineChar[i+boder-1];
        }
        for(int i=boder-1,j=0;i>0;i--,j++){
            map[boder-1][i]=lineChar[boder*2-2+j];
        }
        for(int i=boder-1,j=0;i>0;i--,j++){
            map[i][0]=lineChar[j+boder*3-3];
        }
        for(int i=0;i<boder;i++){
            for (int j=0;j<boder;j++){
                if(i==0||i==boder-1||j==0||j==boder-1)
                System.out.printf(String.valueOf(map[i][j]));
                else {
                    System.out.printf(" ");
                }
            }
            System.out.println();
        }
    }

    private static HashSet<Double> set=new HashSet<Double>();
    private static HashSet<Double> numberSet=new HashSet<Double>();
    public static void pinduoduo_2(){
        Scanner in=new Scanner(System.in);

        String line=in.nextLine();
        System.out.println(findKinds(line,1));

    }
    public static int findKinds(String line ,int split){
        if(!set.contains(line.substring(0,split))||!set.contains(line.substring(split,line.length()))){
            set.add(Double.valueOf(line.substring(0,split)));
            int kind=1;
            kind+=findPoints((line.substring(0,split)),1);
            set.add(Double.valueOf(line.substring(split,line.length())));
            kind+=findPoints((line.substring(split,line.length())),1);

            if(line.length()-1>split){
                split++;
                return kind+findKinds(line,split);
            }
            return kind;

        }else {
            if(line.length()-1>split){
                split++;
                return 0+findKinds(line,split);
            }
            return 0;
        }
    }
    public static int findPoints(String number,int split){
        if(number.length()==1){
            return 1;
        }
        StringBuilder stringBuilder=new StringBuilder(number.substring(0,split));
        stringBuilder.append(".");
        stringBuilder.append(number.substring(split,number.length()));
        if(String.valueOf(Double.valueOf(stringBuilder.toString())).length()==stringBuilder.length()){
            split++;
            return 1+findPoints(number,split);
        }
        return 0;
    }
    public static void pingduoduo_3(){
        Scanner in=new Scanner(System.in);
        String first=in.nextLine();
        String[] firstStr=first.split(" ");
        int n=Integer.valueOf(firstStr[0]);
        int user=Integer.valueOf(firstStr[1]);
        HashMap<String ,Integer> hashMap=new HashMap<String, Integer>();
        Set<String> set=new HashSet<String>();
        for(int i=0;i<n;i++){
            String line=in.nextLine();
            if(!line.contains(firstStr[1])){
                continue;
            }
            set.add(String.valueOf(i));
            String[] friends=line.split(" ");
            for(int j=0;j<friends.length;j++){
                if(hashMap.containsKey(friends[j])){
                    Integer tmp=hashMap.get(friends[j]);
                    tmp++;
                    hashMap.put(friends[j],tmp);
                }else {
                    hashMap.put(friends[j],1);
                }
            }
        }
        int max=0;
        String name="end";
        for(String e:hashMap.keySet()){
            if(max<=hashMap.get(e)&&!firstStr[1].equals(e)&&!set.contains(e)){
                max=hashMap.get(e);
                name=e;
            }
        }
        System.out.println(name);


//        System.out.printf(name);
    }
    public  static void pingduoduo_4(){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        LinkedList<Integer> number=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            number.add(in.nextInt());
        }
        int lenght=n;
        int sum=0;
        while (lenght!=0){
            sum++;
            int up=0;
            int down=0;
            if(number.size()<=2){
                break;
            }
            for(int i=2;i<number.size();i++){
                if(number.get(i-2)<number.get(i)){
                    up++;
                }
                if(number.get(i-2)>number.get(i)) {
                    down++;
                }
            }
            if(up>down){
                if(up>=lenght){
                    break;
                }
                lenght-=up;
                for(int i=2;i<number.size();i++){
                    if(number.get(i-2)<number.get(i)){

                        number.remove(i-2);
                    }
                }

            }else {
                if(down>=lenght){
                    break;
                }
                lenght-=down;
                for(int i=2;i<number.size();i++){
                    if(number.get(i-2)>number.get(i)){

                        number.remove(i-2);
                    }
                }
                lenght-=down;
            }
        }
        System.out.println(sum);
    }
}
/*

5 0
1 2 3
0 1 2
0 1 2
2 1 0
1 2 3
 */