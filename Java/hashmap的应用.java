//https://www.nowcoder.com/questionTerminal/67df1d7889cf4c529576383c2e647c48
//牛客网，2016年华为校招题目 ： 简单错误记录
//真是不明白华为的题目怎么那么长，不知道想要问的是什么，表达什么意思。搞的最后就是统计错误的一个哈希表

/*开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。 
处理:
1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
3.输入的文件可能带路径，记录文件名称不能带路径*/

/*
输入描述:
一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。

    文件路径为windows格式

    如：E:\V1R2\product\fpgadrive.c 1325
输出描述:
将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1 

    结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。

    如果超过8条记录，则只输出前8条记录.

    如果文件名的长度超过16个字符，则只输出后16个字符
示例1
输入
E:\V1R2\product\fpgadrive.c 1325
输出
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
    		//格式化读入，遇到空格就停
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