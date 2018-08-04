package dp;

/**
 * leetcode题号：279
 * @program: leetcode
 * @description: 拆解平方的和
 * @author: MagnetoWang
 * @create: 2018-08-04 19:51
 **/
public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(1200));
    }
    public static int numSquares(int n) {
        if(isSqure(n)){
            return 1;
        }
        // The result is 4 if and only if n can be written in the
        // form of 4^k*(8*m + 7). Please refer to
        // Legendre's three-square theorem.
        while((n & 3) == 0){
            n >>= 2;
        }
        if((n & 7) == 7){
            return 4;
        }
        // Check whether 2 is the result.

        double sqrt_n=Math.sqrt((double)n);
        for(int i=1;i<sqrt_n;i++){
            if(isSqure(n-i*i)){
                return 2;
            }
        }
        return 3;

    }
    public static boolean isSqure(int n)
    {
        double fsqrt = Math.sqrt(n);//先将数开平方
        int m = (int) fsqrt;//转换成整数
        return m*m == n;//把开平方后的整数再平方，看看他和开平方之前的数是不是相等
    }


}
