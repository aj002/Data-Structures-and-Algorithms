import java.util.Stack;

public class Queue
{
	Stack<Integer> s1;
	Stack<Integer> s2;

	public Queue()
	{
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	public void enqueue(int x)
	{
		while(!s1.empty())
		{
			s2.push(s1.pop());
		}
		s1.push(x);
		while(!s2.empty())
		{
			s1.push(s2.pop());
		}
	}

	public void display()
	{
		for(int x: s1)
		{
			System.out.print(x + " ");
		}
		System.out.println();
	}

	public int dequeue()
	{
		if(s1.empty())
		{
			return -1;
		}
		return s1.pop();
	}

	public static void main(String[] args)
	{
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.display();
		q.dequeue();
		q.display();
		q.dequeue();
		q.display();
	}
}
