
/*


https://www.nowcoder.com/questionTerminal/f821a39207cd43518ccddb27fee0481d



��Ŀ����
������ѵ��Ī֮��,Ȼ�����Ī������Լ�¶���,̸��Լ�¶���,��Ȼ�ٲ���һ����,�� ���Ǻ�Ĭ����------Լ�¶�����ʷ����ΰ��Ŀ�ѧ��. ��Ī˵,��Ĭ���������˼��һ������:��Ĭ������������̨,��̨�ܹ�����������R�ĵ��� (����֮��ľ���Ϊ���������ľ���,����(3,0),(0,4)֮��ľ�����5),���һ����̨�ܹ��� ������,��ô�ͻ�Ե������1�����˺�.��Ĭ����������̨����N*M�����еĵ���,���Ҹ������� ������. ��:��ô�����ܵ��˺����Ƕ��?
��������:
��һ��9������,R,x1,y1,x2,y2,x3,y3,x0,y0.R������̨������������,(x1,y1),(x2,y2), (x3,y3)����������̨������.(x0,y0)������˵�����.
�������:
���һ��,��һ�д�����˳��ܵ�����˺�,(���ÿ����̨�����ܹ���������,���0��)
ʾ��1
����
1 1 1 2 2 3 3 1 2
���
2x


*/

import java.util.*;
  
public class Main{
    public static void main(String[] args){
    	Scanner in = new Scanner(System.in);
    	while(in.hasNext()){
    		int R=in.nextInt();
    		int attack=0;
    		int point[][]=new int[3][2];
    		for(int i=0;i<3;i++){
    			point[i][0]=in.nextInt();
    			point[i][1]=in.nextInt();
    		}
    		int x=in.nextInt();
    		int y=in.nextInt();
    		for(int i=0;i<3;i++){
    			int length=(x-point[i][0])*(x-point[i][0])+(y-point[i][1])*(y-point[i][1]);
    			if(R>=Math.sqrt(length)){
    				attack++;
    			}
    		}
    		System.out.println(attack+"x");
    	}
    	in.close();
    }
}


