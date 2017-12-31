#include<stdio.h>
#include<stdlib.h>

int compfunc(const void *a, const void *b)
{
	const int *ia = (const int *)a;
	const int *ib = (const int *)b;
	return (*ia - *ib);
}

void three_sum(int a[], int n, int sum)
{
	int i,nextSum,j,k;
	qsort((void*)a, n, sizeof(int), compfunc);
	for(i=0;i<n;i++)
	{
		nextSum = sum - a[i];
		for(j=i+1,k=n-1;j<k;)
		{
			if(a[j]+a[k] == nextSum)
			{
				printf("Triplet found = %d, %d, %d\n", a[i], a[j++], a[k--]);
			}
			else if(a[j]+a[k] < nextSum)
			{
				j++;
			}
			else
			{
				k--;
			}
		}
	}
}

int main()
{
	int a[] = {1, 4, 45, 6, 10, 8};
	int n = sizeof(a)/sizeof(a[0]);
	int sum = 22;
	three_sum(a,n,sum);
	return 0;
}
