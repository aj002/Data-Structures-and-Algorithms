import java.util.Queue;
import java.util.LinkedList;

public class Stack
{
	private Queue<Integer> q;
	
	public Stack()
	{
		q = new LinkedList<>();
	}
	
	public void push(int x)
	{
		q.add(x);
		for(x = q.size(); x > 1; x--)
		{
			q.add(q.remove());
		}
	}
	
	public int pop()
	{
		if(q.isEmpty())
		{
			System.out.println("No element in the stack");
			return -1;
		}
		return q.remove();
	}

	public void display()
	{
		for(int x : q)
		{
			System.out.print(x + " ");
		}
		System.out.println();
	}

	public static void main(String args[])
	{
		Stack s = new Stack();
		s.push(5);
		s.push(6);
		s.push(7);
		s.display();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.display();
		s.push(10);
		s.display();
	}
}
