#include<iostream>
#include<algorithm>  
#include<string>
#include<vector>
#include<assert.h>
#include<map>
#include <bits/stdc++.h>
using namespace std;

const int LEN = 100024;
char s[LEN],t[LEN];
int main(){
	while(scanf("%s%s",s,t)==2){
        int sLen=strlen(s),tLen=strlen(t);
        bool ok= false;
        for(int i =0,j=0;i<sLen,j<tLen;j++){
            
                if(s[i]==t[j]){
                    i++;
                    if(i==sLen){
                        ok=true;
                    }
                }
        }
        if(ok){
            cout<<"YES"<<endl;
            
        }else{
        	cout<<"NO"<<endl;
		}
    }
    return 0;
}
/*
input:
op abcdefgh
bc abcdefgh
output:
NO
YES

*/
