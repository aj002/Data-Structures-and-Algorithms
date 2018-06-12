#include<bits/stdc++.h>
using namespace std;
void intersect(int a[], int n, int b[], int m)
{
    //for(int k=0;k<n;k++)    cout<<a[k]<<" ";
    sort(a,a+n);
    sort(b,b+m);
    int i=0,j=0;
    bool flag=false;
    //for(int k=0;k<n;k++)    cout<<a[k]<<" ";
    while(i<n&&j<m)
    {
        if(a[i]==b[j])
        {
            cout<<a[i]<<" ";
            i++;
            j++;
            flag=true;
        }
        else if(a[i]>b[j])
        {
            j++;
        }
        else
        {
            i++;
        }
    }
    if(flag==false)
    {
        cout<<"Zero";
    }
}
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
	    int n,m;
	    cin>>n>>m;
	    int i,a[n],b[m];
	    for(i=0;i<n;i++)
	    {
	        cin>>a[i];
	    }
	    for(int j=0;j<m;j++)
	    {
	        cin>>b[j];
	    }
	    intersect(a,n,b,m);
	    cout<<endl;
	}
	return 0;
}