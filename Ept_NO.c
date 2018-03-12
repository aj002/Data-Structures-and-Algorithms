#include<stdio.h>
#include<math.h>
int main() 
{
    double n = 10.0, d = 14.0;
    while(n>1)
    {
        int x = (int)ceil(d/n);
        printf("1/%d\n", x);
        n = n*x - d;
        d = x*d;
    }
    return 0;
}

