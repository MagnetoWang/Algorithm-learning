/*

https://www.nowcoder.com/questionTerminal/3745638815d04c26babcfc463c25478c

2016 平均年龄


题目描述
已知某公司总人数为W，平均年龄为Y岁(每年3月末计算，同时每年3月初入职新人)，假设每年离职率为x，x>0&&x<1,每年保持所有员工总数不变进行招聘，新员工平均年龄21岁。 
从今年3月末开始，请实现一个算法，可以计算出第N年后公司员工的平均年龄。(最后结果向上取整)。
输入描述:
输入W Y x N
输出描述:
输出第N年后的平均年龄
示例1
输入
5 5 0.2 3
输出
15



     * 总人数不变，离职多少人，就招多少人。
     * 招的人是21岁，扔在公司的长一岁
     * 
     * 133 26 0.01 64
     * 168 26 0.40 78
     * 
     * 71
     * 23


*/



import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class Main {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	
    	while(in.hasNext()){
    		double W=0,age=0,lizhilv=0,year=0;
    		W=in.nextDouble();
    		age=in.nextDouble();
    		lizhilv=in.nextDouble();
    		year=in.nextDouble();
    		year=year;
    		while((year--)!=0){
//    			System.out.println(year);
    			//age要加1.每年老员工长大一岁
    			age=(age+1)*(1-lizhilv)+lizhilv*21;
    		}
    		System.out.println((int)Math.ceil(age));
    	}

    }
}