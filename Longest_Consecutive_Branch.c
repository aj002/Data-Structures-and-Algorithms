#include<stdio.h>
#include<stdlib.h>

typedef struct _node
{
	int data;
	struct _node *left;
	struct _node *right;
}node;

node* newnode(int x)
{
	node *temp = (node *)malloc(sizeof(node));
	temp->data = x;
	temp->left = temp->right = NULL;
	return temp;
}

void inorder(node *rt)
{
	if(rt==NULL)	return;
	inorder(rt->left);
	printf("%d ",rt->data);
	inorder(rt->right);
}

void LCUtil(node *rt, int currL, int expected, int *max)
{
	if(rt==NULL)	return;
	if(rt->data == expected)	currL++;
	else	currL = 1;
	*max = (*max > currL) ? *max : currL;
	LCUtil(rt->left, currL, rt->data + 1, max);
	LCUtil(rt->right, currL, rt->data + 1, max);
}

int LC(node *rt)
{
	if(rt==NULL)	return 0;
	int max = 0;
	LCUtil(rt, 0, rt->data, &max);
	return max;
}

int main()
{
	node *rt = newnode(6);
	rt->right = newnode(9);
	rt->right->left = newnode(7);
	rt->right->right = newnode(10);
	rt->right->right->right = newnode(11);
	inorder(rt);
	printf("\n%d\n", LC(rt));

	rt = newnode(1);
	rt->left = newnode(2);
	rt->left->left = newnode(3);
	rt->right = newnode(4);
	rt->right->left = newnode(5);
	rt->right->right = newnode(6);
	rt->right->right->left = newnode(7);
	inorder(rt);
	printf("\n%d\n", LC(rt));
	return 0;
}
