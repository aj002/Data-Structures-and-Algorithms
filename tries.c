#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

#define max_size 26
#define CHAR_TO_INDEX(x) ((int)x - (int)'a')
#define ARRAY_SIZE(x) (sizeof(x)/sizeof(x[0]))

struct trieNode
{
	struct trieNode *children[max_size];
	bool end;
};

struct trieNode* getNode(void)
{
	struct trieNode *ptr = (struct trieNode*)malloc(sizeof(struct trieNode));
	ptr->end = false;
	int i;
	for(i=0;i<max_size;i++)	
	{
		ptr->children[i] = NULL;
	}
	return ptr;
}

void insert(struct trieNode *rt, const char key[])
{
	int len = strlen(key);
	int i;
	int index;
	struct trieNode *ptr = rt;
	for(i=0;i<len;i++)
	{
		index = CHAR_TO_INDEX(key[i]);
		if(ptr->children[index] == NULL)
		{
			ptr->children[index] = getNode();
		}
		ptr = ptr->children[index];
	}
	ptr->end = true;
}

bool search(struct trieNode *rt, const char key[])
{
	int len = strlen(key);
	int index;
	int i;
	struct trieNode *ptr = rt;
	for(i=0;i<len;i++)
	{
		index = CHAR_TO_INDEX(key[i]);
		if(ptr->children[index] == NULL)
		{
			return false;
		}
		ptr=ptr->children[index];
	}
	return (ptr->end && ptr!=NULL);
}

int main(void) 
{
	char keys[][8] = { "the", "a", "there", "answer", "any", "bye", "by", "there" };
	char output[][50] = { "Not present in the trie", "Present in the trie" };
	
	struct trieNode *root = getNode();

	int i;
	for(i=0;i<ARRAY_SIZE(keys);i++)
	{
		insert(root, keys[i]);
	}

	printf("this = %s\n",output[search(root,"this")]);
	printf("a = %s\n",output[search(root,"a")]);
	printf("there = %s\n",output[search(root,"there")]);
	printf("an = %s\n",output[search(root,"an")]);

	return 0;
}
