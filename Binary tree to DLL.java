public class Node
{
	private int data;
	public Node left;
	public Node right;

	public static Node getNode(int x)
	{
		Node temp = new Node();
		temp.data = x;
		return temp;
	}
	
	public static void inorder(Node rt)
	{
		if(rt == null)	return;
		inorder(rt.left);
		System.out.print(rt.data + " ");
		inorder(rt.right);
	}

	private static Node concat(Node a, Node b)
	{
		if(a == null)	return b;
		if(b == null)	return a;
		Node aEnd = a.left;
		Node bEnd = b.left;
		aEnd.right = b;
		bEnd.right = a;
		b.left = aEnd;
		a.left = bEnd;
		return a;
	}

	public static Node convertToDLL(Node rt)
	{
		if(rt == null)	return null;
		Node l = convertToDLL(rt.left);
		Node r = convertToDLL(rt.right);
		rt.left = rt;
		rt.right = rt;
		rt = concat(l,rt);
		rt = concat(rt, r);
		return rt;
	}

	public static void display(Node rt)
	{
		if(rt == null)	return;
		Node rtStart = rt;
		do
		{
			System.out.print(rt.data + " ");
			rt = rt.right;
		}while(rt != rtStart);
	}

	public static void main(String[] args)
	{
		Node rt = getNode(1);
		rt.left = getNode(2);
		rt.left.left = getNode(4);
		rt.left.right = getNode(5);
		rt.right = getNode(3);
		rt.right.left = getNode(6);
		rt.right.right = getNode(7);
		inorder(rt);
		rt = convertToDLL(rt);
		System.out.println();
		display(rt);
	}
}
