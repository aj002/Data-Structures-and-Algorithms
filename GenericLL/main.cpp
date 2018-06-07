#include <bits/stdc++.h>

using namespace std;

struct Node
{
    void *data;
    char type;
    Node *next;
};

void add(struct Node **head, void *d, char t)
{
    Node *temp = new Node();
    temp->type = t;
    if(t=='c'||t=='C')
    {
        char *ptr = new char;
        *ptr = *(char*)d;
        temp->data = ptr;
    }
    else if(t=='i'||t=='I')
    {
        int *ptr = new int;
        *ptr = *(int*)d;
        temp->data = ptr;
    }
    else if(t=='f'||t=='F')
    {
        float *ptr = new float;
        *ptr = *(float*)d;
        temp->data = ptr;
    }
    else return;
    if(*head == NULL)
    {
        *head=temp;
        temp->next=NULL;
    }
    else
    {
        temp->next=*head;
        *head=temp;
    }
}

void print(struct Node *head)
{
    while(head!=NULL)
    {
        if(head->type=='c'||head->type=='C')    cout<<*(char*)head->data;
        else if(head->type=='i'||head->type=='I')    cout<<*(int*)head->data;
        else if(head->type=='F'||head->type=='f')    cout<<*(float*)head->data;
        head=head->next;
        cout<<" ";
    }
    cout<<endl;
}

int main()
{
    struct Node* head = NULL;
    int ch;
    cout<<"Menu: \n1. Insert at beginning\n2. Print\n3. Exit\n";
    do
    {
        cout<<"Enter choice: ";
        cin>>ch;
        switch(ch)
        {
        case 1:
            char type;
            cout<<"Enter the type of data you want to enter(c/i/f): ";
            cin>>type;
            switch(type)
            {
            case 'c':
                char c;
                cout<<"Enter character type of data: ";
                cin>>c;
                add(&head,&c,type);
                break;
            case 'i':
                int i;
                cout<<"Enter integer type of data: ";
                cin>>i;
                add(&head,&i,type);
                break;
            case 'f':
                float f;
                cout<<"Enter float type of data: ";
                cin>>f;
                add(&head,&f,type);
                break;
            default:
                cout<<"Wrong choice";
            }
            break;
        case 2:
            print(head);
            break;
        default:
            cout<<"Exiting";
            exit(1);
        }
    }while(1);
    return 0;
}
