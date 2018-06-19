{
//Initial Template for C++
#include <bits/stdc++.h>
using namespace std;
/* A binary tree node has data, pointer to left child
   and a pointer to right child */
struct Node
{
    int data;
    struct Node* left;
    struct Node* right;
};
/* Helper function that allocates a new node with the
   given data and NULL left and right pointers. */
struct Node* newNode(int data)
{
  struct Node* node = new Node;
  node->data = data;
  node->left = NULL;
  node->right = NULL;
  return(node);
}
/* Computes the number of nodes in a tree. */
void printSibling(Node *);
/* Driver program to test size function*/
int main()
{
  int t;
  scanf("%d
", &t);
  while (t--)
  {
     map<int, Node*> m;
     int n;
     scanf("%d",&n);
     struct Node *root = NULL;
     struct Node *child;
     while (n--)
     {
        Node *parent;
        char lr;
        int n1, n2;
        scanf("%d %d %c", &n1, &n2, &lr);
        if (m.find(n1) == m.end())
        {
           parent = newNode(n1);
           m[n1] = parent;
           if (root == NULL)
             root = parent;
        }
        else
           parent = m[n1];
        child = newNode(n2);
        if (lr == 'L')
          parent->left = child;
        else
          parent->right = child;
        m[n2]  = child;
     }
   printSibling(root);
   cout<<endl;
  }
  return 0;
}

}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

//User function Template for C++
/* Tree node structure  used in the program
 struct Node
 {
     int data;
     Node* left, *right;
}; */
/* Prints the nodes having no siblings.  */
void ps(Node *root, multiset<int> &nodes)
{
   if(root==NULL)
   {
       return;
   }
   else if(root->left!=NULL && root->right==NULL)
   {
       nodes.insert(root->left->data);
       //cout<<root->left->data<<" ";
       
   }
   else if(root->left==NULL && root->right!=NULL)
   {
       nodes.insert(root->right->data);
       //cout<<root->right->data<<" ";
   }
   ps(root->left, nodes);
   ps(root->right, nodes);
}
void printSibling(Node* node)
{
   // Your code here
   multiset<int> nodes;
   ps(node, nodes);
   if(nodes.empty())
   {
       cout<<"-1";
       return;
   }
   multiset<int> :: iterator itr;
   for(itr = nodes.begin();itr!=nodes.end();itr++)
   {
       cout<<*itr<<" ";
   }
}