#include<iostream>
#include<algorithm>  
#include<string>
#include<vector>
#include<assert.h>
#include<map>
using namespace std;

const int MAXN = 3000+5;
map<int,int> Pos;
void solve(int n,const int d,string& ans,int& r){
    assert(n%d && n<d);

    ans=".";
    Pos.clear();
    while(true){
        n *=10;
        
        //这里是中断循环点关键代码 
        //这里有个误区，会误认为小数点后面的值重复即可
		//其实是错误的。必须是余数重复才是有效的循环 
        int p= Pos[n];
        if(p==0){//如果出现重复数字，也就是不为0。开始判断 
            Pos[n]=ans.size();
        }else{
        	//减去上一次出现的位置。也就是算出重复出现的数字两次位置之间距离 
            r =ans.size()-p; 
            //r大于50不在计算 
            if(r>50){
                ans.erase(p+50);
                ans += "...";
            }
            //在第一次重复出现数字的位置前面加括号 
            ans.insert(p,"(");
            //在最后一次重复出现数字的位置后面加括号
            ans+= ')';
            break;
			 
        }
        
        //合当前为比较n更小的话，输出0，比如7/10 十位要等于0，继续计算个位 
        if(n<d){
                ans +='0';
                continue;
            }//补0
            

			//更新下一位的余数和值。如果余数为0.正好结束 
            int div =n/d,mod = n%d;
            ans += (char)(div + '0');
            
            n=mod;
            if(n==0){
                ans += "(0)";
                r=1;
                break;
            }
    }

}

int main(){
    int a,b;
    while(scanf("%d%d",&a,&b)==2){
        string ans=".(0)";
        int r=1;
        if(a%b) solve(a%b,b,ans,r);
        printf("%d/%d = %d%s \n",a,b,a/b,ans.c_str());
        printf("%d=number of digits in repeating cycle\n\n",r);
        
    }
    return 0;
}

/*
input:
3 7
output:
3/7 = 0.(428571)
6=number of digits in repeating cycle

input:
5 43
output:
5/43 = 0.(116279069767441860465)
21=number of digits in repeating cycle


*/ 
