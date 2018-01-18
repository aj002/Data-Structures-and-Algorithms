import java.util.LinkedList;

class Graph
{
	private int v;
	private LinkedList<Integer> link[];

	public Graph(int v)
	{
		this.v = v;
		link = new LinkedList[v];

		for(int i=0;i<v;i++)
		{
			link[i] = new LinkedList<>();
		}
	}

	public void add(int src, int dest)
	{
		link[src].addFirst(dest);
	}

	public void display()
	{
		for(int i=0;i<v;i++)
		{
			System.out.print(i + "->\t");
			for(int x: link[i])
			{
				System.out.print(x + "\t");
			}
		}
	}

	public static void main(String[] args)
	{
		Graph g = new Graph(4);
		g.add(0, 1);
		g.add(0, 2);
		g.add(1, 2);
		g.add(2, 0);
		g.add(2, 3);
		g.add(3, 3);
		g.display();
	}
}
