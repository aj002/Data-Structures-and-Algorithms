import java.util.Stack;

public class Queue
{
	Stack s1;
	Stack s2;

	public Queue()
	{
		s1 = new Stack();
		s2 = new Stack();
	}

	public void enqueue(Object x)
	{
		s1.push(x);
	}

	public void display()
	{
		for(Object x: s1)
		{
			System.out.print(x + " ");
		}
		System.out.println();
	}

	public Object dequeue()
	{
		if(s1.empty())
		{
		    return null;
		}
		while(!s1.empty())
		{
			s2.push(s1.pop());
		}	
		Object x = s2.pop();
		while(!s2.empty())
		{
			s1.push(s2.pop());
		}
		return x;
	}

	public static void main(String[] args)
	{
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue("Arihant");
		q.enqueue(3.45);
		q.enqueue('J');
		q.display();
		q.dequeue();
		q.display();
		q.dequeue();
		q.display();
	}
}
