#include <stdio.h>
#include <stdlib.h>
struct Node
{
    int data;
    struct Node *oldMax;
    struct Node *next;
};
struct Node *stack = NULL;
struct Node *max = NULL;
void push(int x)
{
    struct Node *t = (struct Node*)malloc(sizeof(struct Node));
    t->data = x;
    if(stack == NULL)
    {
        stack = t;
        max = t;
    }
    else
    {
        t->next = stack;
        stack = t;
        if(x > max->data)
        {
            t->oldMax = max;
            max = t;
        }
    }
}
int pop()
{
    if(stack == NULL)
    {
        return -1;
    }
    int x = stack->data;
    struct Node *ptr = stack;
    if(max == ptr)
    {
        max = max->oldMax;
    }
    stack = stack->next;
    free(ptr);
    return x;
}
int getMax()
{
    return max->data;
}
int main() 
{
	push(3);
	push(2);
	push(1);
	printf("%d",getMax());
	pop();
	printf("%d",getMax());
	pop();
	printf("%d",getMax());
	pop();
	return 0;
}