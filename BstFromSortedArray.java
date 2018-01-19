class Node
{
	int data;
	Node left;
	Node right;
	public Node(int data)
	{
		this.data = data;
	}
}

public class BST
{
	private static Node convertToBSTUtil(int a[], int p, int r)
	{
		if(p>r)	return null;
		int q = (p+r)/2;
		Node rt = new Node(a[q]);
		rt.left = convertToBSTUtil(a, p, q-1);
		rt.right = convertToBSTUtil(a, q+1, r);
		return rt;
	}

	public static Node convertToBST(int a[])
	{
		return convertToBSTUtil(a, 0, a.length-1);
	}

	public static void inorder(Node rt)
	{
		if(rt==null)	return;
		inorder(rt.left);
		System.out.print(rt.data + " ");
		inorder(rt.right);
	}
		
	public static void main(String[] args)
	{
		int a[] = {1, 2, 3, 4};
		Node rt = convertToBST(a);
		inorder(rt);
	}
}
