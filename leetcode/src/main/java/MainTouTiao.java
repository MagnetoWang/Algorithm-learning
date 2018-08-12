import java.util.Scanner;

public class MainTouTiao {
    public static void main(String[] args) {
        toutiao_1();
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
