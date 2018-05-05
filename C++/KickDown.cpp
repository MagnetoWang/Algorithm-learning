#include <bits/stdc++.h>
using namespace std;
#define _for(i,a,b) for(int i=(a);i<(b);i++)
#define _rep(i,a,b) for(int i=(a);i<=(b);i++)
#define _forG(i,a,b) for(i=(a);i<(b);i++)

#define Max 102
char up[Max] ,down[Max];


//核心思路，暴力搜索法。中断条件，一段出现同一列都两个字符串的位置都为2的时候终止
//注意点，应该分两种情况，s1在下，s2在上。或者s1在上，s2在下。等价于从左向右找，或者从右向左找
int findMin(char* up,char *down );
int main(){
    

    while(scanf("%s%s",up,down)==2){
        int ans=findMin(up,down);
        int ans2=findMin(down,up);
        if(ans<ans2){
            cout<<ans<<endl;

        }else
        {
            std::cout << ans2 << '\n';
        }

        
    }



    return 0;
}

int findMin(char* up,char *down ){
        int upLen=strlen(up);
        int downLen=strlen(down);
        int j=0,i=0;
        int ans=0;


        //难点，在于循环如何终止条件，容易出错
        _forG(i,0,upLen){
            for( j=0;j<downLen,i+j<upLen;j++){
                if(up[i+j]=='2'&&down[j]=='2'){
                    break;
                }
            }
            
            //这里有点不清楚为什么要考虑downLen跳出呢 
            if(i+j==upLen||j==downLen){
                break;

            }
        }
        //以i为基准 
        ans=i+downLen;
        if(ans < upLen)  {
            ans = upLen;
        }
            
        return ans;


}
/*

sample input #1
2112112112
2212112

sample input #2
12121212
21212121

sample input #3
2211221122
21212


sample output #1
10

sample output #2
8

sample output #3
15

*/
