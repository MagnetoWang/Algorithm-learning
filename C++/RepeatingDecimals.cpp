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
        
        //�������ж�ѭ����ؼ����� 
        //�����и�������������ΪС��������ֵ�ظ�����
		//��ʵ�Ǵ���ġ������������ظ�������Ч��ѭ�� 
        int p= Pos[n];
        if(p==0){//��������ظ����֣�Ҳ���ǲ�Ϊ0����ʼ�ж� 
            Pos[n]=ans.size();
        }else{
        	//��ȥ��һ�γ��ֵ�λ�á�Ҳ��������ظ����ֵ���������λ��֮����� 
            r =ans.size()-p; 
            //r����50���ڼ��� 
            if(r>50){
                ans.erase(p+50);
                ans += "...";
            }
            //�ڵ�һ���ظ��������ֵ�λ��ǰ������� 
            ans.insert(p,"(");
            //�����һ���ظ��������ֵ�λ�ú��������
            ans+= ')';
            break;
			 
        }
        
        //�ϵ�ǰΪ�Ƚ�n��С�Ļ������0������7/10 ʮλҪ����0�����������λ 
        if(n<d){
                ans +='0';
                continue;
            }//��0
            

			//������һλ��������ֵ���������Ϊ0.���ý��� 
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
