#include<stdio.h>

#define max_size 100

struct stack
{
    int aSize;
    int nStack;
    int a[max_size];
    int top[max_size];
    int next[max_size];
    int nextAvailable;
};

struct stack st;

void push(int x, int sn)
{
	if(st.nextAvailable == -1)
	{
		printf("Overflow");
		return;
	}
	int curr = st.nextAvailable;
	st.nextAvailable = st.next[curr];
	st.top[sn] = curr;
	st.a[st.top[sn]] = x;
}

int pop(int sn)
{
	if(st.top[sn] == -1)
	{
		printf("Underflow");
		return -1;
	}
	int x = st.a[st.top[sn]];
	int curr = st.top[sn];
	st.top[sn] = st.next[curr];
	st.next[curr] = st.nextAvailable;
	st.nextAvailable = curr;
	return x;
}

int main()
{
	int i;	
	printf("Enter array size = ");
	scanf("%d",&st.aSize);
	printf("Enter Number of Stack = ");
	scanf("%d",&st.nStack);
	for(i=0;i<st.aSize;i++)
	{
		st.next[i] = i+1 ;
		//st.a[i] = 0 ;
	}
	st.next[st.aSize-1] = -1;
	for(i=0;i<st.nStack;i++)
	{
	   st.top[i] = -1;
	}
	st.nextAvailable = 0;
	push(5,0);
	push(6,2);
	push(9,2);
	pop(0);
	push(10,0);
	for(i=0;i<st.aSize;i++)
	{
		printf("%d ",st.a[i]);
	}
	return 0;
}
