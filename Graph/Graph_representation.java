import java.util.LinkedList;
class Graph
{
	private int v;
	private LinkedList<Integer> list[];
	
	public Graph(int v)
	{
		this.v = v;
		list = new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			list[i] = new LinkedList<>();
		}
	}

	public void addEdge(int src, int dest)
	{
		list[src].addFirst(dest);
		list[dest].addFirst(src);
	}

	public void print()
	{
		for(int i=0;i<v;i++)
		{
			System.out.print(i + "\t->" + "\t");
			for(int x : list[i])
			{
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.print();
	}
}

