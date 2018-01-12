import java.util.Stack;

public class Sort_Stack
{
	public static Stack<Integer> sort(Stack<Integer> s)
	{
		if(s.empty())	return s;

		Stack<Integer> temp = new Stack<>();
		while(!s.empty())
		{
			int x = s.pop();
			int count = 0;
			while(!temp.empty() && temp.peek() > x)
			{
				s.push(temp.pop());
				count++;
			}
			temp.push(x);
			while(count>0)
			{
				temp.push(s.pop());
				count--;
			}
		}
		return temp;
	}

	public static void main(String[] args)
	{
		Stack<Integer> s = new Stack<>();
		s.push(30);
		s.push(-5);
		s.push(18);
		s.push(14);
		s.push(-3);
		System.out.println(s);
		s = sort(s);
		System.out.println(s);
	}
}
