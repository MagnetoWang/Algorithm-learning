//3-10
#include <bits/stdc++.h>
using namespace std;
#define _for(i,a,b) for(int i=(a);i<(b);i++)
#define _rep(i,a,b) for(int i=(a);i<=(b);i++)
#define _forG(i,a,b) for(i=(a);i<(b);i++)


struct Rect{
    int x,y,z;
}a[6];



int main(){
	// int n=2000000000;
	// cout<<n<<endl;

    while(cin >> a[0].x >> a[0].y >> a[1].x >> a[1].y >> a[2].x >> a[2].y >> 
    a[3].x >> a[3].y >> a[4].x >> a[4].y >> a[5].x >> a[5].y){
        set<int> rect ;
        //单纯的考虑，斜边唯一，却没有考虑斜边有且只有两条。或者是正方体的问题 
        // set<int> rectFiel ;
        map<int,int> rectFiel;
        _for(i,0,6){
            rect.insert(a[i].x);
            rect.insert(a[i].y);
            a[i].z=a[i].x*a[i].x+a[i].y*a[i].y;
            if()

            rectFiel.insert(a[i].z);

        }
        if(rect.size()==3&&rectFiel.size()==3){
            cout<<"POSSIBLE"<<endl;

        }else{
            cout<<"IMPOSSIBLE"<<endl;
        }


    }

    
    
    
}


/*
input:
1345 2584
2584 683
2584 1345
683 1345
683 1345
2584 683
1234 4567
1234 4567
4567 4321
4322 4567
4321 1234
4321 1234
output:
POSSIBLE
IMPOSSIBLE


*/
