import java.util.Stack;

public class Node
{
	public int data;
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

	public static Node LCA(Node rt, Node a, Node b)
	{
		if(a == null)	return b;
		if(b == null)	return a;
		Stack<Node> path_a = pathTo(rt, a);
		Stack<Node> path_b = pathTo(rt, b);
		Node lca = null;
		while(!path_a.empty() && !path_b.empty())
		{
			Node x = path_a.pop();
			Node y = path_b.pop();
			if(x == y)
			{
				lca = x;
			}
		}
		return lca;
	}

	private static Stack<Node> pathTo(Node rt, Node a)
	{
		if(rt == null)	return null;
		if(rt == a)
		{
			Stack<Node> s = new Stack<>();
			s.push(a);
			return s;
		}
		Stack<Node> l = pathTo(rt.left, a);
		Stack<Node> r = pathTo(rt.right, a);
		if(l != null)
		{
			l.push(rt);
			return l;
		}
		if(r != null)
		{
			r.push(rt);
		}
		return r;
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
		System.out.println();
		Node lca = LCA(rt, rt.right.left, rt.right);
		System.out.println(lca.data);
	}
}
