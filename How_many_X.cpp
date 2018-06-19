#include<bits/stdc++.h>
using namespace std;
int dig(int n,int x)
{
    int c=0;
    while(n)
    {
        if(x==n%10)c++;
        n=n/10;
    }
    return c;
}
unsigned long long int HMX(int x,int l, int u)
{
    int i;
    unsigned long long int count = 0;
    for(i=l+1;i<u;i++)
    {
        count+=dig(i,x);
    }
    return count;
}
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
	    int x;
	    cin>>x;
	    int l,u;
	    cin>>l>>u;
	    cout<<HMX(x,l,u);
	    cout<<endl;
	}
	return 0;
}