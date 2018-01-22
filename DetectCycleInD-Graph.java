import java.util.LinkedList;

public class Graph
{
	private int v;
	private LinkedList<Integer> adj[];

	public Graph(int v)
	{
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)	adj[i] = new LinkedList<>();
	}

	public void add(int src, int dest)
	{
		adj[src].addFirst(dest);
	}

	public boolean hasCycle()
	{
		
	public static void main(String[] args)
	{
		Graph g = new Graph(4);
		g.add(0, 1);
		g.add(0, 2);
		g.add(1, 2);
		g.add(2, 0);
		g.add(2, 3);
		g.add(3, 3);
		g.DFS(2);
	}
}
