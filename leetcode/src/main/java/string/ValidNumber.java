package string;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description: 有效数字
 * @author: MagnetoWang
 * @create: 2018-08-18 13:31
 **/
public class ValidNumber {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println(vaild(in.nextLine()));

    }
    public static boolean vaild(String s){
        if(s.charAt(s.length()-1)=='f'||s.charAt(s.length()-1)=='F'
                ||s.charAt(s.length()-1)=='d'||s.charAt(s.length()-1)=='D'){
            return false;
        }
        try {
            Float.parseFloat(s);
            return true;
        }catch (Exception e){
            return false;

        }
    }
}
