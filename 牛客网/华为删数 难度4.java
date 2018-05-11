/*




题目描述
有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
输入描述:
每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
输出描述:
一行输出最后一个被删掉的数的原始下标位置。
示例1
输入
8
输出
6


    		//核心算法
    		//求余的思想是基本。但是这个思想非常紧凑
    		//不管i为何值，只要满足是i+2这个规律即可
    		//不管ring内有多少数，都是要删除i+2除的位置。
    		//因为每次都要删除1个数，所以复杂度o(n)
    		//好绝妙的思想啊
*/


import java.util.*;
  
public class Main{
    public static void main(String[] args){
    	Scanner in = new Scanner(System.in);
    	while(in.hasNext()){
    		int n=in.nextInt();
    		if(n>1000){
    			n=999;
    		}
    		List<Integer> ring= new LinkedList<>();
    		for(int i=0;i<n;i++){
    			ring.add(i);
    		}
    		int i=0;
    		//核心算法
    		//求余的思想是基本。但是这个思想非常紧凑
    		//不管i为何值，只要满足是i+2这个规律即可
    		//不管ring内有多少数，都是要删除i+2除的位置。
    		//因为每次都要删除1个数，所以复杂度o(n)
    		//好绝妙的思想啊
    		while(ring.size()>1){
    			i=(i+2)%ring.size();
    			ring.remove(i);
    		}
    		System.out.println(ring.get(0));
    	}
    	in.close();
    }
}