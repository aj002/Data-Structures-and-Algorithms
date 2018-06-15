#include<bits/stdc++.h>
using namespace std;
bool udig(int n)
{
    bool visited[10]={false};
    while(n)
    {
        int dig = n%10;
        if(visited[dig]==true)
        {
            return false;
        }
        visited[dig]=true;
        n=n/10;
    }
    return true;
}
void unique(int m, int n)
{
    int i;
    for(i=m;i<=n;i++)
    {
        if(udig(i))
        {
            cout<<i<<" ";
        }
    }
}
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
	    int m,n;
	    cin>>m>>n;
	    unique(m,n);
	    cout<<endl;
	}
	return 0;
}