//https://www.nowcoder.com/questionTerminal/67df1d7889cf4c529576383c2e647c48
//ţ������2016�껪ΪУ����Ŀ �� �򵥴����¼
//���ǲ����׻�Ϊ����Ŀ��ô��ô������֪����Ҫ�ʵ���ʲô�����ʲô��˼�����������ͳ�ƴ����һ����ϣ��

/*����һ���򵥴����¼����Сģ�飬�ܹ���¼����Ĵ������ڵ��ļ����ƺ��кš� 
����:
1.��¼���8�������¼������ͬ�Ĵ����¼(���ļ����ƺ��к���ȫƥ��)ֻ��¼һ��������������ӣ�(�ļ����ڵ�Ŀ¼��ͬ���ļ������к���ͬҲҪ�ϲ�)
2.����16���ַ����ļ����ƣ�ֻ��¼�ļ��������Ч16���ַ���(����ļ�����ͬ����ֻ���ļ����ĺ�16���ַ����к���ͬ��Ҳ��Ҫ�ϲ�)
3.������ļ����ܴ�·������¼�ļ����Ʋ��ܴ�·��*/

/*
��������:
һ�л�����ַ�����ÿ�а�����·���ļ����ƣ��кţ��Կո������

    �ļ�·��Ϊwindows��ʽ

    �磺E:\V1R2\product\fpgadrive.c 1325
�������:
�����еļ�¼ͳ�Ʋ�������������ʽ���ļ�������������Ŀ��һ���ո��������: fpgadrive.c 1325 1 

    ���������Ŀ�Ӷൽ��������Ŀ��ͬ������£����������һ�γ���˳������

    �������8����¼����ֻ���ǰ8����¼.

    ����ļ����ĳ��ȳ���16���ַ�����ֻ�����16���ַ�
ʾ��1
����
E:\V1R2\product\fpgadrive.c 1325
���
fpgadrive.c 1325 1
*/


import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class Main {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
    	Map<String, Integer> map = new LinkedHashMap<>();
    	String key;
    	String filename;
    	String path;
    	while(in.hasNext()){
    		//��ʽ�����룬�����ո��ͣ
    		path=in.next();
    		int id=path.lastIndexOf("\\");
    		filename = id<0 ?path:path.substring(id+1);
    		int linenum =in.nextInt();
    		
    		key=filename+" "+ linenum;
    		if(map.containsKey(key)==true){
    			map.put(key, map.get(key)+1);
    		}else{
    			map.put(key, 1);
    		}
    		
    	}
    	
    	in.close();
    	
    	
    	
    	List<Map.Entry<String, Integer>> list 
    	= new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
    	Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){
    		
    	@Override
    	public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {

    			return(arg1.getValue()-arg0.getValue()) == 0
    					? (arg0.getValue()-arg1.getValue()) : (arg1.getValue()-arg0.getValue());
    	}
    	});
    	
    	int m=0;
    	for(Map.Entry<String, Integer> mapping : list){
    		 m++;
    		 if(m<=8){
    			 String[] str = mapping.getKey().split(" ");
    			 String k = str[0].length()>16 ? str[0].substring(str[0].length()-16) : str[0];
    			 String n = str[1];
    			 System.out.println(k+" "+n+" "+mapping.getValue());
    		 }else{
    			 break;
    		 }
    	}


    }

}