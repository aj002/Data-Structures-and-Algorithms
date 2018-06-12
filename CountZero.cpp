#include <bits/stdc++.h>
using namespace std;
unsigned long long int CZutil(int d)
{
    return 9*(pow(10,d-1)-pow(9,d-1));
}
unsigned long long int CZ(int d)
{
    int i;
    unsigned long long int sum = 0;
    for(i=1;i<=d;i++)
    {
        sum+=CZutil(i);
    }
    return sum;
}
int main() 
{
	int t;
	cin>>t;
	while(t--)
	{
	    int d;
	    cin>>d;
	    cout<<CZ(d);
	    cout<<endl;
	}
}
