public class Node
{
	private int data;
	public Node left;
	public Node right;

	public static Node getNode(int val)
	{
		Node temp = new Node();
		temp.data = val;
		return temp;
	}

	public static void inorder(Node rt)
	{
		if(rt == null)	return;
		inorder(rt.left);
		System.out.print(rt.data + " ");
		inorder(rt.right);
	}

	public static Node LCA(Node a, Node b)
	{
		if(a == null)	return b;
		if(b == null)	return a;
		int path_a[] = LCAUtil(a);
		int path_b[] = LCAUtil(b);
		for(int )
	}
	public static void main(String[] args)
	{
		Node rt = getNode(1);
		rt.left = getNode(2);
		rt.right = getNode(3);
		rt.left.left = getNode(4);
		rt.left.right = getNode(5);
		rt.right.left = getNode(6);
		rt.right.right = getNode(7);
		inorder(rt);
		System.out.println(LCA(rt.left.left, rt.left.right).data);
	}
}
