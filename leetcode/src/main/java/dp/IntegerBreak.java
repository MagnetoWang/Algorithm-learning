package dp;

/**
 * leetcode题号：343
 * @program: leetcode
 * @description: 整数分解
 * @author: MagnetoWang
 * @create: 2018-08-04 17:51
 **/
public class IntegerBreak {
    public static void main(String[] args) {
        int n=10;
        System.out.println((!(true)));
        IntegerBreak integerBreak=new IntegerBreak();
        System.out.println(integerBreak.integerBreak(n));
    }
    public int integerBreak(int n) {
        if(n==2||n==3){
            return n-1;
        }
        if(n==4){
            return n;
        }
        int reminder=n%3;
        if(reminder==1)
        {
            return (int)Math.pow(3,(double)(n/3-1))*4;
        }
        if(reminder==2) {
            return (int)Math.pow(3,n/3)*2;
        }
        return (int)Math.pow(3,n/3);
    }
}
