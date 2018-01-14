class Node
{
	int data;
	Node r;		//random ptr
	Node n;		//next ptr
	public Node(int data)
	{
		this.data = data;
		r=n=null;
	}
}

public class Clone_LL
{
	public static void display(Node original)
	{
		while(original != null)
		{
			System.out.println(original.data + "\t" + original.r.data);
			original = original.n;
		}
	}

	public static Node clone(Node original)
	{
		Node curr = original;
		while(curr != null)
		{
			Node temp = curr.n;
			curr.n = new Node(curr.data);
			curr.n.n = temp;
			curr = temp;
		}
		curr = original;
		while(curr != null)
		{
			curr.n.r = curr.r.n;
			curr = curr.n.n;
		}
		Node copy = original.n;
		curr = original;
		while(curr != null)
		{
			Node temp1 = curr.n;
			Node temp2 = curr.n.n;
			curr.n = temp2;
			if(temp2 != null) temp1.n = temp2.n;
			curr = temp2;
		}
		return copy;
	}
	public static void main(String[] args)
	{
		Node original = new Node(1);
		original.n = new Node(2);
		original.n.n = new Node(3);
		original.n.n.n = new Node(4);
		original.n.n.n.n = new Node(5);
		
		original.r = original.n.n;
		original.n.r = original;
		original.n.n.r = original.n.n.n.n;
		original.n.n.n.r = original.n.n;
		original.n.n.n.n.r = original.n;

		System.out.println("Original Linked List");
		display(original);
		Node copy = clone(original);
		System.out.println("Copied Linked List");
		display(copy);
	}
}
