#include<iostream>
#include<algorithm>  
#include<string>
#include<vector>
#include<assert.h>
using namespace std;

struct ChCnt {
    int cnt;
    char c;
    void init(char ch = 'A'){
        c= ch;
        cnt = 0;
    }
    Chcnt(){init();}
    bool operator<(const ChCnt& cc2) const{
        return cnt>cc2.cnt ||(cnt==cc2.cnt&&c<cc2.c);
    }
};//结构体后面要加冒号




int main(){
    int T=1,m,n;
    cin>>T;
    string line;
    vector<string> seqs;
    char IDX[256] = {0};
    IDX['A']=0;IDX['C']=1;IDX['G']=2;IDX['T']=3;

    while(T--){
        //输入和初始化
        seqs.clear();
        cout<<"输入m,n"<<endl;
        cin>>m>>n;
        for(int i=0;i<m;i++){
            cout<<"输入一行"<<endl;
            cin>>line;
            assert(line.size()==n);
            seqs.push_back(line);

        }

        string ansStr;
        int ans=0;
        vector<ChCnt> ccs(4);
        //找出每一竖出现最多的字母即可
        for (int i = 0; i < n; i++)
        {
            ccs[0].init('A');
            ccs[1].init('C');
            ccs[2].init('G');
            ccs[3].init('T');
            for (int j = 0; j < m; j++){
                ccs[IDX[seqs[j][i]]].cnt++;
            }
            sort(ccs.begin(),ccs.end());
            // cout<<"ccs.begin()："<<ccs.begin().c<<endl;
            cout<<"当前列："<<ccs.front().c<<endl;
            ansStr += ccs.front().c;
            ans+=(m-ccs.front().cnt);
        }   
        cout<<ansStr<<endl<<ans<<endl;
    }
    

    
    return 0;
}

/**
1
5 8
TATGATAC
TAAGCTAC
AAAGATCC
TGAGATAC
TAAGATGT



*/
