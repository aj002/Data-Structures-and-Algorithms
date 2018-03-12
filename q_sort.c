#include<stdio.h>
#include<stdlib.h>
int compareOE(const void *a, const void *b)
{
    int l = *(const int *)a;
    int r = *(const int *)b;
    if(l==r)
    {
        return 0;
    }
    if(l%2!=0)
    {
        if(r%2!=0)
        {
            if(l>r)
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }
        else
        {
            return -1;
        }
    }
    else
    {
        if(r%2!=0)
        {
            return 1;
        }
        else
        {
            if(l>r)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
    }
}
int compareA(const void *a, const void *b)
{
    int l = *(const int *)a;
    int r = *(const int *)b;
    if(l==r)    return 0;
    if(l>r)     return 1;
    return -1;
}
int main() 
{
    int a[] = {1, 2, 3, 5, 4, 7, 10};
    qsort(a, sizeof(a)/sizeof(a[0]), sizeof(int), compareA);
    for(int i=0;i<sizeof(a)/sizeof(a[0]);i++)
    {
        printf("%d ", a[i]);
    }
}

