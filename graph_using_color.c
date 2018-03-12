#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node
{
	int data;
	struct node *next;
};

struct Graph
{
	int v;
	struct node* list[100];
};

void addEdge(struct Graph **g, int src, int des)
{
	struct node *temp = (struct node*)malloc(sizeof(struct node));
	temp->data = des;	
	if((*g)->list[src]==NULL)
	{
		temp->next = NULL;
		(*g)->list[src] = temp;
	}
	else
	{
		temp->next = (*g)->list[src];
		(*g)->list[src] = temp;
	}
}

void print(struct Graph *g)
{
	for(int i=0;i<g->v;i++)
	{
		printf("\n%d-> ", i);
		struct node *curr = g->list[i];
		while(curr!=NULL)
		{
			printf("%d, ", curr->data);
			curr = curr->next;
		}
	}
}

void initialize(struct Graph **g, int x)
{
    (*g) = (struct Graph*)malloc(sizeof(struct Graph));
    (*g)->v = x;
    for(int i=0;i<x;i++)
    {
        (*g)->list[i] = NULL;
    }
}

void BFS(struct Graph *g, int s)
{
    bool visited[g->v];
    for(int i=0;i<g->v;i++)
    {
        visited[i] = false;
    }
    int queue[g->v];
    int f=0,r=0;
    queue[0] = s;
    printf("\nBFS = ");
    while(f<=r)
    {
        int temp = queue[f];
        f++;
        printf("%d, ", temp);
        visited[temp] = true;
        struct node *curr = g->list[temp];
        while(curr!=NULL)
        {
            if(!visited[curr->data])
            {
                queue[++r] = curr->data;
            }
            curr = curr->next;
        }
    }
}

int main() 
{
    struct Graph* g = NULL;
	initialize(&g, 4);
	addEdge(&g, 0, 1);
	addEdge(&g, 0, 2);
	addEdge(&g, 1, 2);
	addEdge(&g, 2, 0);
	addEdge(&g, 2, 3);
	addEdge(&g, 3, 3);
	print(g);
	BFS(g, 2);
}

