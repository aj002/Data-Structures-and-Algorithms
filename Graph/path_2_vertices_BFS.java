import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

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

	public addEdge(int src, int dest)
	{
		list[src].addLast(dest);
	}

	public LinkedList<Integer> shortestPath(int src, int dest)
	{
		if(src<0 && src>=v)	return null;
		if(dest<0 && dest>=v)	return null;
		Queue<Integer> q = new LinkedList<>();
		HashMap<Integer, Integer> parent = new HashMap<>();
		q.add(src);
		while(!q.isEmpty())
		{
			int curr = q.remove();
			if(curr == dest)	break;
			for(int adj : list[curr])
			{
				if(!parent.containsValue(adj))				
				{
					q.add(adj);
					parent.put(adj, curr);
				}
			}
		}
		if(parent.get(dest) == null) return null;
		LinkedList<Integer> path = new LinkedList<>();
		path.addLast(dest);
		while(parent.get(dest) != null)
		{
			path.addLast(parent.get(dest));
			dest = parent.get(dest);
		}
		return path;
	}

	public static void main(String args[])
	{
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println(shortestpath(1, 3));
	}
}
