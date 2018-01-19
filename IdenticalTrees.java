class Node
{
	int data;
	Node left;
	Node right;
	public Node(data)
	{
		this.data = data;
	}
}

public class Tree
{
	public static boolean isIdentical(Node rt1, Node rt2)
	{
		if(rt1==null && rt2==null)	return true;
		if(rt1.data == rt2.data && isIdentical(rt.left) && isIdentical(rt.right))	return true;
		return false;			
	}

	public static void main(String[] args)
	{
		Node rt1 = new Node(1);
		rt1.left = new Node(2);
		rt1.right = new Node(3);
		rt1.left.left = new Node(4);
		rt1.left.right = new Node(5);

		Node rt2 = new Node(1);
		rt2.left = new Node(2);
		rt2.right = new Node(3);
		rt2.left.left = new Node(4);
		rt2.left.right = new Node(5);

		System.out.println(isIdentical(rt1, rt2));
	}
}
