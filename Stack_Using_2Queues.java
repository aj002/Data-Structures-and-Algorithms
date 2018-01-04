import java.util.Queue;
import java.util.LinkedList;

public class Stack
{
	private Queue<Integer> q1, q2;
	
	public Stack()
	{
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}
	
	public void push(int x)
	{
		q2.add(x);
		while(!q1.isEmpty())
		{
			q2.add(q1.remove());
		}
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}
	
	public int pop()
	{
		if(q1.isEmpty())
		{
			System.out.println("No element in the stack");
		}
		return q1.remove();
	}

	public void display()
	{
		for(int x : q1)
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
		s.display();
		s.push(10);
		s.display();
	}
}
