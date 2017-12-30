#include<stdio.h>
#include<stdlib.h>

int comp_func(const void *a, const void *b)
{
	const int ia = *(const int *)a;
	const int ib = *(const int *)b;
	if((ia&1) && (ib&1))
	{
		return (ib - ia);
	}
	if(!(ia&1) && !(ib&1))
	{
		return (ia - ib);
	}
	if(!(ia&1))
	{
		return 1;
	}
	return -1;
}

int main()
{
	int a[] = {1, 6, 5, 2, 3, 9, 4, 7, 8};
	int n = sizeof(a)/sizeof(a[0]);
	int i;
	for(i=0;i<n;i++)	printf("%d ", a[i]);
	qsort((void*)a, n, sizeof(int), comp_func);
	printf("\n");
	for(i=0;i<n;i++)	printf("%d ", a[i]);
	return 0;
}
