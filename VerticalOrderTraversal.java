import java.util.HashMap;
import java.util.LinkedList;

class Node
{
	public int data;
	public Node left;
	public	Node right;
	public Node(int data)
	{
		this.data = data;
	}
}

public class VerticalOrderTraversal
{
	HashMap<Integer, LinkedList<Node>> hm = new HashMap<>();

	private void traverseUtil(Node rt, int hd)
	{
		if(rt == null)	return;
		traverseUtil(rt.left, hd-1);
		if(hm.containsKey(hd))
		{
			LinkedList<Node> l = hm.get(hd);
			l.addFirst(rt);
			hm.put(hd, l);
		}
		else
		{
			LinkedList<Node> l = new LinkedList<>();
			l.addFirst(rt);
			hm.put(hd, l);
		}
		traverseUtil(rt.right, hd+1);
	}

	public void traverse(Node rt)
	{
		if(rt == null)	return;
		traverseUtil(rt, 0);
	}

	public void display()
	{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int x: hm.keySet())
		{
			min = Math.min(x, min);
			max = Math.max(x, max);
		}
		for(int i=min;i<=max;i++)
		{
		    for(Node x: hm.get(i))
		    {
		        System.out.print(x.data + " ");
		    }
		    System.out.println();
		}
	}

	public static void main(String[] args)
	{
		Node rt = new Node(1);
		rt.left = new Node(2);
		rt.left.left = new Node(4);
		rt.left.right = new Node(5);
		rt.right = new Node(3);
		rt.right.left = new Node(6);
		rt.right.left.right = new Node(8);
		rt.right.right = new Node(7);
		rt.right.right.right = new Node(9);
		VerticalOrderTraversal vot = new VerticalOrderTraversal();
		vot.traverse(rt);
		vot.display();
	}
}
