#include <bits/stdc++.h>
using namespace std;
long long int PG(int a[], int n)
{
    long long int count=0;
    int n0=0,n1=0,n2=0;
    int i;
    for(i=0;i<n;i++)
    {
        int rem = a[i]%3;
        if(rem==0)
        {
            n0++;
        }
        else if(rem==1)
        {
            n1++;
        }
        else
        {
            n2++;
        }
    }
    //cout<<n0<<" "<<n1<<" "<<n2<<endl;
    count+=n0*(n0-1)/2;
    count+=n1*n2;
    count+=n0*(n0-1)*(n0-2)/6;
    count+=n0*n1*n2;
    count+=n1*(n1-1)*(n1-2)/6;
    count+=n2*(n2-1)*(n2-2)/6;
    return count;
}
int main() 
{
	int t;
	cin>>t;
	while(t--)
	{
	    int n;
	    cin>>n;
	    int i,a[n];
	    for(i=0;i<n;i++)
	    {
	        cin>>a[i];
	    }
	    cout<<PG(a,n);
	    cout<<endl;
	}
	return 0;
}