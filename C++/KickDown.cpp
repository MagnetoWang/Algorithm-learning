#include <bits/stdc++.h>
using namespace std;
#define _for(i,a,b) for(int i=(a);i<(b);i++)
#define _rep(i,a,b) for(int i=(a);i<=(b);i++)
#define _forG(i,a,b) for(i=(a);i<(b);i++)

#define Max 102
char up[Max] ,down[Max];


//����˼·���������������ж�������һ�γ���ͬһ�ж������ַ�����λ�ö�Ϊ2��ʱ����ֹ
//ע��㣬Ӧ�÷����������s1���£�s2���ϡ�����s1���ϣ�s2���¡��ȼ��ڴ��������ң����ߴ���������
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


        //�ѵ㣬����ѭ�������ֹ���������׳���
        _forG(i,0,upLen){
            for( j=0;j<downLen,i+j<upLen;j++){
                if(up[i+j]=='2'&&down[j]=='2'){
                    break;
                }
            }
            
            //�����е㲻���ΪʲôҪ����downLen������ 
            if(i+j==upLen||j==downLen){
                break;

            }
        }
        //��iΪ��׼ 
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
