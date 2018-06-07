import java.util.LinkedList;

public class Graph
{
	private int v;
	private LinkedList<Integer> list[];

	public Graph(int v)
	{
		this.v = v;
		list = new LinkedList[v];
		for(int i=0;i<v;i++)	list[i] = new LinkedList<>();
	}

	public void add(int src, int dest)
	{
		list[src].addFirst(dest);
	}

	private void DFSUtil(int start, boolean visited[])
	{
		visited[start] = true;
		System.out.print(start + " ");
		for(int adj: list[start])
		{
			if(!visited[adj])	DFSUtil(adj, visited);
		}
	}

	public void DFS(int start)
	{
		boolean visited[] = new boolean[v];
		DFSUtil(start, visited);
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
		g.DFS(2);
	}
}
