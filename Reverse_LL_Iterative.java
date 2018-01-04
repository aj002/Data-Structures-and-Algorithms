public class Node
{
	private int data;
	private	Node next;

	public static Node getNewNode(int x)
	{
		Node temp = new Node();
		temp.data = x;
		return temp;
	}

	public static void display(Node head)
	{
		if(head==null)	return;
		for(;head != null;head=head.next)	System.out.print(head.data + " ");
		System.out.println();
	}

	public static Node reverse(Node head)
	{
		Node prev=null, temp, curr = head;
		while(curr!=null)
		{
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		head = prev;
		return head;
	}
	
	public static void main(String args[])
	{
		Node head = getNewNode(1);
		head.next = getNewNode(2);
		head.next.next = getNewNode(3);
		head.next.next.next = getNewNode(4);
		display(head);
		head = reverse(head);
		display(head);
	}	
}
