#include <bits/stdc++.h>
using namespace std;
#define _for(i,a,b) for(int i=(a);i<(b);i++)
#define _rep(i,a,b) for(int i=(a);i<=(b);i++)
#define _forG(i,a,b) for(i=(a);i<(b);i++)

const double EPS = 1e-6;
int main(){
    char line[256];
    double lg2 = log10(2),A,v;
    int B;
    while(scanf("%s",line)==1&&strcmp(line,"0e0")!=0){
        //查找字符e首次出现的位置
        //并令e为空格，相当于分开阶数和尾数
        *strchr(line,'e')=' ';
        //读取格式化的字符串，相当于以空格为界限分别读取两个字符串
        //同时转换对应浮点数和整数
        sscanf(line,"%lf%d",&A,&B);

        //核心算法，用系数法，二进制的数进过计算，会变成对应十进制的数。为了把系数分开来。
        //用以log10为底，对十进制的阶数和尾数分开。形式上 就是如下的v.实际值是A*pow(10,B)

        //v其实是二进制的形式但和十进制形式一样。
        //先把字符串的实际值减小
        v=log10(A)+B;

        //二进制的实际数是：尾数*pow(2,阶数)
        //转换实际值就是，尾数=(1-(1/pow(2,M+1)))
        //阶数=(pow(2,E)-1)。
        //用于二进制和十进制最终算出来的值相等，也就是上面的v。所以同样对尾数和阶数进行,log10计算
        //得到  v = log10(  1  -  (1/  pow(2,M+1)  )    )  +  log10(  pow(  2 , (pow(2,E)-1)  )  )
        // v = log10( ( pow(2,M+1) - 1) /pow(2,M+1) ) + (pow(2,E)-1) * log10(2) 
        //v = log10( ( pow(2,M+1) - 1) )  -  log10( pow(2,M+1) ) + (pow(2,E)-1) * log10(2)  
        //v = log10( ( pow(2,M+1) - 1) )  -  (M+1 )*  log10( 2 ) + (pow(2,E)-1) * log10(2) 
        //v = log10( ( pow(2,M+1) - 1) )  -  M *log10( 2 ) + (pow(2,E)) * log10(2) - 2*log10(2) 


        //注意M在公式中的范围是[0,9]，所以要加1,代码中我们直接加了1，所以代码中的公式M不用再加1了
        _rep(M,1,10){

            // log10(  1  -  (1/  pow(2,M+1)  )    )  +  log10(  pow(  2 , (pow(2,E)-1)  )  ) = log10(A)+B = v 
            // v 已知， M 循环 1 到 10 于是可以求出 E 的值 
            int E = round(  log10(  (   v   +   M*lg2   -   log10(pow(2,M)-1)   )   /   lg2+1   )   /lg2);

            // 将E的 再带入回原来公式 验证是否等于 V，也就是原值
            if(fabs(((1<<E)-1)*lg2+log10(pow(2,M)-1)-M*lg2-v)<=EPS){
                cout<<M-1<<" "<<E<<endl;
                break;
            }
        }


    }
    return 0;
}




/*
input:
5.699141892149156e76
9.205357638345294e18
终止输入条件
0e0

output:
5 8
8 6


*/