#include <stdio.h>

void max_heapify_top(int a[], int i, int size)
{
    int l = 2*i;
    int r = 2*i + 1;
    int largest = i;
    if(l<=size && a[l]>a[largest]) largest = l;
    if(r<=size && a[r]>a[largest]) largest = r;
    if(largest!=i)
    {
        int t = a[largest];
        a[largest]=  a[i];
        a[i] = t;
        max_heapify_top(a, largest, size);
    }
}

int main() 
{
	//code
	int t;
	scanf("%d", &t);
	while(t--)
	{
	    int n,k,C[105],i,t;
	    scanf("%d%d", &n, &k);
	    for(i=1;i<=n;i++)
	    {
	        scanf("%d", &C[i]);
	    }
	    for(i=n/2;i>=1;i--)
	    {
	        max_heapify_top(C, i, n);
	    }
	    for(i=0;i<k;i++)
	    {
	        printf("%d ", C[1]);
	        t=C[1];
	        C[1]=C[n];
	        C[n]=t;
	        n--;
	        max_heapify_top(C, 1, n);
	    }
	    printf("\n");
	}
	return 0;
}
