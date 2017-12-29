#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

#define max_size 1000

struct node
{
	int data;
	struct node *next;
};

void insert(struct node **head,int x)
{
	struct node *temp = (struct node*)malloc(sizeof(struct node));	
	temp->data = x;
	if(*head==NULL)
	{
		*head = temp;
		temp->next = NULL;
	}
	else
	{
		temp->next = *head;
		*head = temp;
	}
}

void display(struct node *curr)
{
	while(curr!=NULL)
	{
		printf("%d ",curr->data);
		curr = curr->next;
	}
}

bool ispal(struct node *head)
{
	struct node *curr = head;	
	struct node *runner = curr;
	while(runner!=NULL && runner->next!=NULL)
	{
		curr =curr->next;
		runner = runner->next->next;
	}
	int a[max_size],top=-1;
	if(runner==NULL)
	{
		//printf("Even Length Linked List");
		for(runner = head;runner!=curr;runner=runner->next)
		{
			a[++top] = runner->data;
		}
	}
	else
	{
		for(runner = head;runner!=curr->next;runner=runner->next)
		{
			a[++top] = runner->data;
		}
	}
	for(curr=curr;curr!=NULL;curr=curr->next)
	{
		if(a[top--]!=curr->data)
		{
			return false;
		}
	}
	return true;
}

int main()
{
	struct node *head = NULL;
	insert(&head,1);
	insert(&head,2);
	insert(&head,2);
	insert(&head,3);
	insert(&head,1);
	display(head);
	printf("\n%d",ispal(head));
	return 0;
}

