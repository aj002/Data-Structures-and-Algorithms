#include<bits/stdc++.h>
using namespace std;
bool isprime(int n)
{
    int sqrtn=sqrt(n);
    int i;
    for(i=2;i<=sqrtn;i++)
    {
        if(n%i==0)
        {
            return false;
        }
    }
    return true;
}
void primepair(int n)
{
    int i,j;
    for(i=2;i<=n;i++)
    {
        if(isprime(i))
        {
            for(j=2;j<=n;j++)
            {
                if(isprime(j))
                {
                    if(i*j<=n)
                    {
                        cout<<i<<" "<<j<<" ";
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
    }
}
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
	    int n;
	    cin>>n;
	    primepair(n);
	    cout<<endl;
	}
	return 0;
}