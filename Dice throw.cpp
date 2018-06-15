#include<bits/stdc++.h>
using namespace std;

long long int DT(int m, int n, int x)
{
    if(x<0)    return 0;
    if(x==0 && n==0)    return 1;
    int i;
    unsigned long long int count=0;
    for(i=1;i<=m;i++)
    {
        count+=DT(m,n-1,x-i);
    }
    return count;
}

long long int table[60][60];
long long int DT_DP(int m, int n, int x)
{
    if(x==0 && n==0)
    {
        table[x][n]=1;
        return table[x][n];
    }
    int i;
    unsigned long long int count=0;
    for(i=1;i<=m;i++)
    {
        if(x-i>=0 && n-1>=0){
        if(table[n-1][x-i]==-1)
        {
            table[n-1][x-i] = DT_DP(m,n-1,x-i);
        }
        count+=table[n-1][x-i];
        }
    }
    table[n][x]=count;
    return table[n][x];
}

int main()
{
	int t;
	cin>>t;
	while(t--)
	{
	    int m,n,x;
	    cin>>m>>n>>x;
	    
	   // cout<<DT(m,n,x);
	   // cout<<endl;
	    
	    for(int i=0;i<60;i++)
	    {
	        for(int j=0;j<60;j++)
	        {
	            table[i][j]=-1;
	        }
	    }
	    
	    cout<<DT_DP(m,n,x);
	    cout<<endl;
	}
	return 0;
}