package dp;

/**
 * leetcode题号：91
 * @program: leetcode
 * @description: 解码的个数
 * @author: MagnetoWang
 * @create: 2018-08-04 20:21
 **/
public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings("0"));

    }
    public static int numDecodings(String s) {

        char[] number=s.toCharArray();
        int[] dp=new int[number.length+1];
        dp[0]=1;

        //这里是存放第1个数字结果。所以对于0要有个判断。
        dp[1] = s.charAt(0) != '0' ? 1 : 0;


        for(int i=2;i<=s.length();i++){
            int first=Integer.valueOf(s.substring(i-1,i));
            int second=Integer.valueOf(s.substring(i-2,i));
            if(first!=0){
                dp[i]+=dp[i-1];
            }
            if(second>=10&&second<=26){
                dp[i]+=dp[i-2];
            }

        }
        return dp[s.length()];
    }
}
