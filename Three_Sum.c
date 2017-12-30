#include<stdio.h>

int compfunc(const void *a, const void *b)
{
	const int *ia = (const int *)a;
	const int *ib = (const int *)b;
	return (*ia - *ib);
}

void three_sum(int a[], int n, int sum)
{
	qsort((void*)a, n, sizeof(int), compfunc);
	int i,nextSum,j;
	for(i=0;i<n;i++)
	{
		nextSum = sum - a[i];
		for(j=i+1;j<n;j++)
		{
			 

int main()
{
	int a[] = {12, 3, 4, 1, 6, 9};
	int n = sizeof(a)/sizeof(a[0]);
	three_sum(a,n,24);
	return 0;
}
